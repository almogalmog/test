package Service;

import java.util.Vector;

import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Post;
import Domain.Forum_component.Sub_Forum;
import Domain.User_component.Member;
import Domain.User_component.User;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Domain.User_component.User;

public class BridgeReal implements Bridge {

	@Override
	public boolean addForum(Forum_System fs, String name, String subject,
			Vector<Member> admins, Forum_Ruels forumrules) {
		return (fs.addForum(admins, forumrules, name, subject) != null);
	}

	@Override
	public boolean guestLogin(Forum forum) {
		return (forum.loginGuest() != null);

	}

	@Override
	public boolean memberLogin(Forum forum, String name, String password) {
		return (forum.login(name, password) != null);

	}

	@Override
	public void logout(Forum forum, User user) {
		forum.logout(user);
	}

	@Override
	public boolean createSubForum(Forum forum, String name, String subject,
			Vector<Member> moderators, User user) {
		return forum.createSubForum(name, subject, moderators) != null;

	}

	@Override
	public boolean view(Forum forum, User user) {
		// TODO
		return true;

	}

	@Override
	public boolean postThread(Sub_Forum sub, String header, String body,
			User user) {
		return sub.add_thread(header, body, user) != null;

	}

	@Override
	public boolean postComment(String header, String body, User user,
			Post parent) {
		return parent.comment(header, body, user) != null;

	}

	@Override
	public void createType(Forum forum, String type, User user) {
		forum.add_type(type, user);
	}

	@Override
	public void removeType(Forum forum, String type, User user) {
		forum.remove_type(type, user);
	}

	@Override
	public int countTypes(Forum forum, User user) {
		if(user instanceof Super_Admin)
			return forum.getNumOfTypes(user);
		return 0;
	}

	@Override
	public boolean complain(Sub_Forum sub, Member member, String complaint,
			Member moderator) {
		return sub.sendComplaint(member, complaint, moderator);
	}

	@Override
	public void deletePost(Post thread,User user) {
		if(thread.getAuthor() == user)
			thread.remove_post();
	}

	@Override
	public void deleteSubForum(Forum forum, User user, Sub_Forum sub) {
		forum.delete_sub(sub, user);
	}

	@Override
	public Forum_System createForumSystem(String name, String password,
			String mail, int age) {
		Super_Admin sa = new Super_Admin(name, password, mail, age);
		Forum_System fs = new Forum_System(sa);
		return (Forum_System) fs;
	}

	@Override
	public boolean registerToForum(Forum forum, String name, String password,
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
