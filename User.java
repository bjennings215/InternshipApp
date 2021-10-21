import java.util.UUID;

public class User {
	private UUID id;
	private String username;
	private String password;
	boolean contains_xd;
	private boolean is_employer;
	private boolean is_student;
	
	public User(String username, String password, boolean contains_xd, boolean is_employer) {
		this.id = UUID.randomUUID();
		this.username = username;
		this.password = password;
		this.contains_xd = contains_xd;
		this.is_employer = is_employer;
	}

	public User(UUID id,String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;

	}

	public UUID getUuid() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//gets the account type for each user
	public boolean getAccounttype() {
		if(contains_xd = true) {
			return contains_xd;
		}
		if(is_employer = true) {
			return is_employer;
		}
		else {
			return is_student;
		}
	}

	
	

	// public boolean createAccount(String username, String password) {
	// 	if (username == null) {
	// 		this.username = username;
	// 		return true;
	// 	}
	// 	if (password == null) {
	// 		this.password = password;
	// 		return true;
	// 	}
	// 	else {
	// 		return false;
	// 	}
	// }
	
	// public boolean logIn(String username, String password) {
	// 	return false;
	// }
}
