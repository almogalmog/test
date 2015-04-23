package Integration_Tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;

public class Register_to_forum {
	private Forum f;
	private Forum_System fs;
	private Super_Admin sa;
	private Forum_Ruels fr;

	@Before
	public void setUp() throws Exception {
		this.sa = new Super_Admin("super", "qwerty", "workshopIsFun@gmail.com",
				20.0);
		this.fs = new Forum_System(sa, "sys");

		Vector<Member> admins = new Vector<>();
		admins.add(new Member("liran", "qwerty", "mail", 30.0));
		admins.add(new Member("grey", "qwerty", "mail", 30.0));
		admins.add(new Member("shirt", "qwerty", "mail", 30.0));


		this.fr = new Forum_Ruels();
		this.f = this.fs.addForum(admins, fr, "name", "subject");
	}

	@Test
	public void test_init() {
		assertTrue(fs.getSuper_admin() == sa);
		assertNotNull(fs.getForums());
		assertNotNull(fs.getForums().get(0));
		assertTrue(fs.getForums().get(0) == this.f);
	}

	@Test
	public void test_registration() throws UnsupportedEncodingException {
		Member m = new Member("tester", "qwerty", "mail", 20);
		f.register(m);
		assertTrue(f.isMember("tester"));
	}

}
