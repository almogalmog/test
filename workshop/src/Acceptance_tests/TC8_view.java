package Acceptance_tests;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum;
import Domain.Forum_component.Sub_Forum;
import Domain.Forum_component.Sub_Forum;
import Domain.User_component.User;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;

public class TC8_view {
	private Forum f;
	private Forum_Ruels fr;
	private Sub_Forum sub1;
	private Sub_Forum sub2;
	private User sa;

	@Before
	public void setUp() throws Exception {
		this.sa = new Super_Admin("a", "b", "c", 20);
		Vector<Member> admins = new Vector<>();
		admins.add(new Member("liran", "qwerty", "mail", 30.0));
		admins.add(new Member("grey", "qwerty", "mail", 30.0));
		admins.add(new Member("shirt", "qwerty", "mail", 30.0));
		Vector<Member> moderators1 = new Vector<Member>();
		moderators1.add(new Member("mod1", "qwerty", "mail", 30.0));
		moderators1.add(new Member("mod2", "qwerty", "mail", 30.0));
		Vector<Member> moderators2 = new Vector<Member>();
		moderators2.add(new Member("mod3", "qwerty", "mail", 30.0));

		this.fr = new Forum_Ruels();
		this.f = new Forum(null,null,admins, fr);
		sub1 = f.createSubForum("Michael Jackson", "Music", moderators1);
		sub2 = f.createSubForum("Dogs", "Animals", moderators2);
	}

	@Test
	public void test_member_view() {
		assertNotNull(f.getSubs(sa).get(0));
		assertNotNull(f.getSubs(sa).get(1));

		Vector<Sub_Forum> subs = f.loginGuest();
		assertEquals(sub1, subs.get(0));
		assertEquals(sub2, subs.get(1));
	}

	public void test_guest_view() throws UnsupportedEncodingException {
		Member m = new Member("tester", "qwerty", "mail", 20);
		f.register(m);
		assertTrue(f.isMember(m));

		Forum f1 = f.login(m.getName(), m.getPassword());
		assertEquals(f1, f);

		assertNotNull(f1.getSubs(sa));
		assertEquals(sub1, f1.getSubs(sa).get(0));
		assertEquals(sub2, f1.getSubs(sa).get(1));

	}
}
