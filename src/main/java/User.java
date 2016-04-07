
public class User {
	private static int id_count = 0;
	
	private int id;
	private String name;
	public User(String name) {
		super();
		this.name = name;
		this.id = id_count;
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
	
	
}
