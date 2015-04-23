package Unit_tests;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum_System;
import Domain.User_component.Member;
import Domain.User_component.Super_Admin;

public class member_tests extends TestCase {

	private Forum_System fs;
	private Super_Admin sa;


	@Before
	public void setUp() throws Exception {
		this.sa = new Super_Admin("", "", "", 50);
		this.fs = new Forum_System(sa);

	}

	@Test //1
	public void test_add_member(){
		fs.addMember("rona", "yesman", "rona@bambi.com", 18);
		fs.addMember("hadar", "imtired", "hadar@belle.com", 50);
		assertTrue("dudi is not in system",fs.searchMemberByName("dudi")==null);
		assertTrue("hadar is in system", fs.searchMemberByName("hadar")!=null);
		assertTrue("rona is in system", fs.searchMemberByName("rona")!=null);

	}

	@Test  //2
	public void test_member_friends() {
		Member liran = new Member("liran gret shirt", "qwerty","liran@gmail.com",30);
		Member abir = new Member("abir", "asdfg","abir@gmail.com",30);
		Member miri = new Member("miri", "123qwe","miri@gmail.com",30);
		Member evya = new Member("evya", "123qwe","evya@gmail.com",30);
		liran.addFriend(abir);
		liran.addFriend(miri);
		liran.addFriend(evya);

		assertTrue("abir is not friend of liran!",
				liran.getFriends().contains(abir));
		assertTrue("miri is not friend of liran!",
				liran.getFriends().contains(miri));
		assertTrue("evya is not friend of liran!",
				liran.getFriends().contains(evya));
	}

	@Test //3
	public void test_member_name() {
		Member liran = new Member("liran gret shirt", "qwerty","liran@gmail.com",30);
		assertEquals("User name is wrong!", "liran gret shirt",
				liran.getName());
	}

	@Test //4
	public void test_member_password() {
		Member liran = new Member("liran gret shirt", "qwerty","liran@gmail.com",30);
		assertEquals("User password is wrong!", "qwerty", liran.getPassword());
	}
	
	@Test //5
	public void test_single_member_parameters(){
		fs.addMember("rona", "imtired", "hadar@belle.com", 50);
		assertNull("Member name already registered in system",fs.addMember("rona", "yesman", "rona@bambi.com", 18));
		assertNull("mail already registered in system",fs.addMember("hadar", "yesman", "hadar@belle.com", 18));
	
	}




}
