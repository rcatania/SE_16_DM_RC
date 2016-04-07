import java.util.ArrayList;


public class Library {
	ArrayList<User> lstUsers = new ArrayList<User>();
	public void addUser(User u) {
		lstUsers.add(u);
	}
	
	public void removeUser(User u) {
		lstUsers.remove(u);
	}
	
	public int numberOfUsers() {
		return lstUsers.size();
	}
	
	public boolean isUserRegistered(User u) {
		return lstUsers.contains(u);
	}
}
