package Acceptance_tests;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Post;
import Domain.Forum_component.Sub_Forum;
import Domain.Forum_component.Post;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC14_Delete_post {
	private Forum f;
	private Forum_Ruels fr;
	private Sub_Forum sub;
	private Member m;
	private Bridge b = Driver.getBridge();
	private Forum_System fs;
	private Super_Admin sa;
	
	@Before
	public void setUp() throws Exception {
		Vector<Member> admins = new Vector<>();
		admins.add(new Member("liran", "qwerty", "mail", 30.0));
		admins.add(new Member("grey", "qwerty", "mail", 30.0));
		admins.add(new Member("shirt", "qwerty", "mail", 30.0));

		Vector<Member> moderators = new Vector<Member>();
		moderators.add(new Member("mod1", "qwerty", "mail", 30.0));
		moderators.add(new Member("mod2", "qwerty", "mail", 30.0));
		
		this.sa = new Super_Admin("a", "b", "nail", 20);
		this.fs = new Forum_System(sa);

		b.addForum(fs, "forum", "animals", admins, new Forum_Ruels());
		this.f = fs.getForums().get(0);
		
		sub = f.createSubForum("Michael Jackson", "Music", moderators);
		this.m = new Member("tester", "qwerty", "mail", 20);
		f.register(m);
	}

	@Test
	public void test_same_user_can_delete() {
		b.postThread(sub, "post", "thread", m);
		Post thread = sub.getThreads().get(0);
		b.deletePost(thread, m);
		assertTrue(sub.getThreads().size() == 0);
	}
	
	
	@Test
	public void test_other_user_cant_delete() {
		b.postThread(sub, "post", "thread", m);
		Post thread = sub.getThreads().get(0);
		b.deletePost(thread, new Member("a", "v", "a", 15));
		assertTrue(sub.getThreads().size() == 1);
	}
	
	@Test
	public void test_delete_kids() {
		b.postThread(sub, "post", "thread", m);
		Post thread = sub.getThreads().get(0);
		b.postComment("com", "ment", m, thread);
		b.deletePost(thread, m);
		assertTrue(sub.getThreads().size() == 0);
	}
	
	
	@Test
	public void test_delete_kids2() {
		assertTrue(m.getConnected());
		assertTrue(f.isMember(m));
		assertTrue(f.getSubs(sa).contains(sub));

		Post thread = sub.add_thread("billie jean", "great song...", m);
		Post comment = thread.comment("true story", "yeah..", m);

		assertEquals(thread.getAuthor(), m);
		assertEquals(thread.getBody(), "great song...");
		assertEquals(thread.getHeader(), "billie jean");

		assertEquals(comment.getAuthor(), m);
		assertEquals(comment.getBody(), "yeah..");
		assertEquals(comment.getHeader(), "true story");

		assertTrue(comment.getParent() == thread);

		assertTrue(sub.getThreads().contains(thread));

		assertTrue(sub.getThreads().get(0).getKids().contains(comment));

		thread.remove_post();

		assertFalse(sub.getThreads().contains(thread));
	}

}
