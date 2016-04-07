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
	
	@Test
	public void gettersSetters() {
		Book bk1 = new Book("", "", "", 2, 3);

		bk1.setAuthor("Anne Frank");
		assertTrue(bk1.getAuthor().equals("Anne Frank"));
		
		bk1.setTitle("Diary");
		assertTrue(bk1.getTitle().equals("Diary"));
		
		bk1.setGenre("Nonfiction");
		assertTrue(bk1.getGenre().equals("Nonfiction"));

		bk1.setYearofpublication(1945);
		assertTrue(bk1.getYearofpublication() == 1945);
		
		bk1.setEdition(3);
		assertTrue(bk1.getEdition() == 3);
	}
	

}
