package Domain.Forum_component;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import Domain.User_component.Member;
import Domain.User_component.Super_Admin;

public class Forum_System {
	private Vector<Forum> forums;
	private static Super_Admin super_admin;
	private static Vector<Member> registered_members;
	private Logger Elogger;
	private Logger Alogger;

	public Forum_System(Super_Admin super_admin) {
		this.super_admin = super_admin;
		this.forums = new Vector<Forum>();
		this.registered_members = new Vector<Member>();
		this.registered_members.add(super_admin);
		this.Elogger = Logger.getLogger("Error logger");
		this.Alogger = Logger.getLogger("Action logger");
	}

	
	public Super_Admin getSuper_admin() {
		return super_admin;
	}

	
	public void setSuper_admin(Super_Admin super_admin) {
		this.super_admin = super_admin;
	}

	
	public Vector<Forum> getForums() {
		return forums;
	}

	
	public void setForums(Vector<Forum> forums) {
		this.forums = forums;
	}

	
	public Forum addForum(Vector<Member> admins, Forum_Ruels ruels,
			String name, String subject) {
		Forum forum = new Forum(name, subject, admins, ruels);
		forum.addUser(this.super_admin);
		forum.register(super_admin);
		forum.getAdmins().add(super_admin);
		this.forums.add(forum);
		return forum;
	}

	
	public Member addMember(String username, String password, String email,
			double age) {
		for (Member member : registered_members) {
			if (member.getName().equals(username)
					|| member.getEmail().equals(email)) {
				Elogger.log(Level.WARNING,
						"Name or email already registered. Please try again");
				return null;
			}
		}
		Member newMember = new Member(username, password, email, age);
		registered_members.add(newMember);
		Alogger.log(Level.INFO, "Member added successfully");
		return newMember;
	}

	
	public Vector<Member> getMembers() {
		return registered_members;
	}

	
	public Member searchMemberByName(String name) {
		for (Member member : registered_members) {
			if (member.getName().equals(name))
				return member;
		}
		return null;
	}

}