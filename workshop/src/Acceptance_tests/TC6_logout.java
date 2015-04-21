package Acceptance_tests;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.I_Forum;
import Domain.Forum_component.I_Forum_Ruels;
import Domain.Forum_component.I_Forum_System;
import Domain.User_component.I_MIF;
import Domain.User_component.I_Member;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC6_logout {
	private I_Forum f;
	private I_Forum_System fs;
	private Super_Admin sa;
	private I_Forum_Ruels fr;
	private Bridge b = Driver.getBridge();
	private I_Member m;

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
		assertTrue(m.get_mif(f).getConnected());
	}
	
	@Test
	public void test_logout() {
		b.logout(f, m);
		assertFalse(m.get_mif(f).getConnected());
	}
}
