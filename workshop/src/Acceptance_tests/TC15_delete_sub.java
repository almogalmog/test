package Acceptance_tests;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum;
import Domain.Forum_component.Sub_Forum;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;

public class TC15_delete_sub {
	private Forum f;
	private Forum_Ruels fr;
	private Member m;

	@Before
	public void setUp() throws Exception {

		this.m = new Member("liran", "qwerty", "mail", 30.0);
		Vector<Member> admins = new Vector<>();
		admins.add(m);
		admins.add(new Member("grey", "qwerty", "mail", 30.0));
		admins.add(new Member("shirt", "qwerty", "mail", 30.0));

		this.fr = new Forum_Ruels();
		this.f = new Forum(null, null, admins, fr);
	}

	@Test
	public void test() {
		Vector<Member> moderators = new Vector<>();
		moderators.add(new Member("mod1", "qwerty", "mail", 30.0));
		moderators.add(new Member("mod2", "qwerty", "mail", 30.0));
		moderators.add(new Member("mod3", "qwerty", "mail", 30.0));

		Sub_Forum sub = f
				.createSubForum("Michael Jackson", "Music", moderators);
		f.delete_sub(sub, m);
		assertFalse(f.getSubs(m).contains(sub));
	}

}
