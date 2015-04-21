package Test_Suits;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

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
	sub_forum_tests.class})
	
	
public class Unit {

}
