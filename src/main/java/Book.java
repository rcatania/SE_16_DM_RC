import org.joda.time.LocalDate;

/**
 * Created by Dale & Romario on 05/04/2016.
 */
public class Book {
	private static int id_count = 0;
	private int id;
	private boolean isLoanedOut;
	private User loaneeUser;
	private LocalDate loanedOutDate;
	
    public LocalDate getLoanedOutDate() {
		return loanedOutDate;
	}

	public void setLoanedOutDate(LocalDate loanedOutDate) {
		this.loanedOutDate = loanedOutDate;
	}

	public boolean isLoanedOut() {
		return isLoanedOut;
	}
    
	public void markReturned() {
		isLoanedOut = false;
		if (!isLoanedOut) //since it may be loaned out on reservation
			loaneeUser = null;

	}
	
	public User getLoaneeUser() {
		return loaneeUser;
	}

	public void checkout(User u, LocalDate dateOfLoan) {
		loaneeUser = u; 
		isLoanedOut = true;
		loanedOutDate = dateOfLoan;
	}
	
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
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
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
	private String title;
    private String author;
    private Genre genre;
    private int yearofpublication;
    private int edition;

    public Book(String title, String author, Genre genre, int yearofpublication, int edition) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearofpublication = yearofpublication;
        this.edition = edition;
        this.id = id_count;
        this.isLoanedOut = false;
        this.loaneeUser = null;
        id_count++;
    }

}

