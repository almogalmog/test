package Acceptance_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
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
		b.registerToSystem("a", "b", "mail4", 40);
		admins_names = new Vector<String>();
		admins_names.add("liran");
		admins_names.add("grey");

		assertTrue(b.addForum("name", "subject", admins_names,
				new Forum_Ruels()));

		b.registerToForum("name", "a");
	}

	@Test
	public void check_sa() {
		assertTrue(b.countTypes("name", "super") == 3);
		b.createType("name", "chrome", "a");
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
		b.removeType("name", "Gold", "a");
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
		assertEquals(b.countTypes("name", "a"), 0);
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
		assertEquals(fs.get_forum_by_name("name").getTypes("super"),
				friends_types);
	}

}
