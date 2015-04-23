package Acceptance_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.User_component.Member;
import Service.Bridge;
import Service.Driver;

public class TC2_add_forum {
	private Forum_System fs;
	private Bridge b = Driver.getBridge();
	private Forum f;
	private Forum_Ruels fr;
	
	Vector<String> admins_names;


	@Before
	public void setUp() throws Exception {
		this.fs = b.createForumSystem("super", "admin", "mail", 22);
		b.registerToSystem("liran", "qwerty", "mail1", 30.0);
		b.registerToSystem("grey", "qwerty", "mail2", 30.0);
		b.registerToSystem("shirt", "qwerty", "mail3", 30.0);
		
		admins_names = new Vector<String>();
		admins_names.add("liran");
		admins_names.add("grey");
		admins_names.add("shirt");
		this.fr = new Forum_Ruels();
		assertTrue(b.addForum("name", "subject", admins_names, fr));
		this.f = fs.getForums().get(0);
	}
	
	// use case 2 - add forum to forum system
	@Test
	public void test_forum_added() {
		assertEquals(f, fs.getForums().get(0));
	}
	
	@Test
	public void test_admins() {
		for (Member admin : f.getAdmins()) {
			admins_names.contains(admin.getName());
			
		}
	}
	
	@Test
	public void test_forum_name(){
		assertEquals(f.getName(), "name");
	}
	@Test
	public void test_forum_ruels(){
		assertEquals(f.getRuels(), fr);
	}

}
