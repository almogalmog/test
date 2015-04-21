package Unit_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.I_Forum;
import Domain.Forum_component.I_Post;
import Domain.Forum_component.I_Sub_Forum;
import Domain.Forum_component.Sub_Forum;
import Domain.User_component.Member;

public class sub_forum_tests {
	private I_Sub_Forum sub;
	private Vector<Member> admins;
	private I_Forum forum;

	@Before
	public void setUp() throws Exception {
		admins = new Vector<Member>();
		admins.add(new Member("mod1", "qwerty", "mail", 30.0));
		admins.add(new Member("mod2", "qwerty", "mail", 30.0));
		this.forum = new Forum("a", "b", admins, new Forum_Ruels());
		this.sub = new Sub_Forum("Michael Jackson", "Music", admins, forum);

	}

	@Test
	/* 1 */
	public void test_get_name() {
		assertTrue(this.sub.getName() == "Michael Jackson");
	}

	@Test
	/* 2 */
	public void test_subjects_name() {
		assertTrue(this.sub.getSubject() == "Music");
	}

	@Test
	/* 3 */
	public void test_get_moderators() {
		assertTrue(this.sub.getModerators().equals(admins));
	}

	@Test
	/* 4 */
	public void test_add_mod() {
		this.sub.add_Moderator(new Member("mod3", "qwerty", "mail", 30.0));
		assertNotNull(this.sub.has_moderator("mod3"));
	}

	@Test
	/* 5 */
	public void test_add_sus_mod() {
		this.sub.add_Moderator(new Member("mod3", "qwerty", "mail", 30.0));
		this.sub.add_Suspended_Moderator("mod3");
		assertNotNull(this.sub.has_suspended_moderator("mod3"));
	}

	@Test
	/* 6 */
	public void test_thread() {
		Member m = new Member("tester", "qwerty", "mail", 20);
		this.forum.register(m);
		I_Post thread = sub.add_thread("billie jean", "great song...", m);

		assertEquals(thread.getAuthor(), m);
		assertEquals(thread.getBody(), "great song...");
		assertEquals(thread.getHeader(), "billie jean");

		assertTrue(sub.getThreads().contains(thread));
	}

	@Test
	/* 7 */
	public void test_set_subject() {
		sub.setSubject("People");
		assertTrue(sub.getSubject().equals("People"));

	}

	@Test
	/* 8 */
	public void test_get_sus_moderators() {
		Member m = new Member("mod3", "qwerty", "mail", 30.0);
		this.sub.add_Moderator(m);
		this.sub.add_Suspended_Moderator("mod3");
		assertTrue(this.sub.getSuspended_Moderators().contains(m));
	}

	@Test
	/* 9 */
	public void testComplaints() {
		Member m = new Member("mod3", "qwerty", "mail", 30.0);
		Member t = new Member("tester", "qwerty", "mail", 20);
		this.forum.register(m);
		this.forum.register(t);
		I_Post thread = sub.add_thread("billie jean", "great song...", m);

		assertTrue(this.sub.sendComplaint(m, "you suck", admins.get(0)));
		assertFalse(this.sub.sendComplaint(t, "ta ta taa", admins.get(0)));
	}

}
