import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class BookReservationSystem {
	HashMap<Book, LinkedList<User>> res;
	private static BookReservationSystem instance;
	
	private BookReservationSystem() {
		instance = this;
		res = new HashMap<Book, LinkedList<User>>();
	}
	
	public static BookReservationSystem getInstance() {
		if (instance == null) 
			return new BookReservationSystem();
		return instance;
	}
	
	public void reserve_book(User u, Book b) {
	
	}
}
