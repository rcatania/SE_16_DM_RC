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
		return null;
	}
	
	public ArrayList<Book> searchByGenre(Genre g) {
		return null;
	}
	
	public ArrayList<Book> searchByYearOfPublication(int year) {
		return null;
	}
}
