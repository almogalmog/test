package Acceptance_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.User_component.Member;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC2_add_forum {
	private Forum_System fs;
	private Bridge b = Driver.getBridge();
	private Vector<Member> admins;
	private Forum f;
	private Forum_Ruels fr;


	@Before
	public void setUp() throws Exception {
		
		Super_Admin sa = new Super_Admin("super", "admin", "mail", 22);
		this.fs = new Forum_System(sa);
		
		admins = new Vector<>();
		admins.add(new Member("liran", "qwerty", "mail", 30.0));
		admins.add(new Member("grey", "qwerty", "mail", 30.0));
		admins.add(new Member("shirt", "qwerty", "mail", 30.0));
		
		this.fr = new Forum_Ruels();
		assertTrue(b.addForum(fs, "name", "subject", admins, fr));
		this.f = fs.getForums().get(0);
	}
	
	// use case 2 - add forum to forum system
	@Test
	public void test_forum_added() {
		assertEquals(f, fs.getForums().get(0));
	}
	
	@Test
	public void test_admins() {
		assertEquals(f.getAdmins(), admins);
	}
	
	@Test
	public void test_admins_registered() {
		f.getUsers().containsAll(admins);
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
