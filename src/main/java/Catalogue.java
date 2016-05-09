import java.util.ArrayList;


public class Catalogue {
	private ArrayList<Book> cat = new ArrayList<Book>();
	private static Catalogue instance;
	private Catalogue() { };
	
	public static Catalogue getInstance() {
		if (instance == null) {
			instance = new Catalogue();
		}
		return instance;
	}

	public void addBook(Book b) {
		cat.add(b);
	}
	
	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> newLst = new ArrayList<Book>();
		newLst.addAll(cat);
		return newLst;
	}
	
	public ArrayList<Book> searchForBooks(Filter f) {
		ArrayList<Book> updated = new ArrayList<Book>();
		for (Book b : cat) {
			if (f.checkBookFits(b)) {
				updated.add(b);
			}
		}
		return updated;
	}
}
