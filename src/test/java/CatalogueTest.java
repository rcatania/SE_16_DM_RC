import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CatalogueTest {
	private Catalogue c;
	private Book[] lstAllBooks;
	static Book bk1, bk2, bk3, bk4, bk5, bk6, bk7, bk8, bk9, bk10;
	static boolean setup = false;
	
	@Before
	public void setUp() {
		//c = new Catalogue();
		c = Catalogue.getInstance();
		
		if (setup)
			return;
		
		bk1 = new Book("How to Build Everything", "Steve Grey", Genre.DIY, 1999, 5);
		bk2 = new Book("Black and White Photography", "John Rockwell", Genre.Hobbies, 2006, 2);
		bk3 = new Book("The Fault In Our Stars", "John Greene", Genre.Fiction, 2008, 4);
		bk4 = new Book("Java Cookbook", "Paul Singleton", Genre.IT, 2008, 4);
		bk5 = new Book("C Primer Plus", "Stephen Prata", Genre.IT, 2011, 4);
		bk6 = new Book("Advanced Programming in the Unix Environment", "Richard Stevens", Genre.IT, 1992, 4);
		bk7 = new Book("Catching Fire", "Suzanne Collins", Genre.Fiction, 2006, 3);
		bk8 = new Book("Coffee: from Java to Arabica", "John Mocha", Genre.Hobbies, 2011, 2);
		bk9 = new Book("Most Horrible Murders", "John Mocha", Genre.Nonfiction, 1972, 2);
		bk10 = new Book("1972 Guiness Bokk of Records", "John Mocha", Genre.Hobbies, 1972, 2);

		c.addBook(bk1);
		c.addBook(bk2);
		c.addBook(bk3);
		c.addBook(bk4);
		c.addBook(bk5);
		c.addBook(bk6);
		c.addBook(bk7);
		c.addBook(bk8);
		c.addBook(bk9);
		c.addBook(bk10);
		
		setup = true;
	}
	
	@Test
	public void testGetAllBooks() {
		ArrayList<Book> lst = c.getAllBooks();
		assertTrue(lst.size() == 10);
		assertTrue(lst.contains(bk1));
		assertTrue(lst.contains(bk2));
		assertTrue(lst.contains(bk3));
		assertTrue(lst.contains(bk4));
		assertTrue(lst.contains(bk5));
		assertTrue(lst.contains(bk6));
		assertTrue(lst.contains(bk7));
		assertTrue(lst.contains(bk8)); 
		assertTrue(lst.contains(bk9)); 
		assertTrue(lst.contains(bk10)); 
	}

	@Test
	public void testSearchByTitle() {
		ArrayList<Book> empty = c.searchForBooks(new Filter( "sjdfsdjfl", SearchField.TITLE));
		assertTrue(empty.isEmpty());
				
		ArrayList<Book> javaBooks =  c.searchForBooks(new Filter( "java", SearchField.TITLE));
		assertTrue(javaBooks.size() == 2);
		assertTrue(javaBooks.contains(bk8) && javaBooks.contains(bk4));
	}

	@Test
	public void testSearchByGenre() {
		ArrayList<Book> empty =  c.searchForBooks(new Filter(Genre.Children.name(), SearchField.GENRE));
		assertTrue(empty.isEmpty());
		
		assertTrue( c.searchForBooks(new Filter(Genre.Children.name(), SearchField.GENRE)).size() == 0);
		assertTrue( c.searchForBooks(new Filter(Genre.IT.name(), SearchField.GENRE)).size() == 3);
		assertTrue( c.searchForBooks(new Filter(Genre.Hobbies.name(), SearchField.GENRE)).size() == 3);
		assertTrue( c.searchForBooks(new Filter(Genre.Fiction.name(), SearchField.GENRE)).size() == 2);
		assertTrue( c.searchForBooks(new Filter(Genre.DIY.name(), SearchField.GENRE)).size() == 1);
		assertTrue( c.searchForBooks(new Filter(Genre.DIY.name(), SearchField.GENRE)).get(0).getTitle().equals("How to Build Everything")); 
		
	}

	@Test
	public void testSearchByYearOfPublication() {
		ArrayList<Book> empty = c.searchForBooks(new Filter("1898", SearchField.YEAR_OF_PUBLICATION));
		assertTrue(empty.isEmpty());
		
		ArrayList<Book> books2011 = c.searchForBooks(new Filter("2011", SearchField.YEAR_OF_PUBLICATION));
		assertTrue(books2011.size() == 2);
		
		ArrayList<Book> books99 = c.searchForBooks(new Filter("1999", SearchField.YEAR_OF_PUBLICATION)); 
		assertTrue(books99.size() == 1);
		assertTrue(books99.get(0).getGenre().equals(Genre.DIY));
	}

	@Test
	public void singleCatalogueTest() {
		Catalogue c2 = Catalogue.getInstance();
		assertTrue(c2.getAllBooks().size() == 10);
	}
	
	@Test
	public void compoundSearchTest() {
		ArrayList<Book> one = c.searchForBooks(new Filter("murders", SearchField.TITLE).addChildFilter("1972", SearchField.YEAR_OF_PUBLICATION));
		assertTrue(one.size() == 1);
	}

	
}
