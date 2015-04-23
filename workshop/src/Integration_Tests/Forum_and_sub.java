package Integration_Tests;

import static org.junit.Assert.assertEquals;

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

public class Forum_and_sub {
	private Forum f;
	private Forum_System fs;
	private Super_Admin sa;
	private Forum_Ruels fr;
	private Sub_Forum sub;
	private Post p;
	private Member tester;
	private Vector<Member> moderators ;
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

		this.f = this.fs.addForum(admins, fr, "name", "subject");
		
		
		moderators = new Vector<Member>();
		moderators.add(new Member("mod1", "qwerty", "mail", 30.0));
		moderators.add(new Member("mod2", "qwerty", "mail", 30.0));

		
		
		p=new Post("test", "tester", new Member("a", "b", "mail", 20), null, sub);
		
		this.tester = new Member("a", "b", "mail", 25);
	}
	
	@Test
	public void test_add_sub_to_forum(){
		sub = f.createSubForum("Animals", "Dogs", moderators);
		assertEquals(f.getSubs(sa).get(0), sub);
	}
	
	@Test
	public void test_remove_sub_from_forum(){
		sub = f.createSubForum("Animals", "Dogs", moderators);
		assertEquals(f.getSubs(sa).get(0), sub);
		f.delete_sub(sub, sa);
		assertEquals(f.getSubs(sa).size(), 0);
	}
}
