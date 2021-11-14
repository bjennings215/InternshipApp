import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataLoaderTest {
	private Users users = Users.getInstance();
	private ArrayList<User> userList = users.getUsers();
	
	@BeforeEach
	public void setup() {
		userList.clear();
        ArrayList<String> skills = new ArrayList<>();
        skills.add("Java");
        ArrayList<String> extraCurr = new ArrayList<>();
        extraCurr.add("captain of football team");
		ArrayList<String> jobsApplied = new ArrayList<>();
        jobsApplied.add("None\nCompany: None\nLocation: None, None\nLength: None\nEarnings Per Hour: None\nCompany Link: None\nDescription: None\nReviews made of previous experiences in this role\nnull");
        
        userList.add(new User("bcsmoak", "bcsmoak", "Student", "UofSC", null, "brady", 
        "smoak", "bcs@email.sc.edu", "1234567890", "CS", "business", null, "freshman", "3.7", skills, extraCurr,
        "unemployed", null, null, "Philly Special", "3 months", "cook",  jobsApplied));
		userList.add(new User("bcsmoa", "bcsmoa", "Employer", null, "Monsters Inc", "brady", 
        "smoak", "bcs@monstersinc.com", "1234567890", null, null, null, null, null, null, null,
        "unemployed", null, null, null, null, "Capturing screams", null));
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	
	@Test
	void testGetUsersSize() {
		userList = DataLoader.InputUsers();
		assertEquals(2, userList.size());
	}

	@Test
	void testGetUsersSizeZero() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
		assertEquals(0, userList.size());
	}
	
	@Test
	void testGetUserFirstUserName() {
		userList = DataLoader.InputUsers();
		assertEquals("bcsmoak", userList.get(0).getUsername());
	}
}
