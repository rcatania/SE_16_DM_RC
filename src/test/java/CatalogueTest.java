import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class CatalogueTest {
	private Catalogue c;
	private Book[] lstAllBooks;
	Book bk1, bk2, bk3, bk4, bk5, bk6, bk7;
	
	@Before
	public void setUp() {
		Catalogue c = new Catalogue();
		
		bk1 = new Book("How to Build Everything", "Steve Grey", Genre.DIY, 1999, 5);
		bk2 = new Book("Black and White Photography", "John Rockwell", Genre.Hobbies, 2006, 2);
		bk3 = new Book("The Fault In Our Stars", "John Greene", Genre.Fiction, 2008, 4);
		bk4 = new Book("Java Cookbook", "Paul Singleton", Genre.IT, 2008, 4);
		bk5 = new Book("C Primer Plus", "Stephen Prata", Genre.IT, 2011, 4);
		bk6 = new Book("Advanced Programming in the Unix Environment", "Richard Stevens", Genre.IT, 1992, 4);
		bk7 = new Book("Catching Fire", "Suzanne Collins", Genre.Fiction, 2006, 3);
				
		c.addBook(bk1);
		c.addBook(bk2);
		c.addBook(bk3);
		c.addBook(bk4);
		c.addBook(bk5);
		c.addBook(bk6);
		c.addBook(bk7);
	}
	
	@Test
	public void testGetAllBooks() {
		ArrayList<Book> lst = c.getAllBooks();
		//assertArrayEquals(, c.getAllBooks())
		assertTrue(lst.contains(bk1));
	}

	@Test
	public void testSearchByTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchByGenre() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchByYearOfPublication() {
		fail("Not yet implemented");
	}

}
