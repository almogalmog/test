package Domain.Forum_component;

import java.util.Vector;

import Domain.User_component.Member;
import Domain.User_component.Super_Admin;

public interface I_Forum_System {

	public abstract Super_Admin getSuper_admin();

	public abstract void setSuper_admin(Super_Admin super_admin);

	public abstract Vector<Forum> getForums();

	public abstract void setForums(Vector<Forum> forums);

	public abstract I_Forum addForum(Vector<Member> admins, I_Forum_Ruels ruels,
			String name, String subject);

	public abstract Member addMember(String username, String password,
			String email, double age);

	public abstract Vector<Member> getMembers();

	public abstract Member searchMemberByName(String name);
}