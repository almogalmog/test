package Acceptance_tests;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC4_guest_enterance {
	private Forum f;
	private Forum_System fs;
	private Super_Admin sa;
	private Bridge b = Driver.getBridge();
	
	@Before
	public void setUp() throws Exception {
		this.sa = new Super_Admin("super", "qwerty", "workshopIsFun@gmail.com",
				20.0);
		this.fs = new Forum_System(sa);

		Vector<Member> admins = new Vector<>();
		admins.add(new Member("liran", "qwerty", "mail", 30.0));
		admins.add(new Member("grey", "qwerty", "mail", 30.0));
		admins.add(new Member("shirt", "qwerty", "mail", 30.0));
		
		b.addForum(fs, "name", "subject", admins, new Forum_Ruels());
		this.f  = this.fs.getForums().get(0);
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
