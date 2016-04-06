import static org.junit.Assert.*;
import org.junit.Test;


public class BookTest {

	@Test
		public void test() {
		Book bk = new Book("", "", "", 2, 3);
		assertTrue(bk != null);
	}
	

}
