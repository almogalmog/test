package Domain.Forum_component;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import Domain.User_component.Guest;
import Domain.User_component.Member;
import Domain.User_component.MemberInForum;
import Domain.User_component.Super_Admin;
import Domain.User_component.User;

public class Forum {
	private final Forum_System fs;
	private Vector<Guest> guests;
	private Vector<String> members;
	private Vector<Member> suspended_members;
	private Vector<Member> admins;
	private Vector<Member> suspended_admins;
	private Vector<Sub_Forum> subs;
	private Logger Alogger;
	private Logger Elogger;
	private Forum_Ruels ruels;
	private Vector<String> friends_types;
	private Vector<MemberInForum> members_in_forum;
	private int guest_num;
	private String name;
	private String subject;

	public Forum(String name, String subject, Vector<Member> admins,
			Forum_Ruels ruels, Forum_System fs) {
		this.guests = new Vector<Guest>();
		this.fs = fs;
		this.name = name;
		this.subject = subject;
		this.members = new Vector<String>();
		this.suspended_members = new Vector<Member>();
		this.admins = admins;
		this.suspended_admins = new Vector<Member>();
		this.subs = new Vector<Sub_Forum>();
		this.ruels = ruels;
		this.Alogger = Logger.getLogger("Action logger");
		this.Elogger = Logger.getLogger("Error logger");
		this.members_in_forum = new Vector<>();
		this.friends_types = new Vector<String>();
		this.guest_num = 0;
		friends_types.add("Gold");
		friends_types.add("Silver");
		friends_types.add("Basic");

	}

	private void setProperties(int numberOfModerator, String passwordStrength) {
		ruels.setNumberOfModerators(numberOfModerator);
		ruels.setPasswordStrengh(passwordStrength);
	}

	// why do we return the subs here and return thr forum when member login?
	// mayb we should return here also "this"
	// i changed it from private to public (malachi)

	public Vector<Sub_Forum> loginGuest() {
		Guest guest = new Guest(this, guest_num++);
		addUser(guest.getName());
		this.guests.add(guest);
		return subs;
	}

	public Sub_Forum createSubForum(String name, String subject,
			Vector<Member> moderators) {

		if (name == null || subject == null || moderators == null)
			Elogger.log(Level.WARNING, "Invalid argument/s");

		else {
			Alogger.log(Level.INFO, "You create Sub Forum successfully");
			Sub_Forum subForum = new Sub_Forum(name, subject, moderators, this);
			this.subs.add(subForum);
			return subForum;
		}
		return null;
	}

	// i changed it from private to public (malachi)

	public void logout(String user) {
		if (members.contains(user)) {
			(fs.get_member_by_name(user)).get_MemberInForum(this).setConnected(
					false);
		} else
			// i'm a guest, remove me
			guests.remove(user);
	}

	// for members only

	public Forum login(String name, String password) {
		if (name != null && password != null) {
			if (members.contains(name)
					&& fs.get_member_by_name(name).getPassword()
							.equals(password))
				for (MemberInForum MemberInForum : members_in_forum)
					if (MemberInForum.getMember().equals(name)) {
						MemberInForum.setConnected(true);
						Alogger.log(Level.INFO, "You login");
						return this;
					}

		}
		Elogger.log(Level.WARNING, "invalid name or password");
		return null;
	}

	// to register as member

	public Forum register(String name) {
		members.add(name);
		MemberInForum MemberInForum = new MemberInForum(name, this);
		fs.get_member_by_name(name).add_MemberInForum(MemberInForum);
		this.members_in_forum.add(MemberInForum);

		return this;
	}

	public Vector<String> getUsers() {
		return members;
	}

	public void addUser(String user) {
		this.members.add(user);
	}

	public void add_type(String type, User user) {
		if (user instanceof Super_Admin && !friends_types.contains(type))
			this.friends_types.add(type);
	}

	public void remove_type(String type, User user) {
		if (user instanceof Super_Admin && friends_types.contains(type))
			this.friends_types.remove(type);
	}

	public int getNumOfTypes(User user) {
		if (user instanceof Super_Admin)
			return this.friends_types.size();
		else
			return -1;
	}

	public Vector<String> getTypes(String anme) {
		for (Member m : admins)
			if (m.getName().equals(anme) && m instanceof Super_Admin)
				return this.friends_types;

		System.out.println("only sa can get the users types!");
		return null;
	}

	public Vector<Member> getSuspend_members() {
		return suspended_members;
	}

	public void Suspend_member(Member suspended_member) {
		this.members.remove(suspended_member);
		this.suspended_members.add(suspended_member);
	}

	public void unsuspend_member(String member) {
		this.members.add(member);
		this.suspended_members.remove(member);

	}

	public Vector<Member> getAdmins() {
		return admins;
	}

	public void setAdmins(Vector<Member> admins) {
		this.admins = admins;
	}

	public Vector<Member> getSuspended_admins() {
		return suspended_admins;
	}

	public void addSuspended_admins(Member suspended_admin) {
		this.suspended_admins.add(suspended_admin);
	}

	public Vector<Sub_Forum> getSubs(String string) {
		for (Member m : admins)
			if (m.getName().equals(string))
				return subs;
		return null;
	}

	public Forum_Ruels getRuels() {
		return ruels;
	}

	public void delete_sub(Sub_Forum sub, User user) {
		if (this.subs.contains(sub) && admins.contains(user)
				&& !suspended_admins.contains(user))
			this.subs.remove(sub);
	}

	public boolean isMember(Member member) {
		for (MemberInForum MemberInForum : this.members_in_forum)
			if (MemberInForum.getMember().equals(member))
				return true;
		return false;
	}

	public boolean isMember(String name) {
		for (MemberInForum MemberInForum : this.members_in_forum)
			if (MemberInForum.getMember().equals(name))
				return true;
		return false;
	}

	public boolean isUser(String name) {
		return members.contains(name);
	}

	public Member getMember(String name) {
		if (members.contains(name))
			return fs.get_member_by_name(name);
		System.out.println("There is no member with the name: " + name
				+ " in this forum!");
		return null;
	}

	public String getName() {
		return this.name;
	}

	public String getSubject() {
		return this.subject;
	}

	public Sub_Forum getSub(String sub) {
		for (Sub_Forum sf : this.subs)
			if (sf.getName().equals(sub))
				return sf;
		return null;
	}

	public Forum_System getFs() {
		return fs;
	}
}
