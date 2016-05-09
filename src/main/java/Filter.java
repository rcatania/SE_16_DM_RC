import java.util.ArrayList;


public class Filter {
	public SearchField searchfield;
	private String argument;
	private ArrayList<Filter> childfilters;
	
	Filter(String argument, SearchField searchfield) {
		this.argument = argument;
		this.searchfield = searchfield;
	}
	
	Filter addChildFilter(Filter f) {
		childfilters.add(f);
		return this;
	}
	
	Filter addChildFilter(String argument, SearchField searchfield) {
		childfilters.add(new Filter(argument, searchfield));
		return this;
	}
	public boolean checkBookFits(Book b) {
		boolean condition = false;
		switch(searchfield) {
		case GENRE:{
			condition = b.getGenre() == Genre.valueOf(argument);
		}
		case TITLE : {
			String bookTitle = b.getTitle().toLowerCase();
			if (bookTitle != null && bookTitle.contains(argument))
				condition = true;
		}
		case YEAR_OF_PUBLICATION: {
			int year = Integer.parseInt(argument);
			condition = year == b.getYearofpublication();
		}
		}
		
		for (Filter f : childfilters) {
			if (!condition) 
				break;
			condition &= f.checkBookFits(b);
		}
		
		return condition;
	}
}
