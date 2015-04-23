package Acceptance_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC3_FR_params {
	private Bridge b = Driver.getBridge();
	private Forum_System fs;
	private Super_Admin sa;
	private Forum_Ruels fr;
	private Vector<String> admins_names;
	Forum f;

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
		this.fr = new Forum_Ruels();
		assertTrue(b.addForum("name", "subject", admins_names, fr));
		this.f = fs.getForums().get(0);
	}

	@Test
	public void Ruels_test() {

		this.fr.setAdmin_can_add_moderator(false);
		this.fr.setAdmin_can_add_sub_forum(true);
		this.fr.setAdmin_can_delete_sub_forum(false);
		this.fr.setGuest_can_post(true);
		this.fr.setModerator_can_delete_post(false);
		this.fr.setModerator_can_suspend_member(false);
		this.fr.setModerator_can_add_moderator(false);

		assertNotNull(this.fs.getForums().get(0));
		assertEquals(this.fs.getForums().get(0).getRuels(), this.fr);

		assertFalse(this.fs.getForums().get(0).getRuels()
				.getAdmin_can_add_moderator());
		assertTrue(this.fs.getForums().get(0).getRuels()
				.getAdmin_can_add_sub_forum());
		assertFalse(this.fs.getForums().get(0).getRuels()
				.getAdmin_can_delete_sub_forum());
		assertTrue(this.fs.getForums().get(0).getRuels().getGuest_can_post());
		assertFalse(this.fs.getForums().get(0).getRuels()
				.getModerator_can_delete_post());
		assertFalse(this.fs.getForums().get(0).getRuels()
				.getModerator_can_suspend_member());
		assertFalse(this.fs.getForums().get(0).getRuels()
				.getModerator_can_add_moderator());
	}
}
