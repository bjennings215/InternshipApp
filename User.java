
public class User {
	String username;
	String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean createAccount(String username, String password) {
		if (username == null) {
			this.username = username;
			return true;
		}
		if (password == null) {
			this.password = password;
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean logIn(String username, String password) {
		return false;
	}
}
