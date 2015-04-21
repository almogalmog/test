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

@RunWith(Suite.class)
@SuiteClasses({ 
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
	TC15_delete_sub.class})
public class Acceptance_test {

}
