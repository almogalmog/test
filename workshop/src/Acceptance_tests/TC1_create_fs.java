package Acceptance_tests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.I_Forum_System;
import Domain.User_component.Super_Admin;
import Service.Bridge;
import Service.Driver;

public class TC1_create_fs {
	private I_Forum_System fs;
	private Bridge b = Driver.getBridge();

	@Before
	public void setUp() throws Exception {
		fs = b.createForumSystem("super", "admin", "workshopisfun@gmail.com", 22);
	}

	// use case 1 - init forum system
	@Test
	public void test_not_null_and_sa() {
		assertNotNull(fs);
	}
	
	@Test
	public void test_sa(){
		assertEquals("super", fs.getSuper_admin().getName());
		assertEquals("admin", fs.getSuper_admin().getPassword());
		assertEquals("workshopisfun@gmail.com", fs.getSuper_admin().getEmail());
		assertTrue(22.0 == fs.getSuper_admin().getAge());
	}
	
	
	@Test
	public void empty_dorum_vec (){
		assertNotNull(fs.getForums());
		assertTrue(fs.getForums().size() ==0);
	}
	
	@Test
	public void testForumSystemFields(){
		assertTrue(fs.getMembers().size()==1);
		assertTrue(fs.getMembers().get(0).getName()=="super");
	}
	
}
