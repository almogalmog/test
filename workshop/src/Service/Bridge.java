package Service;

import java.util.Vector;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Post;

//ask achiya about fr, post

public interface Bridge {

	Forum_System createForumSystem(String name, String password, String mail,
			int age);// 1

	boolean addForum(String name, String subject,
			Vector<String> admins, Forum_Ruels forumrules);// 2
	
	// void changeForumRules(String user, );//3

	boolean guestLogin(String forum);// 4

	boolean registerToForum(String forum, String name);// 5

	boolean memberLogin(String forum, String name, String password);// 6

	void logout(String forum, String user);// 6

	boolean createSubForum(String forum, String name, String subject,
			Vector<String> moderators, String user);// 7

	boolean view(String forum, String user); // 8

	Post postThread(String forum, String sub, String header, String body, String user);// 9

	Post postComment(String header, String body, String user, Post parent);// 10

	void createType(String forum, String type, String user);// 11

	void removeType(String forum, String type, String user);// 11

	int countTypes(String forum, String user);// 11

	boolean complain(String sub, String member, String complaint,
			String moderator); // 12
	// void sendMail(); //13

	void deletePost(Post thread, String user); // 14

	void deleteSubForum(String forum, String user, String sub);// 15

	boolean registerToSystem(String name, String password, String mail,
			double age);
}
