package Domain.Forum_component;

import java.util.Date;
import java.util.Vector;

import Domain.User_component.I_Member;
import Domain.User_component.I_User;

public class Post implements I_Post {
	private String header;
	private String body;
	private final I_User author;
	private final Date time;
	private final I_Post parent; // can be null
	private Vector<Post> kids;
	private final I_Sub_Forum sub;

	public Post(String header, String body, I_User author, I_Post parent,I_Sub_Forum sub) {
		this.header = header;
		this.body = body;
		this.author = author;
		this.time = new Date();
		this.parent = parent;
		this.kids = new Vector<Post>();
		this.sub = sub;
	}

	@Override
	public I_Sub_Forum getSub() {
		return this.sub;
	}

	@Override
	public String getHeader() {
		return header;
	}

	@Override
	public void setHeader(I_User user,String header) {
		if (this.author==user)
		this.header = header;
	}

	@Override
	public String getBody() {
		return body;
	}

	@Override
	public void setBody(I_User user, String body) {
		if (this.author==user)
			this.body = body;

	}

	@Override
	public I_User getAuthor() {
		return author;
	}

	@Override
	public Date getTime() {
		return time;
	}

	@Override
	public I_Post getParent() {
		return parent;
	}

	@Override
	public Vector<Post> getKids() {
		return this.kids;
	}

	@Override
	public I_Post addKid(Post post) {
		this.kids.add(post);
		return post;
	}

	@Override
	public void remove_post() {		
		while(this.kids.size()!=0){
			kids.get(0).remove_post();//remove_post();
		}
		this.remove_one_post();

	}

	@Override
	public void remove_one_post() {		
		if (this.getParent() == null)
			this.getSub().getThreads().remove(this);
		else
			this.parent.getKids().remove(this);
	}

	@Override
	public I_Post comment(String header, String body, I_User u) {
		Post p = new Post(header, body, u, this, this.sub);
		this.addKid(p);
		return p;
	}


	@Override
	public String tabs(int times){
		StringBuilder sb= new StringBuilder();
		while(times!=0){
			sb.append("   ");
			times--;
		}
		return sb.toString();
	}

	@Override
	public String print_thread(int tabs){
		StringBuilder sb = new StringBuilder();
		sb.append(tabs(tabs));
		sb.append("*"+this.getHeader()+"*"+" : "+this.getBody()+"\n");
		sb.append(tabs(tabs));
		sb.append(this.author.getName()+", "+this.getTime()+"\n");
		tabs++;
		for (int i = 0; i < this.getKids().size(); i++) 
			sb.append(this.getKids().get(i).print_thread(tabs));		

		return sb.toString();
	}
	@Override
	public boolean isAuthor(I_Member member){
		return (author==member);
	}


}
