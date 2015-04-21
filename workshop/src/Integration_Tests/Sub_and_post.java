package Integration_Tests;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.I_Forum;
import Domain.Forum_component.I_Forum_Ruels;
import Domain.Forum_component.I_Forum_System;
import Domain.Forum_component.I_Post;
import Domain.Forum_component.I_Sub_Forum;
import Domain.Forum_component.Post;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;

public class Sub_and_post {
	private I_Forum f;
	private I_Forum_System fs;
	private Super_Admin sa;
	private I_Forum_Ruels fr;
	private I_Sub_Forum sub;
	private I_Post p;
	private Member tester;

	@Before
	public void setUp() throws Exception {
		this.sa = new Super_Admin("super", "qwerty", "workshopIsFun@gmail.com",
				20.0);
		this.fs = new Forum_System(sa);

		Vector<Member> admins = new Vector<>();
		admins.add(new Member("liran", "qwerty", "mail", 30.0));
		admins.add(new Member("grey", "qwerty", "mail", 30.0));
		admins.add(new Member("shirt", "qwerty", "mail", 30.0));

		this.fr = new Forum_Ruels();
		this.f = this.fs.addForum(admins, fr,"name", "subject");
		
		Vector<Member> moderators = new Vector<Member>();
		moderators.add(new Member("mod1", "qwerty", "mail", 30.0));
		moderators.add(new Member("mod2", "qwerty", "mail", 30.0));

		
		
		sub = f.createSubForum("Animals", "Dogs", moderators);
		
		p=new Post("test", "tester", new Member("a", "b", "mail", 20), null, sub);
		
		this.tester = new Member("a", "b", "mail", 25);
		f.register(tester);
	}
	
	@Test
	public void test_add_thread_to_sub(){
		
		I_Post test = sub.add_thread("lol", "bla", tester);
		assertEquals(sub.getThreads().get(0), test);
	}
	
	@Test
	public void test_delete_thread_from_sub(){
		I_Post test = sub.add_thread("lol", "bla", tester);
		assertEquals(sub.getThreads().get(0), test);
		test.remove_post();
		assertEquals(sub.getThreads().size(), 0);
	}
	
	
}
