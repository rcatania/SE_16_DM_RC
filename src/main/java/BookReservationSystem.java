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
	
	public void return_book(Book b) {
		LinkedList<User> queue = res.get(b);
		if (queue == null || queue.size() == 0) {
			return;
		}
		
		User next = null;
		int i = 0;
		for ( i = 0; i < queue.size(); i++) { 
			next = queue.pop();
			if (next.eligibleToLoan()) {
				next.addBook(b);
				next.reservations.remove(b);
				break;
			} else {
				//adding to the end of the queue, so that they may get it in the future
				queue.push(next);
			}
		}
		
		if (i == queue.size()) { //no-one is eligible to loan
			return;
		}
				
		notify(b);
	}
	
	public void notify(Book b) {
		LinkedList<User> queue = res.get(b);
		for (int i = 0; i < queue.size(); i++) {
			Integer pos = queue.get(i).reservations.get(b);
			queue.get(i).reservations.put(b, pos-1);
		}
	}
}
	
