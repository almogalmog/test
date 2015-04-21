package Unit_tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.Forum_component.I_Forum;
import Domain.User_component.Guest;
import Domain.User_component.I_Guest;

public class guest_tests {

	private I_Forum f;
	private I_Guest g;

	@Before
	public void setUp() throws Exception {
		this.f = new Forum("forum", "subject", null, null);
	}

	@Test //1
	public void test_guest_init(){
		int num = 100;
		this.g = new Guest(f, num);
		
		assertEquals(this.g.getForum(), this.f);
	}
}
