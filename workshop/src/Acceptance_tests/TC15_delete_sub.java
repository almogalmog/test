package Acceptance_tests;

import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Post;
import Service.Bridge;
import Service.Driver;

public class TC15_delete_sub {
	private Bridge b = Driver.getBridge();
	private Forum_System fs;
	private Vector<String> admins_names;
	private Vector<String> mods_names;

	@Before
	public void setUp() throws Exception {
		fs = b.createForumSystem("super", "admin", "mail", 22);
		b.registerToSystem("liran", "qwerty", "mail1", 30.0);
		b.registerToSystem("grey", "qwerty", "mail2", 30.0);
		b.registerToSystem("shirt", "qwerty", "mail3", 30.0);

		admins_names = new Vector<String>();
		admins_names.add("liran");
		admins_names.add("grey");

		this.mods_names = new Vector<String>();
		mods_names.add("shirt");
		assertTrue(b.addForum("name", "subject", admins_names,
				new Forum_Ruels()));
		assertTrue(b.registerToForum("name", "shirt"));
		assertTrue(b
				.createSubForum("name", "sub", "forum", mods_names, "shirt"));

		b.deleteSubForum("name", "super", "sub");
	}

	@Test
	public void test_delete() {
		assertTrue(fs.get_forum_by_name("name").getSub("sub") == null);
	}
}
