package Service;

import java.util.Vector;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Post;

public class BridgeProxy implements Bridge {

	@Override
	public Forum_System createForumSystem(String name, String password,
			String mail, int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addForum(String name, String subject, Vector<String> admins,
			Forum_Ruels forumrules) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guestLogin(String forum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerToForum(String forum, String name, String password,
			String mail, double d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean memberLogin(String forum, String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout(String forum, String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean createSubForum(String forum, String name, String subject,
			Vector<String> moderators, String user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean view(String forum, String user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Post postThread(String forum, String sub, String header,
			String body, String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post postComment(String header, String body, String user,
			Post parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createType(String forum, String type, String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeType(String forum, String type, String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countTypes(String forum, String user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean complain(String sub, String member, String complaint,
			String moderator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deletePost(Post thread, String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubForum(String forum, String user, String sub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerToSystem(String name, String password, String mail,
			double age) {
		// TODO Auto-generated method stub
		
	}}
