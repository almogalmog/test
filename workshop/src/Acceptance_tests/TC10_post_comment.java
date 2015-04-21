package Acceptance_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.I_Forum;
import Domain.Forum_component.I_Forum_System;
import Domain.Forum_component.I_Post;
import Domain.Forum_component.I_Sub_Forum;
import Domain.User_component.I_Member;
import Domain.User_component.I_User;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC10_post_comment {
	private I_Forum_System fs;
	private I_Forum f;
	private Forum_Ruels fr;
	private I_Sub_Forum sub;
	private I_Member m;
	private I_Post post;
	private Super_Admin sa;
	private Bridge b = Driver.getBridge();

	@Before
	public void setUp() throws Exception {
		 this.sa = new Super_Admin("super", "qwerty", "workshopIsFun@gmail.com",
				20.0);
		this.fs= new Forum_System((Super_Admin) sa);
		
				
		Vector<Member> admins = new Vector<>();
		
		admins.add(new Member("liran", "qwerty", "mail", 30.0));
		admins.add(new Member("grey", "qwerty", "mail", 30.0));
		admins.add(new Member("shirt", "qwerty", "mail", 30.0));

		Vector<Member> moderators = new Vector<Member>();
		moderators.add(new Member("mod1", "qwerty", "mail", 30.0));
		moderators.add(new Member("mod2", "qwerty", "mail", 30.0));

		this.fr = new Forum_Ruels();
		this.f = new Forum("name", "subject", admins, fr);
		sub = f.createSubForum("Michael Jackson", "Music", moderators);
		
		b.registerToForum(f, "Avi", "sgysb", "avi@gmail.com", 51);
		this.m = f.getMember("Avi");
		post = sub.add_thread("ta ta ta", "bla bla", (I_User) m);
	}

	
	@Test /*TR 52*/
	public void test_new_post_created() {
		assertTrue(b.postComment("comment to ta ta ta","body", (I_User)fs.searchMemberByName("Avi"), (I_Post)post));
	}
	
	@Test /*TR 53*/
	public void test_added_to_kids_list() {
		b.postComment("comment to ta ta ta","body", (I_User)fs.searchMemberByName("Avi"), (I_Post)post);
		assertEquals(post.getKids().get(0).getHeader(), "comment to ta ta ta");
	}
	
	
	

}
