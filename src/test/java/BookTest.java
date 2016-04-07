import static org.junit.Assert.*;

import org.junit.Test;


public class BookTest {

	@Test
	public void testConstructor() {
		Book bk = new Book("", "", "", 2, 3);
		assertTrue(bk != null);
	}
	
	@Test
	public void testIdVal() {
		Book bk1 = new Book("", "", "", 2, 3);
		Book bk2 = new Book("", "", "", 2, 3);
		Book bk3 = new Book("", "", "", 2, 3);

		assertTrue((bk1.getId() != bk2.getId()) && (bk1.getId() != bk3.getId()) && (bk2.getId() != bk3.getId()));

	}
	

}
