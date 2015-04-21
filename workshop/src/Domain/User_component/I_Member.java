package Domain.User_component;

import java.util.Vector;

import Domain.Forum_component.I_Forum;
import Domain.Forum_component.Sub_Forum;

public interface I_Member extends I_User{

	public abstract String getPassword();

	public abstract void setPassword(String password);

	public abstract Vector<Member> getFriends();

	public abstract void setFriends(Vector<Member> friends);

	public abstract Boolean getConnected();

	public abstract void setConnected(Boolean connected);

	public abstract Boolean getIsActive();

	public abstract void setIsActive(Boolean isActive);

	public abstract void add_mif(MemberInForum mif);

	public abstract void addFriend(Member f);

	public abstract Vector<Sub_Forum> getSubForumsPosted();

	public abstract void addSubForumsPosted(Sub_Forum subForumsPosted);

	public abstract String getEmail();

	public abstract void setEmail(String email);

	public abstract double getAge();

	public abstract void setAge(double age);

	public abstract Vector<MemberInForum> getMembersInForum();

	public abstract I_MIF get_mif(I_Forum f);

	public abstract String getName();

}