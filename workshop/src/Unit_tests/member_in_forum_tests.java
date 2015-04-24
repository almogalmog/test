package Unit_tests;

import java.util.Vector;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.User_component.Member;
import Domain.User_component.MemberInForum;
import Domain.User_component.Super_Admin;

public class member_in_forum_tests extends TestCase {

	private Member m;
	private Forum f;
	private MemberInForum mif;

	@Before
	public void setUp() throws Exception {
		Forum_System fs = new Forum_System(
				new Super_Admin("a", "b", "mail", 40), "fs");
		
		Vector<Member> admins = new Vector<Member>();
		fs.addMember("grey", "456", "gery@gmail.com", 16);
		fs.addMember("shirt", "789", "shirt@gmail.com", 18);
		admins.add(fs.get_member_by_name("grey"));
		admins.add(fs.get_member_by_name("shirt"));
		this.f = fs.addForum(admins, new Forum_Ruels(), "name", "subj");
		
		fs.addMember("tester", "qwerty", "a", 40);
		f.register("tester");
		m=fs.get_member_by_name("tester");
		f.login(m.getName(), m.getPassword());
		mif = m.getMembersInForum(f);
		
	}

	@Test
	// 1
	public void test_set_connected() {
		assertTrue(mif.getConnected());

		mif.setConnected(false);
		assertFalse(mif.getConnected());
	}

	@Test
	// 2
	public void test_online_time() {
		assertTrue(mif.getConnected());
		for (int i = 0; i < 999999999; i++) {
		}
		assertNotSame(this.mif.getOnlineTime(), 0);
	}

}