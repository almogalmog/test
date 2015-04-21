package Service;

import java.util.Vector;

import Domain.Forum_component.Forum_System;
import Domain.Forum_component.I_Forum;
import Domain.Forum_component.I_Forum_Ruels;
import Domain.Forum_component.I_Forum_System;
import Domain.Forum_component.I_Post;
import Domain.Forum_component.I_Sub_Forum;
import Domain.User_component.I_Member;
import Domain.User_component.I_User;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Domain.User_component.User;

public class BridgeReal implements Bridge {

	@Override
	public boolean addForum(I_Forum_System fs, String name, String subject,
			Vector<Member> admins, I_Forum_Ruels forumrules) {
		return (fs.addForum(admins, forumrules, name, subject) != null);
	}

	@Override
	public boolean guestLogin(I_Forum forum) {
		return (forum.loginGuest() != null);

	}

	@Override
	public boolean memberLogin(I_Forum forum, String name, String password) {
		return (forum.login(name, password) != null);

	}

	@Override
	public void logout(I_Forum forum, I_User user) {
		forum.logout(user);
	}

	@Override
	public boolean createSubForum(I_Forum forum, String name, String subject,
			Vector<Member> moderators, I_User user) {
		return forum.createSubForum(name, subject, moderators) != null;

	}

	@Override
	public boolean view(I_Forum forum, I_User user) {
		// TODO
		return true;

	}

	@Override
	public boolean postThread(I_Sub_Forum sub, String header, String body,
			I_User user) {
		return sub.add_thread(header, body, user) != null;

	}

	@Override
	public boolean postComment(String header, String body, I_User user,
			I_Post parent) {
		return parent.comment(header, body, user) != null;

	}

	@Override
	public void createType(I_Forum forum, String type, I_User user) {
		forum.add_type(type, user);
	}

	@Override
	public void removeType(I_Forum forum, String type, I_User user) {
		forum.remove_type(type, user);
	}

	@Override
	public int countTypes(I_Forum forum, I_User user) {
		if(user instanceof Super_Admin)
			return forum.getNumOfTypes(user);
		return 0;
	}

	@Override
	public boolean complain(I_Sub_Forum sub, I_Member member, String complaint,
			I_Member moderator) {
		return sub.sendComplaint(member, complaint, moderator);
	}

	@Override
	public void deletePost(I_Post thread,I_User user) {
		if(thread.getAuthor() == user)
			thread.remove_post();
	}

	@Override
	public void deleteSubForum(I_Forum forum, I_User user, I_Sub_Forum sub) {
		forum.delete_sub(sub, user);
	}

	@Override
	public Forum_System createForumSystem(String name, String password,
			String mail, int age) {
		Super_Admin sa = new Super_Admin(name, password, mail, age);
		I_Forum_System fs = new Forum_System(sa);
		return (Forum_System) fs;
	}

	@Override
	public boolean registerToForum(I_Forum forum, String name, String password,
			String mail, int age) {
		for(User m : forum.getUsers())
			if(m instanceof Member && (m.getName().equals(name) || ((Member)m).getEmail().equals(mail)))
				return false;
		
		Member member = new Member(name, password, mail, age);
		if (forum.register(member) != null) {
			forum.login(member.getName(), member.getPassword());
			return true;
		}
		return false;
	}

}
