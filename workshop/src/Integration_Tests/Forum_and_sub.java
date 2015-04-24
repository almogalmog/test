package Integration_Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Post;
import Domain.Forum_component.Sub_Forum;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class Forum_and_sub {
	private Forum_System fs;
	private Forum f;
	private Bridge b = Driver.getBridge();
	private Vector<String> admins_names;
	private Vector<String> mods_names;

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
		
		this.mods_names= new Vector<String>();
		b.registerToSystem("mod1", "qwerty", "mail4", 30.0);
		b.registerToForum(f.getName(), "mod1");
		mods_names.add("mod1");
		assertTrue(b.createSubForum("name", "sub", "subject", mods_names, "liran"));
		
	}
	
	
	@Test
	public void test_subject() {	
		assertFalse(b.createSubForum(f.getName(), "food", null, mods_names, "liran"));
	}
	
	@Test
	public void test_name() {
		assertFalse(b.createSubForum(f.getName(), null, "pizza",mods_names, "liran"));
	}
	
	
	@Test
	public void test_moderators() {
		assertFalse(b.createSubForum(f.getName(), "food", "pizza", new Vector<String>(), "liran"));
	}
	
	@Test
	public void test_sub_forum_added() {
		boolean found= false;
		b.createSubForum(f.getName(), "food", "pizza", mods_names, "liran");
		System.out.println(f.getName());
		for (Sub_Forum sf : f.getSubs("liran")) {
			if(sf.getName().equals("food"))
				found = true;
		}
		assertTrue(found);
	}

}
