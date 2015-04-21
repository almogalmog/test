package Unit_tests;
import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.I_Forum_Ruels;
import Domain.Forum_component.I_Forum_System;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;

public class forumRules_tests {

	private I_Forum_System fs;
	private Super_Admin sa;
	private I_Forum_Ruels fr;

	@Before
	public void setUp() throws Exception {
		this.sa = new Super_Admin("super", "admin", "mail", 22);
		this.fs = new Forum_System(sa);
		this.fr = new Forum_Ruels();
		fs.addForum(new Vector<Member>(), fr, "nam", "subject");
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
