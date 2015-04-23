package Acceptance_tests;

import static org.junit.Assert.assertFalse;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;
import Service.Bridge;

public class TC13_email_id {
	private Forum f;
	private Forum_System fs;
	private Super_Admin sa;
	private Forum_Ruels fr;
	private Bridge b = Service.Driver.getBridge();

	@Before
	public void setUp() throws Exception {
		this.sa = new Super_Admin("super", "qwerty", "workshop@gmail.com",20.0);
		this.fs= new Forum_System((Super_Admin) sa);
		
		Vector<Member> admins = new Vector<>();
		admins.add(new Member("liran", "qwerty", "mail", 30.0));
		admins.add(new Member("grey", "qwerty", "mail", 30.0));
		admins.add(new Member("shirt", "qwerty", "mail", 30.0));

		this.fr = new Forum_Ruels();
		this.f = fs.addForum(admins, fr, "name", "subject");
		
		b.registerToForum(f, "Avi", "sgysb", "avi@gmail.com", 51);
	}
	@Test /*TR 73*/
	public void test_cant_register_with_same_mail() {
		
		assertFalse(b.registerToForum(f, "sagi", "13y7c", "avi@gmail.com", 27));
	}
}
