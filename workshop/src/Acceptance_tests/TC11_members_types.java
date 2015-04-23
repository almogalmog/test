package Acceptance_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.User_component.Member;
import Service.Bridge;
import Service.Driver;

public class TC11_members_types {
	private Forum_System fs;
	private Bridge b = Driver.getBridge();
	private Vector<String> admins_names;
	
	@Before
	public void setUp() throws Exception {
		fs = b.createForumSystem("super", "admin", "mail", 22);
		b.registerToSystem("liran", "qwerty", "mail1", 30.0);
		b.registerToSystem("grey", "qwerty", "mail2", 30.0);
		b.registerToSystem("shirt", "qwerty", "mail3", 30.0);
		b.registerToSystem("a", "b", "mail3", 40);
		admins_names = new Vector<String>();
		admins_names.add("liran");
		admins_names.add("grey");
		
		assertTrue(b.addForum("name", "subject", admins_names, new Forum_Ruels()));
		b.registerToForum("name", "a", "b", "mail3", 40);
	}
/*
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

		this.fr = new Forum_Ruels();

		b.addForum("forum", "animals", admins, fr);
		this.f = fs.getForums().get(0);
	}
*/
	@Test
	public void check_sa() {
		assertTrue(b.countTypes("name", "super") == 3);
		b.createType("name", "chrome", "c");
		assertFalse(b.countTypes("name", "super") == 4);
	}

	@Test
	public void test_type_exists() {
		assertTrue(b.countTypes("name", "super") == 3);
		b.createType("name", "Gold", "super");
		assertFalse(b.countTypes("name", "super") == 4);
	}

	@Test
	public void test_delete_type_by_not_sa() {
		assertTrue(b.countTypes("name", "super") == 3);
		b.removeType("name", "Gold","a");
		assertFalse(b.countTypes("name", "super") == 2);
	}

	@Test
	public void test_delete_type_by_sa() {
		assertTrue(b.countTypes("name", "super") == 3);
		b.removeType("name", "Gold", "super");
		assertTrue(b.countTypes("name", "super") == 2);
	}

	@Test
	public void test_count_types_by_not_sa() {
		assertTrue(b.countTypes("name", "super") == 3);
		assertEquals(b.countTypes("name","a"), 0);
	}

	@Test
	public void test_count_types_by_sa() {
		assertTrue(b.countTypes("name", "super") == 3);
		assertEquals(b.countTypes("name", "super"), 3);
	}

	@Test
	public void test_types() {
		Vector<String> friends_types = new Vector<String>();
		friends_types.add("Gold");
		friends_types.add("Silver");
		friends_types.add("Basic");
		assertEquals(fs.get_forum_by_name("name").getTypes("super"), friends_types);
	}

	@Test
	public void test_time() {
		Member m = new Member("a", "v", "mail", 20);

		fs.get_forum_by_name("name").register(m);
		fs.get_forum_by_name("name").login(m.getName(), m.getPassword());
		for (int i = 0; i < 1000000000; i++)
			;
		fs.get_forum_by_name("name").logout(m);
		assertTrue(m.getMembersInForum(fs.get_forum_by_name("name")).getOnlineTime() > 0);
	}

}
