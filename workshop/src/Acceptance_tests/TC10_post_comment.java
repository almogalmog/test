package Acceptance_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Post;
import Service.Bridge;
import Service.Driver;

public class TC10_post_comment {
	private Post post;
	private Bridge b = Driver.getBridge();

	private Vector<String> admins_names;
	private Vector<String> mods_names;

	@Before
	public void setUp() throws Exception {
		b.createForumSystem("super", "admin", "mail", 22);
		b.registerToSystem("liran", "qwerty", "mail1", 30.0);
		b.registerToSystem("grey", "qwerty", "mail2", 30.0);
		b.registerToSystem("shirt", "qwerty", "mail3", 30.0);
		
		admins_names = new Vector<String>();
		admins_names.add("liran");
		admins_names.add("grey");
		
		this.mods_names= new Vector<String>();
		mods_names.add("shirt");
		assertTrue(b.addForum("name", "subject", admins_names, new Forum_Ruels()));
		assertTrue(b.registerToForum("name","shirt", "qwerty", "mail3", 30.0));
		assertTrue(b.createSubForum("name", "sub", "forum", mods_names, "shirt"));

		post =  b.postThread("name", "sub", "header", "body", "a");
		//what will be the unique identifier of post
		assertNotNull(b.postComment("comment", "post", "a", post));
	}

	@Test /*TR 52*/
	public void test_new_post_created() {
		assertNotNull(b.postComment("comment to ta ta ta","body", "Avi", post));
	}
	
	@Test /*TR 53*/
	public void test_added_to_kids_list() {
		b.postComment("comment to ta ta ta","body", "Avi", post);
		assertEquals(post.getKids().get(1).getHeader(), "comment to ta ta ta");
	}
	
	
	

}
