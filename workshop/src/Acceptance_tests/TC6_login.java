package Acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC6_login {
	private Forum f;
	private Forum_System fs;
	private Super_Admin sa;
	private Forum_Ruels fr;
	private Bridge b = Driver.getBridge();
	private Vector<String> admins_names;

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
		assertTrue(b.addForum("name", "subject", admins_names,
				new Forum_Ruels()));
		this.f = fs.getForums().get(0);
		b.registerToForum(f.getName(),"a", "b", "c", 1);
	}


	@Test
	public void test_wrong_usrname() {
		assertFalse(b.memberLogin(f.getName(), "name", "password"));
	}
	
	@Test
	public void test_wrong_password() {
		assertFalse(b.memberLogin(f.getName(), "tester", "wrong_password"));
	}
	
	@Test
	public void test_connected() {
		assertTrue(f.getMember("a").getMembersInForum(f).getConnected());
	}
}
