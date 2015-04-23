package Acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Sub_Forum;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC9_post_thread {
	private Forum_System fs;
	private Super_Admin sa;
	private Forum f;
	private Sub_Forum sub;
	private Vector<Member> moderators;
	private Bridge b = Driver.getBridge();
	private Member m;
	@Before
	public void setUp() throws Exception {
		this.sa = new Super_Admin("a", "a", "b", 20);
		this.fs=new Forum_System(sa);
		Vector<Member> admins = new Vector<>();
		admins.add(new Member("liran", "qwerty", "mail", 30.0));
		admins.add(new Member("grey", "qwerty", "mail", 30.0));
		admins.add(new Member("shirt", "qwerty", "mail", 30.0));

		moderators = new Vector<Member>();
		moderators.add(new Member("mod1", "qwerty", "mail", 30.0));
		moderators.add(new Member("mod2", "qwerty", "mail", 30.0));

		b.addForum(fs, "forum", "subject", admins, new Forum_Ruels());
		this.f = fs.getForums().get(0);
		sub = f.createSubForum("Michael Jackson", "Music", moderators);

		m = new Member("tester", "qwerty", "mail", 20);
		f.register((Member) m);
		f.login(m.getName(), m.getPassword());
		
		b.postThread(sub, "header", "body", sa);
	}

	@Test
	public void test_empty_header() {
		assertFalse(b.postThread(sub, "", "body", m));
	}
	@Test
	public void test_empty_body() {
		assertFalse(b.postThread(sub, "header", "", m));
	}
	
	@Test
	public void test_thread_inserted() {
		assertTrue(sub.getThreads().get(0).getHeader()== "header");
	}
	
	@Test
	public void test_num_of_messages(){
		int num = m.getMembersInForum(f).getNumOfPosts();
		b.postThread(sub, "a", "b", m);
		assertTrue(m.getMembersInForum(f).getNumOfPosts() == num+1);
	}
	
}
