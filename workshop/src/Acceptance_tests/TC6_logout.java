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

public class TC6_logout {
	private Forum f;
	private Forum_System fs;
	private Super_Admin sa;
	private Forum_Ruels fr;
	private Bridge b = Driver.getBridge();
	private Member m;

	@Before
	public void setUp() throws Exception {
		this.sa = new Super_Admin("super", "qwerty", "workshopIsFun@gmail.com",
				20.0);
		this.fs = new Forum_System(sa);

		Vector<Member> admins = new Vector<>();
		admins.add(new Member("liran", "qwerty", "mail", 30.0));
		admins.add(new Member("grey", "qwerty", "mail", 30.0));
		admins.add(new Member("shirt", "qwerty", "mail", 30.0));
		this.fr = new Forum_Ruels();

		b.addForum(fs, "name", "subject", admins, fr);
		this.f = this.fs.getForums().get(0);
		
		b.registerToForum(f, "tester", "qwerty", "mail@gmail.com" , 20);
		m = f.getMember("tester");
	}

	
	@Test
	public void test_connected() {
		assertTrue(m.getMembersInForum(f).getConnected());
	}
	
	@Test
	public void test_logout() {
		b.logout(f, m);
		assertFalse(m.getMembersInForum(f).getConnected());
	}
}
