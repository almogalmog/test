package Integration_Tests;

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

public class Register_to_forum {
	private Bridge b = Driver.getBridge();
	private Forum f;
	private Forum_System fs;
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
		b.registerToSystem("tester", "a", "mail4", 20);
	}

	@Test
	//TR 12 
	public void test_member_name() {
		assertTrue(b.registerToForum(f.getName(), "tester"));
	}

	@Test
	 //TR 13 
	public void test_password() {
		assertFalse(f.login("tester", "b")!=null);
	}

	@Test
	 //TR 14 
	public void test_second_password() {
		//TODO
	}


	@Test
	 //TR 17 
	public void test_two_members_same_name() {
		assertFalse(b.registerToSystem("tester", "a", "mail", 20));
	}

	@Test
	 //TR 21 
	public void test_member_added() {
		assertTrue(b.registerToForum(f.getName(), "tester"));
		assertTrue(null != f.getMember("tester"));
	}

}
