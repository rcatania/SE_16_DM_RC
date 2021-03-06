import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class LibraryTest {
	Library l;
	User u, u1, u2, u3, u4, u5;
	Book bk1, bk2, bk3, bk4, bk5, bk6, bk7, bk8;
	
	@Before
	public void setUp() {
		l = new Library();
		u = new User("John Micallef");
		u1 = new User("Dale Micallef");
		u2 = new User("Luke Spiteri");
		u3 = new User("Andre Borg");
		u4 = new User("Jeremy Curmi");
		u5 = new User("Rachel Sammut");
		
		bk1 = new Book("How to Build Everything", "Steve Grey", Genre.DIY, 1999, 5);
		bk2 = new Book("Black and White Photography", "John Rockwell", Genre.Hobbies, 2006, 2);
		bk3 = new Book("The Fault In Our Stars", "John Greene", Genre.Fiction, 2008, 4);
		bk4 = new Book("Java Cookbook", "Paul Singleton", Genre.IT, 2008, 4);
		bk5 = new Book("C Primer Plus", "Stephen Prata", Genre.IT, 2011, 4);
		bk6 = new Book("Advanced Programming in the Unix Environment", "Richard Stevens", Genre.IT, 1992, 4);
		bk7 = new Book("Catching Fire", "Suzanne Collins", Genre.Fiction, 2006, 3);
		bk8 = new Book("Coffee: from Java to Arabica", "John Mocha", Genre.Hobbies, 2011, 2);
	}
	
	@After
	public void dropEverything() {
		l.clearLibrary();
	}
	
	@Test
	public void testAddUser() {
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
		l.addUser(u);
		l.addUser(u1);
		l.addUser(u2);
		l.addUser(u3);
		l.addUser(u4);
		l.addUser(u5);
		
		assertTrue(l.numberOfUsers() == 6);

		l.removeUser(u4);		
		assertTrue(l.numberOfUsers() == 5);

		l.removeUser(u4);
		assertTrue(l.numberOfUsers() == 5);
		l.removeUser(u1);
		l.removeUser(u2);
		l.removeUser(u3);

		assertTrue(l.numberOfUsers() == 2);
		assertTrue(l.isUserRegistered(u5));
	}
	
	@Test
	public void basicLoanTest() {
		l.addUser(u1);
		assertFalse(bk1.isLoanedOut());
		
		l.returnBook(bk1);
		
		assertFalse(bk1.isLoanedOut());
		assertTrue(u1.eligibleToLoan());
		assertTrue(u1.getLoancount() == 0);
		
		assertTrue(l.loanBookTo(bk1, u1));
		
		assertTrue(bk1.isLoanedOut());
		assertTrue(u1.eligibleToLoan());
		assertTrue(u1.getLoancount() == 1);
	}

	@Test
	public void loanSameBookMultipleTimes() {
		l.addUser(u1);

		assertTrue(l.loanBookTo(bk1, u1));
		assertFalse(l.loanBookTo(bk1, u1));
		assertFalse(l.loanBookTo(bk1, u1));
		assertFalse(l.loanBookTo(bk1, u1));	
		
		assertTrue(u1.getLoancount() == 1);
		assertTrue(bk1.isLoanedOut());
	}
	
	@Test
	public void loanMoreThan3Books() {
		l.addUser(u1);
		
		assertTrue(l.loanBookTo(bk1, u1));

		assertTrue(l.loanBookTo(bk2, u1));
		assertTrue(l.loanBookTo(bk3, u1));
		
		//because he has already loaned 3 books
		assertFalse(l.loanBookTo(bk4, u1));
		
		assertTrue(bk1.isLoanedOut());
		assertTrue(bk2.isLoanedOut());
		assertTrue(bk3.isLoanedOut());
	}

	@Test
	public void bookLoanedByMoreThanOnePerson() {
		l.addUser(u1);
		l.addUser(u2);
		
		assertTrue(l.loanBookTo(bk1, u1));
		assertFalse(l.loanBookTo(bk1, u2));
		
		assertTrue(bk1.isLoanedOut());
	}

	@Test
	public void basicReturningBooks() {
		l.addUser(u1);
		
		l.loanBookTo(bk1, u1);
		l.loanBookTo(bk2, u1);
		l.loanBookTo(bk3, u1);
		assertFalse(l.loanBookTo(bk4, u1));
		
		assertTrue(u1.getLoancount() == 3);
		assertTrue(bk3.isLoanedOut());

		bk5.markReturned(); //book 5 has not been loaned out
		
		l.returnBook(bk3);

		assertTrue(u1.getLoancount() == 2);
		assertFalse(bk3.isLoanedOut());
		assertTrue(l.loanBookTo(bk3, u1));
	}

	@Test 
	public void test2WeeksDuration() {
		l.addUser(u1);
		
		l.loanBookTo(bk1, u1);
		LocalDate d = new LocalDate();
		
		bk1.setLoanedOutDate(d.minusWeeks(5));

		assertFalse(l.loanBookTo(bk2, u1));
		assertTrue(l.loanBookTo(bk2, u2)); //make sure it has no effect on other users
	}
	
	@Test 
	public void reservationSystem() {
		l.addUser(u);
		l.addUser(u1);
		l.addUser(u2);
		l.addUser(u3);
		l.addUser(u4);
		l.addUser(u5);
		
		l.loanBookTo(bk1, u);

		assertTrue(bk1.isLoanedOut());
		BookReservationSystem brsys = BookReservationSystem.getInstance();
		brsys.register_library(l);
		brsys.reserve_book(u1, bk1);
		brsys.reserve_book(u2, bk1);
		brsys.reserve_book(u3, bk1);
		brsys.reserve_book(u4, bk1);

		l.returnBook(bk1); //from u to u1
		
		assertTrue(u1.isBookLoanedByUser(bk1));
		assertFalse(u.isBookLoanedByUser(bk1));
		assertTrue(bk1.isLoanedOut()); //has been automatically loaned
		
		l.returnBook(bk1); //from u1 to u2
		
		assertTrue(bk1.isLoanedOut()); //has been automatically loaned
		assertTrue(u2.isBookLoanedByUser(bk1));
				
		l.returnBook(bk1); //from u2 to u3
		
		assertTrue(bk1.isLoanedOut()); //has been automatically loaned
		assertFalse(u2.isBookLoanedByUser(bk1));
		assertTrue(u3.isBookLoanedByUser(bk1));
	
		l.returnBook(bk1); //u3 to u4
		assertTrue(bk1.isLoanedOut());
		assertTrue(u4.isBookLoanedByUser(bk1));
		
		l.returnBook(bk1); //u4 to shelf
		assertFalse(bk1.isLoanedOut());
	}
	
	@Test 
	public void reservingBooksMoreThan3LoanedOut() {
		// Only for coverage's sake
		SearchField.valueOf("GENRE");
		//
		l.addUser(u);
		l.addUser(u1);
		l.addUser(u2);
		l.addUser(u3);
		l.addUser(u4);
		l.addUser(u5);
		
		l.loanBookTo(bk1, u);

		assertTrue(bk1.isLoanedOut());
		BookReservationSystem brsys = BookReservationSystem.getInstance();
		brsys.register_library(l);
		brsys.reserve_book(u1, bk1);
		brsys.reserve_book(u2, bk1);
	
		l.loanBookTo(bk2, u1);
		l.loanBookTo(bk3, u1);
		l.loanBookTo(bk4, u1);
		
		l.returnBook(bk1); //from u to u1
		assertTrue(u2.isBookLoanedByUser(bk1));
		
		l.returnBook(bk2);
		l.returnBook(bk1);
		assertTrue(u1.isBookLoanedByUser(bk1));
	}
}
