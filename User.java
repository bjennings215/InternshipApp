import java.util.UUID;

public class User {
	private UUID id;
	private String username;
	private String password;
	
	public User() {
		
	}

	public User(String username, String password) {
		this.id = UUID.randomUUID();
		this.username = username;
		this.password = password;
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
