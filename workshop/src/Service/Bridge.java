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

public interface Bridge {

	I_Forum_System createForumSystem(String name, String password, String mail,
			int age);// 1

	boolean addForum(I_Forum_System fs, String name, String subject,
			Vector<Member> admins, I_Forum_Ruels forumrules);// 2
	// void changeForumRules(User user, );//3

	boolean guestLogin(I_Forum forum);// 4

	boolean registerToForum(I_Forum forum, String name, String password,
			String mail, int age);// 5

	boolean memberLogin(I_Forum forum, String name, String password);// 6

	void logout(I_Forum forum, I_User user);// 6

	boolean createSubForum(I_Forum forum, String name, String subject,
			Vector<Member> moderators, I_User user);// 7

	boolean view(I_Forum forum, I_User user); // 8

	boolean postThread(I_Sub_Forum sub, String header, String body, I_User user);// 9

	boolean postComment(String header, String body, I_User user, I_Post parent);// 10

	void createType(I_Forum forum, String type, I_User user);// 11

	void removeType(I_Forum forum, String type, I_User user);// 11

	int countTypes(I_Forum forum, I_User user);// 11

	boolean complain(I_Sub_Forum sub, I_Member member, String complaint,
			I_Member moderator); // 12
	// void sendMail(); //13

	void deletePost(I_Post thread, I_User m); // 14

	void deleteSubForum(I_Forum forum, I_User user, I_Sub_Forum sub);// 15

}
