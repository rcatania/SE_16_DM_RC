/**
 * Created by Dale & Romario on 05/04/2016.
 */
public class Book {
	static int id_count = 0;
	int id;
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getYearofpublication() {
		return yearofpublication;
	}
	public void setYearofpublication(int yearofpublication) {
		this.yearofpublication = yearofpublication;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public int getId() {
		return id;
	}
	String title;
    String author;
    String genre;
    int yearofpublication;
    int edition;

    public Book(String title, String author, String genre, int yearofpublication, int edition) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearofpublication = yearofpublication;
        this.edition = edition;
        this.id = id_count;
        id_count++;
    }
    int method(){
        return 0;
    }

}

