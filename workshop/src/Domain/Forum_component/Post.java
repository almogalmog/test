package Domain.Forum_component;

import java.util.Date;
import java.util.Vector;

import Domain.User_component.Member;
import Domain.User_component.User;

public class Post {
	private String header;
	private String body;
	private final User author;
	private final Date time;
	private final Post parent; // can be null
	private Vector<Post> kids;
	private final Sub_Forum sub;

	public Post(String header, String body, User author, Post parent,Sub_Forum sub) {
		this.header = header;
		this.body = body;
		this.author = author;
		this.time = new Date();
		this.parent = parent;
		this.kids = new Vector<Post>();
		this.sub = sub;
	}

	
	public Sub_Forum getSub() {
		return this.sub;
	}

	
	public String getHeader() {
		return header;
	}

	
	public void setHeader(User user,String header) {
		if (this.author==user)
		this.header = header;
	}

	
	public String getBody() {
		return body;
	}

	
	public void setBody(User user, String body) {
		if (this.author==user)
			this.body = body;

	}

	
	public User getAuthor() {
		return author;
	}

	
	public Date getTime() {
		return time;
	}

	
	public Post getParent() {
		return parent;
	}

	
	public Vector<Post> getKids() {
		return this.kids;
	}

	
	public Post addKid(Post post) {
		this.kids.add(post);
		return post;
	}

	
	public void remove_post() {		
		while(this.kids.size()!=0){
			kids.get(0).remove_post();//remove_post();
		}
		this.remove_one_post();

	}

	
	public void remove_one_post() {		
		if (this.getParent() == null)
			this.getSub().getThreads().remove(this);
		else
			this.parent.getKids().remove(this);
	}

	
	public Post comment(String header, String body, User u) {
		Post p = new Post(header, body, u, this, this.sub);
		this.addKid(p);
		return p;
	}


	
	public String tabs(int times){
		StringBuilder sb= new StringBuilder();
		while(times!=0){
			sb.append("   ");
			times--;
		}
		return sb.toString();
	}

	
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
	
	public boolean isAuthor(Member member){
		return (author==member);
	}


}
