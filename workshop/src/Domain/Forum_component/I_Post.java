package Domain.Forum_component;

import java.util.Date;
import java.util.Vector;

import Domain.User_component.I_Member;
import Domain.User_component.I_User;

public interface I_Post {

	public abstract I_Sub_Forum getSub();

	public abstract String getHeader();

	public abstract void setHeader(I_User user, String header);

	public abstract String getBody();

	public abstract void setBody(I_User user, String body);

	public abstract I_User getAuthor();

	public abstract Date getTime();

	public abstract I_Post getParent();

	public abstract Vector<Post> getKids();

	public abstract I_Post addKid(Post post);

	public abstract void remove_post();

	public abstract void remove_one_post();

	public abstract I_Post comment(String header, String body, I_User u);

	public abstract String tabs(int times);

	public abstract String print_thread(int tabs);

	public abstract boolean isAuthor(I_Member member);

}