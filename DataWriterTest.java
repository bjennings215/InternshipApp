import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class DataWriterTest {
    private Users users = Users.getInstance();
	private ArrayList<User> userList = users.getUsers();

	
	@BeforeEach
	public void setup() {
		Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
	}

    @AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}

    @Test
	public void testWritingZeroUsers() {
		userList = DataLoader.InputUsers();
		assertEquals(0, userList.size());
	}

    @Test
    public void testWritingEmptyFields(){
        String username = "";
        String password = "";
        String firstname = "";
        String lastname = "";
        String company = "";
        String accounttype = "";
        String school = "";
        String major = "";
        String minor = "";
        String concentration = "";
        String gradeLevel = "";
        String gpa = "";
        ArrayList<String> skills = new ArrayList<>();
        ArrayList<String> extraCurr = new ArrayList<>();
        String prevExp = "";
        String explength = "";
        String jobdesc = "";
        String status = "";
        String email = "";
        String phoneNumber = "";
        String jobOccupation = "";
        String jobtype = "";
        ArrayList<String> jobsApplied = new ArrayList<>();
        userList.add(new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor, concentration,
         gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength, jobdesc, jobsApplied));
         DataWriter.saveUsers();
         assertEquals("", DataLoader.InputUsers().get(0).getUsername());
    }

    @Test
    public void testWritingAllFields() {
        String username = "david.greg";
        String password = "1234";
        String firstname = "David";
        String lastname = "Greg";
        String company = "None";
        String accounttype = "Student";
        String school = "USC";
        String major = "CIS";
        String minor ="BIM";
        String concentration = "CS";
        String gradeLevel = "Junior";
        String gpa = "3.1";
        ArrayList<String> skills = new ArrayList<>();
        skills.add("Java");
        ArrayList<String> extraCurr = new ArrayList<>();
        extraCurr.add("captain of football team");
        String prevExp = "Officemax";
        String explength = "08/2015 - 09/2020";
        String jobdesc = "Sell computers";
        String status = "Unemployed";
        String email = "gregmdavid@email.com";
        String phoneNumber = "999-9999";
        String jobOccupation = "Sales Associate";
        String jobtype = "Part-Time";
        ArrayList<String> jobsApplied = new ArrayList<>();
        //writes joblisting fields to a string
        jobsApplied.add("None\nCompany: None\nLocation: None, None\nLength: None\nEarnings Per Hour: None\nCompany Link: None\nDescription: None\nReviews made of previous experiences in this role\nnull");
        userList.add(new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor, concentration,
         gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength, jobdesc, jobsApplied));
         DataWriter.saveUsers();
         assertEquals("david.greg", DataLoader.InputUsers().get(0).getUsername());
    }

    @Test
	void testWritingTwoDifferentUsers() {
        String username = "daniel.smith";
        String password = "4321";
        String firstname = "Daniel";
        String lastname = "Smith";
        String company = "Voltech";
        String accounttype = "Employer";
        String school = "";
        String major = "";
        String minor ="";
        String concentration = "";
        String gradeLevel = "";
        String gpa = "";
        ArrayList<String> skills = new ArrayList<>();
        ArrayList<String> extraCurr = new ArrayList<>();
        String prevExp = "";
        String explength = "";
        String jobdesc = "";
        String status = "";
        String email = "smithwdaniel@email.com";
        String phoneNumber = "222-2222";
        String jobOccupation = "";
        String jobtype = "";
        ArrayList<String> jobsApplied = new ArrayList<>();
		userList.add(new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor, concentration,
        gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength, jobdesc, jobsApplied));
        username = "david.greg";
        password = "1234";
        firstname = "David";
        lastname = "Greg";
        company = "None";
        accounttype = "Student";
        school = "USC";
        major = "CIS";
        minor ="BIM";
        concentration = "CS";
        gradeLevel = "Junior";
        gpa = "3.1";
        skills = new ArrayList<>();
        skills.add("Java");
        extraCurr = new ArrayList<>();
        extraCurr.add("captain of football team");
        prevExp = "Officemax";
        explength = "08/2015 - 09/2020";
        jobdesc = "Sell computers";
        status = "Unemployed";
        email = "gregmdavid@email.com";
        phoneNumber = "999-9999";
        jobOccupation = "Sales Associate";
        jobtype = "Part-Time";
        jobsApplied = new ArrayList<>();
        userList.add(new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor, concentration,
         gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength, jobdesc, jobsApplied));
		DataWriter.saveUsers();
		assertNotEquals("david.smith", DataLoader.InputUsers().get(0).getUsername());
	}

    @Test
    public void testWritingMultipleSkills() {
        String username = "";
        String password = "";
        String firstname = "";
        String lastname = "";
        String company = "";
        String accounttype = "";
        String school = "";
        String major = "";
        String minor = "";
        String concentration = "";
        String gradeLevel = "";
        String gpa = "";
        ArrayList<String> skills = new ArrayList<>();
        skills.add("excel");
        skills.add("powerpoint");
        ArrayList<String> extraCurr = new ArrayList<>();
        String prevExp = "";
        String explength = "";
        String jobdesc = "excel";
        String status = "";
        String email = "";
        String phoneNumber = "";
        String jobOccupation = "";
        String jobtype = "";
        ArrayList<String> jobsApplied = new ArrayList<>();
        userList.add(new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor, concentration,
         gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength, jobdesc, jobsApplied));
         DataWriter.saveUsers();
        ArrayList testskills = new ArrayList<String>();
        testskills.add("excel");
        testskills.add("powerpoint");
         assertLinesMatch(testskills, DataLoader.InputUsers().get(0).getSkills());
        
    }

}
