import java.util.ArrayList;

import org.joda.time.LocalDate;


public class Library {
	private ArrayList<User> lstUsers = new ArrayList<User>();
	
	public void addUser(User u) {
		lstUsers.add(u);
	}
	
	public void removeUser(User u) {
		lstUsers.remove(u);
	}
	
	public int numberOfUsers() {
		return lstUsers.size();
	}
	
	public boolean isUserRegistered(User u) {
		return lstUsers.contains(u);
	}
	
	/**
	 * 
	 * @param b book
	 * @param u user
	 * @return True if the transaction was successful, false otherwise
	 */
	public boolean loanBookTo(Book b, User u) {
		if (!u.eligibleToLoan() || b.isLoanedOut()) 
			return false;
		LocalDate d = new LocalDate();
		b.checkout(u, d);
		u.addBook(b);
		
		return true;
	}
	
	//for unit testing
	public void clearLibrary() {
		lstUsers.clear();
	}
	
	public void returnBook(Book b) {// TODO: make sure this is eventually called by the observer
		if (!b.isLoanedOut())
			return;
		
		User loanee = b.getLoaneeUser();
		loanee.removeBook(b);
		b.markReturned();
		
		BookReservationSystem bks = BookReservationSystem.getInstance();
		bks.notifyBookReturned(b);
	}
}

