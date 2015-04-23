package Unit_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Forum_Ruels;
import Domain.User_component.Member;

public class post_tests {
	private Forum f;

	@Before
	public void setUp() throws Exception {
			this.f= new Forum("a", "b", new Vector<Member>(), new Forum_Ruels());
	}

	@Test //1
	public void test_if_initialize_as_true() {
		
		assertTrue(this.f.getRuels().getAdmin_can_delete_post());
		assertTrue(this.f.getRuels().getMember_can_add_sub_forum());
		assertTrue(this.f.getRuels().getGuest_can_reply());
	}
	
	@Test //2
	public void test_if_set() {
		
		this.f.getRuels().setAdmin_can_switch_moderator(false);
		this.f.getRuels().setMember_can_post(false);
		assertFalse(this.f.getRuels().getAdmin_can_switch_moderator());
		assertFalse(this.f.getRuels().getMember_can_post());
	}


}
