import java.util.ArrayList;
import java.util.HashMap;


public class BookReservationSystem {
	public HashMap<Book, ArrayList<User>> res;
	private static BookReservationSystem instance;
	private Library l;
	private BookReservationSystem() {
		instance = this;
		res = new HashMap<Book, ArrayList<User>>();
	}
	
	public void register_library(Library l) {
		this.l = l;
	}
	
	public static BookReservationSystem getInstance() {
		if (instance == null) 
			return new BookReservationSystem();
		return instance;
	}
	
	public void reserve_book(User u, Book b) {
		ArrayList<User> queue = res.get(b);
		if (queue == null) {
			queue = new ArrayList<User>();
			res.put(b, queue);
		}
				
		queue.add(u);

		u.reservations.get(b);
		u.reservations.put(b, queue.size());
	}
	
	public void notifyBookReturned(Book b) {
		ArrayList<User> queue = res.get(b);
		if (queue == null || queue.size() == 0) {
			return;
		}
		
		User next = null;		
		int i = 0;
		for (; i < queue.size(); i++) { 
			next = queue.get(0);
			queue.remove(0); //pop operation
			if (next.eligibleToLoan()) {
				l.loanBookTo(b, next);
				next.reservations.remove(b);
				break;
			} else {
				//adding to the end of the queue, so that they may get it in the future
				queue.add(next);
			}
		} 
		
		if (i == queue.size()) { //no-one is eligible to loan
			return;
		}
				
		notifyUsersOnQueue(b);
	}
	
	public void notifyUsersOnQueue(Book b) {
		ArrayList<User> queue = res.get(b);
		for (int i = 0; i < queue.size(); i++) {
			Integer pos = queue.get(i).reservations.get(b);
			queue.get(i).reservations.put(b, pos);
		}
	}
}
	
