package Acceptance_tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Service.Bridge;
import Service.Driver;

public class TC9_post_thread {
	private Forum_System fs;
	private Forum f;
	private Bridge b = Driver.getBridge();
	private Vector<String> admins_names;
	private Vector<String> mods_names;

	@Before
	public void setUp() throws Exception {
		this.fs = b.createForumSystem("super", "admin", "mail", 22);
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

		assertNotNull(b.postThread("name", "sub", "header", "body", "a"));
		
	}

	@Test
	public void test_empty_header() {
		assertTrue(b.postThread("name", "sub", "", "body", "super") == null);
	}
	@Test
	public void test_empty_body() {
		assertTrue(b.postThread("name", "sub", "header", "", fs.get_forum_by_name("name").getMember("shirt").getName()) == null);
	}
	
	@Test
	public void test_thread_inserted() {
		assertTrue(fs.getSub("sub").getThreads().get(0).getHeader()== "header");
	}
	
	@Test
	public void test_num_of_messages(){
		int num = fs.get_forum_by_name("name").getMember("shirt").getMembersInForum(fs.get_forum_by_name("name")).getNumOfPosts();
		b.postThread("name", "sub", "a", "b", fs.get_forum_by_name("name").getMember("shirt").getName());
		assertTrue(fs.get_forum_by_name("name").getMember("shirt").getMembersInForum(fs.get_forum_by_name("name")).getNumOfPosts() == num+1);
	}
	
}
