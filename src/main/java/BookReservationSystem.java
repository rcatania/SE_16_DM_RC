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
		LinkedList<User> queue = res.get(b);
		if (queue == null) {
			res.put(b, new LinkedList<User>());
			queue = new LinkedList<User>();
		}
				
		queue.add(u);
		
		assert(u.reservations.get(b) == null);
		
		u.reservations.put(b, queue.size());
	}

}
