package Service;

import java.util.Vector;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Post;
import Domain.Forum_component.Sub_Forum;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Domain.User_component.User;

public class BridgeReal implements Bridge {

	private Forum_System fs;

	@Override
	public Forum_System createForumSystem(String name, String password,
			String mail, int age) {
		Super_Admin sa = new Super_Admin(name, password, mail, age);
		this.fs = new Forum_System(sa, "sys");
		return (Forum_System) fs;
	}

	@Override
	public boolean registerToSystem(String name, String password, String mail,
			double age) {
		if (fs.get_member_by_name(name) == null){
			fs.addMember(name, password, mail, age);
			return true;
		}
		System.out.println("the name already exists in the system");
		return false;	
		
	}

	@Override
	public boolean addForum(String name, String subject, Vector<String> admins,
			Forum_Ruels forumrules) {
		Vector<Member> ads = new Vector<Member>();
		for (String s : admins)
			if (fs.get_member_by_name(s) == null) {
				System.out.println("member " + name + " doesn't exist");
				return false;
			} else
				ads.add(fs.get_member_by_name(s));

		return (this.fs.addForum(ads, forumrules, name, subject) != null);
	}

	@Override
	public boolean guestLogin(String forum) {
		Forum f = fs.get_forum_by_name(forum);
		if (f != null)
			return (f.loginGuest() != null);
		return false;

	}

	@Override
	public boolean memberLogin(String forum, String name, String password) {
		Forum f = fs.get_forum_by_name(forum);
		if (f != null)
			return (f.login(name, password) != null);
		return false;

	}

	@Override
	public void logout(String forum, String user) {
		Forum f = fs.get_forum_by_name(forum);
		if (f != null)
			f.logout(user);
	}

	@Override
	public boolean createSubForum(String forum, String name, String subject,
			Vector<String> moderators, String user) {
		Forum f = fs.get_forum_by_name(forum);

		if (f == null)
			return false;
		if (moderators.size() == 0)
			return false;
		Vector<Member> mods = new Vector<Member>();
		for (String string : moderators) {
			Member toAdd = f.getMember(string);
			if (toAdd != null)
				mods.add(toAdd);
			else
				return false;
		}

		return f.createSubForum(name, subject, mods) != null;

	}

	@Override
	public boolean view(String forum, String user) {
		// TODO
		return true;

	}

	// ask achiya about how to find sf
	@Override
	public Post postThread(String forum, String sub, String header,
			String body, String user) {
		Sub_Forum sub_forum = fs.get_forum_by_name(forum).getSub(sub);
		User u = sub_forum.getForum().getMember(user);
		return sub_forum.add_thread(header, body, u);

	}

	@Override
	public Post postComment(String header, String body, String user, Post parent) {
		User u = parent.getSub().getForum().getMember(user);
		return parent.comment(header, body, u);

	}

	@Override
	public void createType(String forum, String type, String user) {
		Forum f = fs.get_forum_by_name(forum);
		User u = f.getMember(user);
		if (f != null)
			f.add_type(type, u);
	}

	@Override
	public void removeType(String forum, String type, String user) {
		Forum f = fs.get_forum_by_name(forum);
		User u = f.getMember(user);

		if (f != null)
			f.remove_type(type, u);
	}

	@Override
	public int countTypes(String forum, String user) {
		Forum f = fs.get_forum_by_name(forum);
		User u = f.getMember(user);
		if (f != null) {
			if (u instanceof Super_Admin)
				return f.getNumOfTypes(u);
			return 0;
		}
		return 0;
	}

	@Override
	public boolean complain(String sub, String member, String complaint,
			String moderator) {
		Sub_Forum sf = fs.getSub(sub);
		User u = sf.getForum().getMember(member);
		User mod = sf.getForum().getMember(moderator);
		System.out.println(u.getName());
		System.out.println(mod.getName());
		if (!(u instanceof Member) || !(mod instanceof Member))
			return false;
		return sf.sendComplaint((Member) u, complaint, (Member) mod);
	}

	@Override
	public void deletePost(Post thread, String user) {
		User u = thread.getSub().getForum().getMember(user);
		if (thread.getAuthor() == u)
			thread.remove_post();
	}

	@Override
	public void deleteSubForum(String forum, String user, String sub) {

		Forum f = fs.get_forum_by_name(forum);
		Sub_Forum sf = f.getSub(sub);
		User u = f.getMember(user);
		if (f != null)
			f.delete_sub(sf, u);
	}

	@Override
	public boolean registerToForum(String forum, String name) {
		Forum f = fs.get_forum_by_name(forum);
		if (f.getUsers().contains(name)){
			System.out.println("the name "+name+" already exist in forum "+ f.getName());
			return false;
		}
		f.register(name);
		f.login(name, fs.get_member_by_name(name).getPassword());
		return true;
	}

}
