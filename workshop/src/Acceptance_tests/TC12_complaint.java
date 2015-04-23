package Acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Post;
import Domain.Forum_component.Sub_Forum;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC12_complaint {
	private Super_Admin sa;
	private Bridge b = Driver.getBridge();
	private Sub_Forum sub;

	private Vector<String> admins_names;
	private Vector<String> mods_names;
	private Forum_System fs;

	@Before
	public void setUp() throws Exception {
		fs = b.createForumSystem("super", "admin", "mail", 22);
		b.registerToSystem("liran", "qwerty", "mail1", 30.0);
		b.registerToSystem("grey", "qwerty", "mail2", 30.0);
		
		admins_names = new Vector<String>();
		mods_names = new Vector<String>();
		admins_names.add("liran");
		b.addForum("forum", "subject", admins_names, new Forum_Ruels());
		b.registerToForum("forum", "grey", "qwerty", "mail2", 30.0);
		b.registerToSystem("a", "a", "mail4", 16);
		b.registerToForum("forum", "a", "a", "mail4", 16);
		mods_names.add("grey");
		
		b.createSubForum("forum", "sub", "s", mods_names, "liran");
		
		b.registerToSystem("tester", "a", "mail5", 100);
		b.registerToForum("forum", "tester", "a", "mail5", 100);
		
		
		
	}

	@Test
	public void test_not_able_to_complaint() {
		assertFalse(b.complain("sub", "tester", "oy vey!", "grey"));
	}
	
	@Test
	public void test_able_to_complaint() {
		b.postThread("forum", "sub", "header", "body", "tester");
		assertTrue(b.complain("sub", "tester", "oy vey!", "grey"));
	}
	
	@Test
	public void test_fields() {
		b.postThread("forum", "sub", "header", "body", "tester");
		assertFalse(b.complain("sub", "tester", "", "grey"));
	}
	
}
