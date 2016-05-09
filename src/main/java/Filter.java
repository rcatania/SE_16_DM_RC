import java.util.ArrayList;


public class Filter {
	public SearchField searchfield;
	private String argument;
	private ArrayList<Filter> childfilters;
	
	Filter(String argument, SearchField searchfield) {
		this.argument = argument;
		this.searchfield = searchfield;
	}
	
	void addChildFilter(Filter f) {
		childfilters.add(f);
	}
	
}
