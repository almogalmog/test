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

public interface Bridge {

	Forum_System createForumSystem(String name, String password, String mail,
			int age);// 1

	boolean addForum(Forum_System fs, String name, String subject,
			Vector<Member> admins, Forum_Ruels forumrules);// 2
	// void changeForumRules(User user, );//3

	boolean guestLogin(Forum forum);// 4

	boolean registerToForum(Forum forum, String name, String password,
			String mail, int age);// 5

	boolean memberLogin(Forum forum, String name, String password);// 6

	void logout(Forum forum, User user);// 6

	boolean createSubForum(Forum forum, String name, String subject,
			Vector<Member> moderators, User user);// 7

	boolean view(Forum forum, User user); // 8

	boolean postThread(Sub_Forum sub, String header, String body, User user);// 9

	boolean postComment(String header, String body, User user, Post parent);// 10

	void createType(Forum forum, String type, User user);// 11

	void removeType(Forum forum, String type, User user);// 11

	int countTypes(Forum forum, User user);// 11

	boolean complain(Sub_Forum sub, Member member, String complaint,
			Member moderator); // 12
	// void sendMail(); //13

	void deletePost(Post thread, User m); // 14

	void deleteSubForum(Forum forum, User user, Sub_Forum sub);// 15

}
