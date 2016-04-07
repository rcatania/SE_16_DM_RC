import static org.junit.Assert.*;

import org.junit.Test;


public class UserTest {

	@Test
	public void idTest() {
		User u1 = new User("abc");
		User u2 = new User("cdf");
		User u3 = new User("efg");
		
		//checking they are unique
		assertTrue((u1.getId() != u2.getId()) && (u1.getId() != u3.getId()) && (u2.getId() != u3.getId()));
	}
	
	@Test
	public void changeNameTest() {
		User u1 = new User("John");
		assertTrue("John".equals(u1.getName()));
		
		u1.setName("Paulo");
		assertTrue("Paulo".equals(u1.getName()));
	}
}
