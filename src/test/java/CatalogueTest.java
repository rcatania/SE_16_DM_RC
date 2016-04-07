import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


public class CatalogueTest {
	private Catalogue c;
	private Book[] lstAllBooks;
	Book bk1, bk2, bk3, bk4, bk5, bk6, bk7, bk8;
	
	@Before
	public void setUp() {
		c = new Catalogue();
		
		bk1 = new Book("How to Build Everything", "Steve Grey", Genre.DIY, 1999, 5);
		bk2 = new Book("Black and White Photography", "John Rockwell", Genre.Hobbies, 2006, 2);
		bk3 = new Book("The Fault In Our Stars", "John Greene", Genre.Fiction, 2008, 4);
		bk4 = new Book("Java Cookbook", "Paul Singleton", Genre.IT, 2008, 4);
		bk5 = new Book("C Primer Plus", "Stephen Prata", Genre.IT, 2011, 4);
		bk6 = new Book("Advanced Programming in the Unix Environment", "Richard Stevens", Genre.IT, 1992, 4);
		bk7 = new Book("Catching Fire", "Suzanne Collins", Genre.Fiction, 2006, 3);
		bk8 = new Book("Coffee: from Java to Arabica", "John Mocha", Genre.Hobbies, 2011, 2);
		
		c.addBook(bk1);
		c.addBook(bk2);
		c.addBook(bk3);
		c.addBook(bk4);
		c.addBook(bk5);
		c.addBook(bk6);
		c.addBook(bk7);
		c.addBook(bk8);
	}
	
	@Test
	public void testGetAllBooks() {
		ArrayList<Book> lst = c.getAllBooks();
		assertTrue(lst.size() == 8);
		assertTrue(lst.contains(bk1));
		assertTrue(lst.contains(bk2));
		assertTrue(lst.contains(bk3));
		assertTrue(lst.contains(bk4));
		assertTrue(lst.contains(bk5));
		assertTrue(lst.contains(bk6));
		assertTrue(lst.contains(bk7));
		assertTrue(lst.contains(bk8)); 
	}

	@Test
	public void testSearchByTitle() {
		ArrayList<Book> empty = c.searchByTitle("sjdfsdjfl");
		assertTrue(empty.isEmpty());
		
		ArrayList<Book> javaBooks = c.searchByTitle("java");
		assertTrue(javaBooks.size() == 2);
		assertTrue(javaBooks.contains(bk8) && javaBooks.contains(bk4));
		
	}

	@Test
	public void testSearchByGenre() {
		ArrayList<Book> empty = c.searchByGenre(Genre.Children);
		assertTrue(empty.isEmpty());
		
		assertTrue(c.searchByGenre(Genre.IT).size() == 3);
		assertTrue(c.searchByGenre(Genre.Hobbies).size() == 2);
		assertTrue(c.searchByGenre(Genre.Fiction).size() == 2);
		assertTrue(c.searchByGenre(Genre.DIY).size() == 1);
		assertTrue(c.searchByGenre(Genre.DIY).get(0).getTitle().equals("How to Build Everything")); 
		
	}

	@Test
	public void testSearchByYearOfPublication() {
		ArrayList<Book> empty = c.searchByYearOfPublication(1898);
		assertTrue(empty.isEmpty());
		
		ArrayList<Book> books2011 = c.searchByYearOfPublication(2011);
		assertTrue(books2011.size() == 2);
		
		ArrayList<Book> books99 = c.searchByYearOfPublication(1999);
		assertTrue(books99.size() == 1);
		assertTrue(books99.get(0).getGenre().equals(Genre.DIY));
	}

}
