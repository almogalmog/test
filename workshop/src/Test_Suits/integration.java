package Test_Suits;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Integration_Tests.Forum_and_sub;
import Integration_Tests.Forums_and_user;
import Integration_Tests.Register_to_forum;
import Integration_Tests.Sub_and_post;

@RunWith(Suite.class)
@SuiteClasses({ 
	//integration tests
	Register_to_forum.class,
	Forum_and_sub.class,
	Sub_and_post.class,
	Forums_and_user.class})
public class integration {

}
