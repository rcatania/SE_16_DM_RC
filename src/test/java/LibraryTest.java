import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class LibraryTest {
	Library l;
	
	@Before
	public void setUp() {
		l = new Library();
	}
	
	@Test
	public void testAddUser() {
		User u = new User("John Micallef");
		User u1 = new User("Dale Micallef");
		User u2 = new User("Luke Spiteri");
		User u3 = new User("Andre Borg");
		User u4 = new User("Jeremy Curmi");
		User u5 = new User("Rachel Sammut");

		assertTrue(l.numberOfUsers() == 0);

		l.addUser(u);
		assertTrue(l.numberOfUsers() == 1);
		l.addUser(u1);
		l.addUser(u2);
		l.addUser(u3);
		l.addUser(u4);
		l.addUser(u5);

		assertTrue(l.numberOfUsers() == 6);
		assertTrue(l.isUserRegistered(u2));
	}

	@Test
	public void testRemoveUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testNumberOfUsers() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsUserRegistered() {
		fail("Not yet implemented");
	}

}
