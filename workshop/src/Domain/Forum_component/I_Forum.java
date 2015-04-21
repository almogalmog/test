package Domain.Forum_component;

import java.util.Vector;

import Domain.User_component.I_Member;
import Domain.User_component.I_User;
import Domain.User_component.Member;
import Domain.User_component.MemberInForum;
import Domain.User_component.User;

public interface I_Forum {

	// why do we return the subs here and return thr forum when member login?
	// mayb we should return here also "this"
	// i changed it from private to public (malachi)
	public abstract Vector<Sub_Forum> loginGuest();

	public abstract I_Sub_Forum createSubForum(String name, String subject,
			Vector<Member> moderators);

	// i changed it from private to public (malachi)
	public abstract void logout(I_User user);

	// for members only
	public abstract I_Forum login(String namail, String password);

	// to register as member
	public abstract I_Forum register(Member member);

	public abstract Vector<User> getUsers();

	public abstract void addUser(User user);

	public abstract void add_type(String type, I_User user);

	public abstract void remove_type(String type, I_User user);

	public abstract int getNumOfTypes(I_User user);

	public abstract Vector<String> getTypes(I_User user);

	public abstract Vector<Member> getSuspend_members();

	public abstract void Suspend_member(Member suspended_member);

	public abstract void unsuspend_member(Member member);

	public abstract Vector<Member> getAdmins();

	public abstract void setAdmins(Vector<Member> admins);

	public abstract Vector<Member> getSuspended_admins();

	public abstract void addSuspended_admins(Member suspended_admin);

	public abstract Vector<Sub_Forum> getSubs(I_User user);

	public abstract I_Forum_Ruels getRuels();

	public abstract void delete_sub(I_Sub_Forum sub, I_User user);

	public abstract boolean isMember(I_Member member);

	public abstract boolean isMember(String name);

	public abstract boolean isUser(String name);

	public abstract Member getMember(String name);

	public abstract String getName();

	public abstract String getSubject();

}