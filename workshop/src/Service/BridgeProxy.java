package Service;

import java.util.Vector;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Post;
import Domain.Forum_component.Sub_Forum;
import Domain.User_component.Member;
import Domain.User_component.User;
import Domain.User_component.Member;

public class BridgeProxy implements Bridge {

	@Override
	public Forum_System createForumSystem(String name, String password,
			String mail, int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addForum(Forum_System fs, String name, String subject,
			Vector<Member> admins, Forum_Ruels forumrules) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guestLogin(Forum forum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerToForum(Forum forum, String name, String password,
			String mail, int age) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean memberLogin(Forum forum, String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout(Forum forum, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean createSubForum(Forum forum, String name, String subject,
			Vector<Member> moderators, User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean view(Forum forum, User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean postThread(Sub_Forum sub, String header, String body,
			User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean postComment(String header, String body, User user,
			Post parent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createType(Forum forum, String type, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeType(Forum forum, String type, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countTypes(Forum forum, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean complain(Sub_Forum sub, Member member, String complaint,
			Member moderator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deletePost(Post thread, User m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubForum(Forum forum, User user, Sub_Forum sub) {
		// TODO Auto-generated method stub
		
	}

}
