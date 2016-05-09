import java.util.ArrayList;


public class Filter {
	public SearchField searchfield;
	private String argument;
	private ArrayList<Filter> childfilters;
	
	Filter(String argument, SearchField searchfield) {
		this.argument = argument;
		this.searchfield = searchfield;
		childfilters = new ArrayList<Filter>();
	}
	
	Filter addChildFilter(Filter f) {
		childfilters.add(f);
		return this;
	}
	
	Filter addChildFilter(String argument, SearchField searchfield) {
		return addChildFilter(new Filter(argument, searchfield));
	}
	public boolean checkBookFits(Book b) {
		boolean condition = false;
		switch(searchfield) {
		case GENRE:{
			condition = b.getGenre().ordinal() == Genre.valueOf(argument).ordinal();
			break;
		}
		case TITLE : {
			String bookTitle = b.getTitle().toLowerCase();
			if (bookTitle.contains(argument))
				condition = true;
			break;
		}
		case YEAR_OF_PUBLICATION: {
			int year = Integer.parseInt(argument);
			condition = year == b.getYearofpublication();
			break;
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
