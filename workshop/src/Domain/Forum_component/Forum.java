package Domain.Forum_component;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.hamcrest.Matcher;

import Domain.User_component.Guest;
import Domain.User_component.I_MIF;
import Domain.User_component.I_Member;
import Domain.User_component.I_User;
import Domain.User_component.Member;
import Domain.User_component.MemberInForum;
import Domain.User_component.Super_Admin;
import Domain.User_component.User;

public class Forum implements I_Forum {
	private Vector<User> users;
	private Vector<Member> suspended_members;
	private Vector<Member> admins;
	private Vector<Member> suspended_admins;
	private Vector<Sub_Forum> subs;
	private Logger Alogger;
	private Logger Elogger;
	private I_Forum_Ruels ruels;
	private Vector<String> friends_types;
	private Vector<MemberInForum> members_in_forum;
	private int guest_num;
	private String name;
	private String subject;

	public Forum(String name, String subject, Vector<Member> admins,
			I_Forum_Ruels ruels) {
		this.name = name;
		this.subject = subject;
		this.users = new Vector<User>();
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
	@Override
	public Vector<Sub_Forum> loginGuest() {
		Guest guest = new Guest(this, guest_num++);
		addUser(guest);
		return subs;
	}

	@Override
	public I_Sub_Forum createSubForum(String name, String subject,
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
	@Override
	public void logout(I_User user) {
		if (user instanceof Member) {
			((I_Member) user).get_mif(this).setConnected(false);

		}

		else
			// i'm a guest, remove me
			users.remove(user);
	}

	// for members only
	@Override
	public I_Forum login(String namail, String password) {
		if (namail != null && password != null) {
			for (I_User user : users) {
				if (user.getName().equals(namail)
						&& ((I_Member) user).getPassword().equals(password)) {
					for (I_MIF mif : members_in_forum) {
						if (mif.getMember() == ((I_Member) user)) {
							mif.setConnected(true);
							Alogger.log(Level.INFO, "You login");
							return this;

						}
					}
				}

			}
		}
		Elogger.log(Level.WARNING, "invalid name or password");
		return null;
	}

	private boolean isMail(String namail) {
		/*
		 * String email = "nbjvkj@kn.com"; Pattern p =
		 * Pattern.compile(".+@.+\\.[a-z]+"); java.util.regex.Matcher m =
		 * p.matcher(email); return m.matches();
		 */
		return namail.contains("@");
	}

	// to register as member
	@Override
	public I_Forum register(Member member) {
		users.add(member);
		MemberInForum mif = new MemberInForum(member, this);
		member.add_mif(mif);
		this.members_in_forum.add(mif);
		
		return this;
	}

	@Override
	public Vector<User> getUsers() {
		return users;
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
	}

	@Override
	public void add_type(String type, I_User user) {
		if (user instanceof Super_Admin && !friends_types.contains(type))
			this.friends_types.add(type);
	}

	@Override
	public void remove_type(String type, I_User user) {
		if (user instanceof Super_Admin && friends_types.contains(type))
			this.friends_types.remove(type);
	}

	@Override
	public int getNumOfTypes(I_User user) {
		if (user instanceof Super_Admin)
			return this.friends_types.size();
		else
			return -1;
	}

	@Override
	public Vector<String> getTypes(I_User user) {
		if (user instanceof Super_Admin)
			return this.friends_types;
		else
			return null;
	}

	@Override
	public Vector<Member> getSuspend_members() {
		return suspended_members;
	}

	@Override
	public void Suspend_member(Member suspended_member) {
		this.users.remove(suspended_member);
		this.suspended_members.add(suspended_member);
	}

	@Override
	public void unsuspend_member(Member member) {
		this.users.add(member);
		this.suspended_members.remove(member);

	}

	@Override
	public Vector<Member> getAdmins() {
		return admins;
	}

	@Override
	public void setAdmins(Vector<Member> admins) {
		this.admins = admins;
	}

	@Override
	public Vector<Member> getSuspended_admins() {
		return suspended_admins;
	}

	@Override
	public void addSuspended_admins(Member suspended_admin) {
		this.suspended_admins.add(suspended_admin);
	}

	@Override
	public Vector<Sub_Forum> getSubs(I_User user) {
		return subs;
	}

	@Override
	public I_Forum_Ruels getRuels() {
		return ruels;
	}

	@Override
	public void delete_sub(I_Sub_Forum sub, I_User user) {
		if (this.subs.contains(sub) && admins.contains(user)
				&& !suspended_admins.contains(user))
			this.subs.remove(sub);
	}

	@Override
	public boolean isMember(I_Member member) {
		for (I_MIF mif : this.members_in_forum)
			if (mif.getMember().equals(member))
				return true;
		return false;
	}

	@Override
	public boolean isMember(String name) {
		for (I_MIF mif : this.members_in_forum)
			if (mif.getMember().getName().equals(name))
				return true;
		return false;
	}

	@Override
	public boolean isUser(String name) {
		for (I_User u : this.users)
			if (u.getName().equals(name))
				return true;
		return false;
	}

	@Override
	public Member getMember(String name) {
		for (I_MIF mif : this.members_in_forum)
			if (mif.getMember().getName().equals(name))
				return mif.getMember();
		return null;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getSubject() {
		return this.subject;
	}
}
