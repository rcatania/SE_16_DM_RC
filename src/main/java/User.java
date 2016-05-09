import java.util.ArrayList;
import java.util.HashMap;

import org.joda.time.DateTime;
import org.joda.time.Days;


public class User {
	private static int id_count = 0;
	
	private int id;
	private String name;
	private int loancount;
	private ArrayList<Book> books_loaned;
	public HashMap<Book, Integer> reservations;
	
	public int getLoancount() {
		return loancount;
	}
	
	public User(String name) {
		super();
		this.name = name;
		this.id = id_count;
		this.books_loaned = new ArrayList<Book>();
		reservations = new HashMap<Book, Integer>();
		id_count++;
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void addBook(Book b) {
		books_loaned.add(b);
		loancount++;
	}
	
	public void removeBook(Book b) {
		books_loaned.remove(b);
		loancount--;
	}
	
	public boolean eligibleToLoan() {
		if (loancount >= 3)
			return false;
		
		for (Book b : books_loaned) {
			DateTime timeOfLoan = b.getLoanedOutDate().toDateTimeAtStartOfDay();
			int days = 
			Days.daysBetween(timeOfLoan.withTimeAtStartOfDay(), new DateTime().withTimeAtStartOfDay()).getDays();
			if (days >= 28) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isBookLoanedByUser(Book bk) {
		return books_loaned.contains(bk);

	}
}
