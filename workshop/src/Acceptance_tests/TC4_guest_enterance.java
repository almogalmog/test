package Acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Service.Bridge;
import Service.Driver;

public class TC4_guest_enterance {
	private Forum f;
	private Forum_System fs;
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
		assertTrue(b.addForum("name", "subject", admins_names, new Forum_Ruels()));
		this.f = fs.getForums().get(0);
	}

	@Test
	public void test() {
		f.loginGuest();
		f.loginGuest();
		f.loginGuest();
		f.loginGuest();
		assertTrue(f.isUser("guest0"));
		assertTrue(f.isUser("guest1"));
		assertTrue(f.isUser("guest2"));
		assertTrue(f.isUser("guest3"));
		assertFalse(f.isUser("guest4"));
	}

}
