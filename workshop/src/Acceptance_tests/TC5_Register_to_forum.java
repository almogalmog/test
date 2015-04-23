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

public class TC5_Register_to_forum {
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
	}

	@Test
	/* TR 12 */
	public void test_member_name() {
		assertTrue(b.registerToForum(f.getName(), null, "153d1fR", "abc@gmail.com", 25));
	}

	@Test
	/* TR 13 */
	public void test_password() {
		assertTrue(b.registerToForum(f.getName(), "gal", null, "gal@gmail.com", 24));
	}

	@Test
	/* TR 14 */
	public void test_second_password() {
		/*---*/
	}

	@Test
	/* TR 15 */
	public void test_mail() {
		assertTrue(b.registerToForum(f.getName(), "gal", "15616GFEg", null, 24));
	}

	@Test
	/* TR 17 */
	public void test_two_members_same_name() {
		assertTrue(b
				.registerToForum(f.getName(), "gal", "1566GFEg", "galt@gmail.com", 24));
		assertFalse(b.registerToForum(f.getName(), "gal", "14y6GFtc", "gd@gmail.com", 22));
	}

	@Test
	/* TR 21 */
	public void test_member_added() {
		assertTrue(b
				.registerToForum(f.getName(), "gal", "1566GFEg", "galt@gmail.com", 24));
		assertTrue(null != f.getMember("gal"));
	}

}
