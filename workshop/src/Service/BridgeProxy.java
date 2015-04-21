package Service;

import java.util.Vector;

import Domain.Forum_component.I_Forum;
import Domain.Forum_component.I_Forum_Ruels;
import Domain.Forum_component.I_Forum_System;
import Domain.Forum_component.I_Post;
import Domain.Forum_component.I_Sub_Forum;
import Domain.User_component.I_Member;
import Domain.User_component.I_User;
import Domain.User_component.Member;

public class BridgeProxy implements Bridge {

	@Override
	public I_Forum_System createForumSystem(String name, String password,
			String mail, int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addForum(I_Forum_System fs, String name, String subject,
			Vector<Member> admins, I_Forum_Ruels forumrules) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean guestLogin(I_Forum forum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerToForum(I_Forum forum, String name, String password,
			String mail, int age) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean memberLogin(I_Forum forum, String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout(I_Forum forum, I_User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean createSubForum(I_Forum forum, String name, String subject,
			Vector<Member> moderators, I_User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean view(I_Forum forum, I_User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean postThread(I_Sub_Forum sub, String header, String body,
			I_User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean postComment(String header, String body, I_User user,
			I_Post parent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createType(I_Forum forum, String type, I_User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeType(I_Forum forum, String type, I_User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countTypes(I_Forum forum, I_User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean complain(I_Sub_Forum sub, I_Member member, String complaint,
			I_Member moderator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deletePost(I_Post thread, I_User m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSubForum(I_Forum forum, I_User user, I_Sub_Forum sub) {
		// TODO Auto-generated method stub
		
	}

}
