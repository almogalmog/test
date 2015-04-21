package Acceptance_tests;

import java.util.Vector;

import junit.framework.Assert;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.I_Forum;
import Domain.Forum_component.I_Forum_Ruels;
import Domain.Forum_component.I_Forum_System;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC11_members_types {
	private I_Forum f;
	private I_Forum_System fs;
	private Super_Admin sa;
	private I_Forum_Ruels fr;
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

		this.fr = new Forum_Ruels();

		this.fr = new Forum_Ruels();

		b.addForum(fs, "forum", "animals", admins, fr);
		this.f = fs.getForums().get(0);
	}

	@Test
	public void check_sa() {
		assertTrue(b.countTypes(f, sa) == 3);
		b.createType(f, "chrome", new Member("a", "b", "c", 15));
		assertFalse(b.countTypes(f, sa) == 4);
	}

	@Test
	public void test_type_exists() {
		assertTrue(b.countTypes(f, sa) == 3);
		b.createType(f, "Gold", sa);
		assertFalse(b.countTypes(f, sa) == 4);
	}

	@Test
	public void test_delete_type_by_not_sa() {
		assertTrue(b.countTypes(f, sa) == 3);
		b.removeType(f, "Gold", new Member("a", "b", "c", 15));
		assertFalse(b.countTypes(f, sa) == 2);
	}

	@Test
	public void test_delete_type_by_sa() {
		assertTrue(b.countTypes(f, sa) == 3);
		b.removeType(f, "Gold", sa);
		assertTrue(b.countTypes(f, sa) == 2);
	}

	@Test
	public void test_count_types_by_not_sa() {
		assertTrue(b.countTypes(f, sa) == 3);
		assertEquals(b.countTypes(f, new Member("a", "b", "c", 15)), 0);
	}

	@Test
	public void test_count_types_by_sa() {
		assertTrue(b.countTypes(f, sa) == 3);
		assertEquals(b.countTypes(f, sa), 3);
	}

	@Test
	public void test_types() {
		Vector<String> friends_types = new Vector<String>();
		friends_types.add("Gold");
		friends_types.add("Silver");
		friends_types.add("Basic");
		assertEquals(f.getTypes(sa), friends_types);
	}

	@Test
	public void test_time() {
		Member m = new Member("a", "v", "mail", 20);

		f.register(m);
		f.login(m.getName(), m.getPassword());
		for (int i = 0; i < 1000000000; i++)
			;
		f.logout(m);
		assertTrue(m.get_mif(f).getOnlineTime() > 0);
	}

}
