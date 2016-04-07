import java.util.ArrayList;


public class Catalogue {
	private ArrayList<Book> cat = new ArrayList<Book>();
	
	public void addBook(Book b) {
		cat.add(b);
	}
	
	public void clearCatalogue() {
		cat.clear();
	}
 	
	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> newLst = new ArrayList<Book>();
		newLst.addAll(cat);
		return newLst;
	}
	
	public ArrayList<Book> searchByTitle(String title) {
		ArrayList<Book> newLst = new ArrayList<Book>();
		String lc_title = title.toLowerCase();
		for (Book bk : cat) {
			String bookTitle = bk.getTitle().toLowerCase();
			if (bookTitle != null && bookTitle.contains(lc_title))
				newLst.add(bk);
		}
		
		return newLst;
	}
	
	public ArrayList<Book> searchByGenre(Genre g) {
		return null;
	}
	
	public ArrayList<Book> searchByYearOfPublication(int year) {
		return null;
	}
}
