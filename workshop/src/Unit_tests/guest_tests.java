package Unit_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Domain.Forum_component.Forum;
import Domain.User_component.Guest;

public class guest_tests {

	private Forum f;
	private Guest g;

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
