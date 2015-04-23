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
import Domain.Forum_component.Sub_Forum;
import Domain.Forum_component.Sub_Forum;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;
import Unit_tests.sub_forum_tests;

public class TC12_complaint {
	private Forum f;
	private Forum_System fs;
	private Super_Admin sa;
	private Bridge b = Driver.getBridge();
	private Vector<Member> moderators = new Vector<>();
	private Sub_Forum sub;

	@Before
	public void setUp() throws Exception {
		this.sa = new Super_Admin("super", "qwerty", "workshopIsFun@gmail.com",
				20.0);
		this.fs = new Forum_System(sa);

		Vector<Member> admins = new Vector<>();
		admins.add(new Member("liran", "qwerty", "mail", 30.0));

		b.addForum(fs, "forum", "animals", admins, new Forum_Ruels());
		this.f = fs.getForums().get(0);

		moderators = new Vector<>();
		Member mod1 = new Member("mod1", "qwerty", "mail", 30.0);
		moderators.add(mod1);
		moderators.add(new Member("mod2", "qwerty", "mail", 30.0));
		moderators.add(new Member("mod3", "qwerty", "mail", 30.0));
		b.createSubForum(f, "sub", "forum", moderators, sa);
		sub = f.getSubs(sa).get(0);
	}

	@Test
	public void test_not_able_to_complaint() {
		assertFalse(b.complain(sub, new Member("a", "v", "mail", 20), "oy vey!", sub.getModerators().get(0)));
	}
	
	@Test
	public void test_able_to_complaint() {
		b.postThread(sub, "hi", "world!", sa);
		assertTrue(b.complain(sub, sa, "oy vey!", sub.getModerators().get(0)));
	}
	
	@Test
	public void test_fields() {
		b.postThread(sub, "hi", "world!", sa);
		assertFalse(b.complain(sub, sa, "", sub.getModerators().get(0)));
	}
	
}
