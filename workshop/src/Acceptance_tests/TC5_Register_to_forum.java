package Acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC5_Register_to_forum {
	private Forum f;
	private Forum_System fs;
	private Super_Admin sa;
	private Forum_Ruels fr;
	private Bridge b = Driver.getBridge();

	@Before
	public void setUp() throws Exception {
		this.sa = new Super_Admin("super", "qwerty", "workshopIsFun@gmail.com",
				20.0);
		this.fs = new Forum_System((Super_Admin) sa);

		Vector<Member> admins = new Vector<>();
		admins.add(new Member("liran", "qwerty", "mail", 30.0));
		admins.add(new Member("grey", "qwerty", "mail", 30.0));
		admins.add(new Member("shirt", "qwerty", "mail", 30.0));
		this.fr = new Forum_Ruels();

		b.addForum(fs, "name", "subject", admins, fr);
		this.f = this.fs.getForums().get(0);

	}

	@Test /*TR 12*/
	public void test_member_name(){
		assertTrue(b.registerToForum(f, null, "153d1fR", "abc@gmail.com", 25));
	}
	
	@Test /*TR 13*/
	public void test_password(){
		assertTrue(b.registerToForum(f, "gal", null, "gal@gmail.com", 24));
	}
	
	@Test /*TR 14*/
	public void test_second_password(){
		/*---*/
	}
	
	@Test /*TR 15*/
	public void test_mail(){
		assertTrue(b.registerToForum(f, "gal", "15616GFEg", null, 24));
	}
	
	@Test /*TR 17*/
	public void test_two_members_same_name(){
		assertTrue(b.registerToForum(f, "gal", "1566GFEg", "galt@gmail.com", 24));
		assertFalse(b.registerToForum(f, "gal", "14y6GFtc", "gd@gmail.com", 22));
	}
	
	@Test /*TR 21*/
	public void test_member_added(){
		assertTrue(b.registerToForum(f, "gal", "1566GFEg", "galt@gmail.com", 24));
		assertTrue(null!=f.getMember("gal"));
	}

}
