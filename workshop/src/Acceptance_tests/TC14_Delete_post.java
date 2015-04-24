package Acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Post;
import Domain.Forum_component.Sub_Forum;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC14_Delete_post {
	private Bridge b = Driver.getBridge();
	private Forum_System fs;
	private Vector<String> admins_names;
	private Vector<String> mods_names;

	@Before
	public void setUp() throws Exception {
		fs= b.createForumSystem("super", "admin", "mail", 22);
		b.registerToSystem("liran", "qwerty", "mail1", 30.0);
		b.registerToSystem("grey", "qwerty", "mail2", 30.0);
		b.registerToSystem("shirt", "qwerty", "mail3", 30.0);
		
		admins_names = new Vector<String>();
		admins_names.add("liran");
		admins_names.add("grey");
		
		this.mods_names= new Vector<String>();
		mods_names.add("shirt");
		assertTrue(b.addForum("name", "subject", admins_names, new Forum_Ruels()));
		assertTrue(b.registerToForum("name","shirt"));
		assertTrue(b.createSubForum("name", "sub", "forum", mods_names, "shirt"));

		

	}

	@Test
	public void test_same_user_can_delete() {
		Post p = b.postThread("name", "sub", "header", "body", "liran");
		b.deletePost(p, "liran");
		assertTrue(fs.get_forum_by_name("name").getSub("sub").getThreads().size() == 0);
	}
	
	
	@Test
	public void test_other_user_cant_delete() {
		Post p = b.postThread("name", "sub", "header", "body", "liran");
		b.deletePost(p, "shirt");
		assertFalse(fs.get_forum_by_name("name").getSub("sub").getThreads().size() == 0);
	}
	
	@Test
	public void test_delete_kids() {
		Post post =  b.postThread("name", "sub", "header", "body", "liran");
		assertNotNull(b.postComment("comment", "post", "liran", post));
		b.deletePost(post, "liran");
		assertTrue(fs.get_forum_by_name("name").getSub("sub").getThreads().size() == 0);
	}
	
}
