package Test_Suits;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Acceptance_tests.TC10_post_comment;
import Acceptance_tests.TC11_members_types;
import Acceptance_tests.TC12_complaint;
import Acceptance_tests.TC13_email_id;
import Acceptance_tests.TC14_Delete_post;
import Acceptance_tests.TC15_delete_sub;
import Acceptance_tests.TC1_create_fs;
import Acceptance_tests.TC2_add_forum;
import Acceptance_tests.TC3_FR_params;
import Acceptance_tests.TC4_guest_enterance;
import Acceptance_tests.TC5_Register_to_forum;
import Acceptance_tests.TC6_login;
import Acceptance_tests.TC6_logout;
import Acceptance_tests.TC7_create_sub_forum;
import Acceptance_tests.TC8_view;
import Acceptance_tests.TC9_post_thread;
import Integration_Tests.Forum_and_sub;
import Integration_Tests.Forums_and_user;
import Integration_Tests.Register_to_forum;
import Integration_Tests.Sub_and_post;
import Unit_tests.forumRules_tests;
import Unit_tests.forum_tests;
import Unit_tests.guest_tests;
import Unit_tests.member_in_forum_tests;
import Unit_tests.member_tests;
import Unit_tests.post_tests;
import Unit_tests.sub_forum_tests;

@RunWith(Suite.class)
@SuiteClasses({ 
	
	//unit test
	forum_tests.class,
	forumRules_tests.class,
	guest_tests.class,
	member_in_forum_tests.class,
	member_tests.class,
	post_tests.class,
	sub_forum_tests.class,
		
	
	//test cases
	TC1_create_fs.class,
	TC2_add_forum.class,
	TC3_FR_params.class,
	TC4_guest_enterance.class,
	TC5_Register_to_forum.class,
	TC5_Register_to_forum.class,
	TC6_login.class,
	TC6_logout.class,
	TC7_create_sub_forum.class,
	TC8_view.class,
	TC9_post_thread.class,
	TC10_post_comment.class,
	TC11_members_types.class,
	TC12_complaint.class,
	TC13_email_id.class,
	TC14_Delete_post.class,
	TC15_delete_sub.class,
	
	//integration tests
	Register_to_forum.class,
	Forum_and_sub.class,
	Sub_and_post.class,
	Forums_and_user.class})
public class AllTests {

}
