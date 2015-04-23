package Unit_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.Forum_component.Forum_System;
import Domain.Forum_component.Sub_Forum;
import Domain.User_component.Member;
import Domain.User_component.MemberInForum;
import Domain.User_component.Super_Admin;

public class forum_tests {
	private Forum_System fs;
	private Super_Admin sa;
	private Forum f;
	private Vector<Member> admins;
	private Forum_Ruels fr;

	@Before
	public void setUp() throws Exception {
		this.sa = new Super_Admin("liran", "123", "liran@gmail.com", 23);
		this.admins = new Vector<>();
		this.admins.add(sa);
		this.fr = new Forum_Ruels();
		this.f = new Forum("name", "subject", admins, fr);
		this.fs = new Forum_System(sa);
		fs.addForum(admins, fr, "second", "forum");
		Member grey = fs.addMember("grey", "456", "gery@gmail.com", 16);
		Member shirt = fs.addMember("shirt", "789","shirt@gmail.com", 18);
		this.admins.add(grey);
		this.admins.add(shirt);
		Member boy = fs.addMember("boy", "789","boy@gmail.com", 18);
		f.addUser(boy);
	}
	
	@Test /*1*/
	public void testRegisterMember() {
		Member grey = fs.searchMemberByName("grey");
		this.f.register(grey);
		assertNotNull(this.f.getMember("grey"));
	}
	

	@Test /*2*/
	public void testAddSubForum() {
		Vector<Member> mods = new Vector<>();
		mods.add(new Member("alegriya", "123","alegriya@gmail.com", 20));
		mods.add(new Member("avishay", "123","avishay@gmail.com", 23));
		

		Sub_Forum sf =this.f.createSubForum("Animals","Biology", mods);
		
		assertTrue(this.f.getSubs(sa).get(0) == sf);
	}
	
	@Test /*3*/
	public void testWriteFirstPost(){
		Member grey = fs.searchMemberByName("grey");
		this.f.register(grey);
		
		Vector<Member> mods = new Vector<>();
		mods.add(new Member("alegriya", "123","alegriya@gmail.com", 20));
		mods.add(new Member("avishay", "123","avishay@gmail.com", 23));
		
	
		Sub_Forum sf =f.createSubForum("Animals","Biology", mods);
	//	f.writeFirstPost("animal brutality", "dont kill animals", grey, sf);
		assertTrue (sf.getThreads()!=null);
		
	}		
	//WTF???
	@Test /*4*/
	public void testWriteResponse(){
		
	}
	//WTF???
	@Test /*5*/
	public void testSetProperties(){
		fr.setNumberOfModerators(5);
		assertEquals(fr.getNumberOfModerators(),5);
		fr.setPasswordStrengh("**123");
		assertEquals (fr.getPasswordStrengh(), "**123");
		
	}
	@Test /*6*/
	public void testLoginGuest(){
		int sizeBefure = f.getUsers().size();
		f.loginGuest();
		assertEquals(sizeBefure +1, f.getUsers().size());
		
	}
	@Test /*7*/
	public void testCreateSubForum(){
		Vector<Member> mods = new Vector<>();
		mods.add(new Member("alegriya", "123","alegriya@gmail.com", 20));
		mods.add(new Member("avishay", "123","avishay@gmail.com", 23));
		Sub_Forum sf = f.createSubForum("Animals","Biology", mods);
		Sub_Forum st = new Sub_Forum("Bunnies", "Mammals", mods, f);
				
		assertTrue(f.getSubs(sa).contains(sf));
		assertFalse (f.getSubs(sa).contains(st));
		
		
	}
	
	@Test /*8*/
	public void testLogout(){
		f.register(fs.searchMemberByName("grey"));
		f.login("grey","456");
		assertTrue(f.getUsers().contains(fs.searchMemberByName("grey")));
		f.logout(fs.searchMemberByName("grey"));
		for(MemberInForum mif :f.getMember("grey").getMembersInForum()){
			if(mif.getForum()==f)
				assertFalse(mif.getConnected());
		}
	
	}
	@Test /*9*/
	
	public void testType(){
		f.add_type ("Pink",sa);
		assertTrue(f.getTypes(sa).contains("Pink"));	
		f.add_type("Purple", fs.searchMemberByName("boy"));
		assertFalse(f.getTypes(sa).contains("Purple"));
		assertNull(f.getTypes(fs.searchMemberByName("boy")));
		
	}
	
	
	
	
	
}
