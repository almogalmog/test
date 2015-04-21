package Domain.Forum_component;

import java.util.Vector;

import Domain.User_component.I_Member;
import Domain.User_component.I_User;
import Domain.User_component.Member;

public interface I_Sub_Forum {

	public abstract String getSubject();

	public abstract void setSubject(String subject);

	public abstract Vector<Member> getSuspended_Moderators();

	public abstract Vector<Member> getModerators();

	public abstract void add_Moderator(Member moderator);

	public abstract Vector<Post> getThreads();

	public abstract I_Post add_thread(String header, String body, I_User u);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract I_Member has_moderator(String mod_name);

	public abstract I_Member has_moderator(I_Member mod);

	public abstract boolean add_Suspended_Moderator(String mod_name);

	public abstract I_Member has_suspended_moderator(String mod_name);

	public abstract boolean sendComplaint(I_Member member, String Complaint,
			I_Member moderator);

	public abstract boolean isAuthor(Vector<Post> kids, I_Member mem);

}