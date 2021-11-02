import java.util.ArrayList;
import java.util.UUID;

public class User {
	private UUID id;
	private String username;
	private String password;
	private String accounttype;
	private String school;
	private ArrayList<String> skills;
	private String company;
	private String firstname;
	private String lastname;
	private String email;
	private String phoneNumber;
	private String major;
	private String concentration;
	private String minor;
	private String gradeLevel;
	private String gpa;
	private ArrayList<String> extraCurr;
	private String status;
	private String jobOccupation;
	private String jobtype;
	private String prevExp;
	private String explength;
	private String jobdesc;
	private JobListings jobListings;
	
	public User(String username, String password, String accountType) {
		this.username = username;
		this.password = password;
		this.accounttype = accountType;
		this.jobListings = JobListings.getInstance();
	}

	public User(String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc) {
		this.id = UUID.randomUUID();
		this.username = username;
		this.password = password;
		this.accounttype = accounttype;
		this.school = school;
		this.company = company;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.minor = minor;
		this.concentration =concentration;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.skills = skills;
		this.extraCurr = extraCurr;
		this.status = status;
		this.jobOccupation = jobOccupation;
		this.jobtype = jobtype;
		this.prevExp = prevExp;
		this.explength = explength;
		this.jobdesc = jobdesc;
		this.jobListings = JobListings.getInstance();
	}

	public User(UUID id, String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.accounttype = accounttype;
		this.school = school;
		this.company = company;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.major = major;
		this.minor = minor;
		this.concentration =concentration;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.skills = skills;
		this.extraCurr = extraCurr;
		this.status = status;
		this.jobOccupation = jobOccupation;
		this.jobtype = jobtype;
		this.prevExp = prevExp;
		this.explength = explength;
		this.jobdesc = jobdesc;
		this.jobListings = JobListings.getInstance();

	}

	public void setUUID(UUID id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountType(String accountType) {
		this.accounttype = accountType;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public UUID getUuid() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAccounttype() {
		return accounttype;	
	}

	public String getSchool() {
        return school;
    }

	public String getFirstName() {
		return firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public String setName() {
		return firstname +" "+ lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCompany() {
		return company;
	}

	public String getMajor() {
		return major;
	}

	public String getMinor() {
		return minor;
	}

	public String getConcentation() {
		return concentration;
	}

	public String getGradeLevel() {
		return gradeLevel;
	}

	public String getGPA() {
		return gpa;
	}

	public ArrayList<String> getSkills() {
		return skills;
	}

	public ArrayList<String> getExtracurr() {
		return extraCurr;
	}

	public String getStatus() {
		return status;
	}

	public String getPrevExp() {
		return prevExp;
	}

	public String getExpLength() {
		return explength;
	}

	public String getJobDesc() {
		return jobdesc;
	}

	public String getjobOccupation() {
		return jobOccupation;
	}

	public String getjobType() {
		return jobtype;
	}
	// public String getAccountType2() {
	// 	return null;
	// }
	
	

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
	public String UserResumetoFile() {
		String string = " ";
		string += "Resume\nFirstname: "+ this.firstname + "\nLastname: " + this.lastname + "\nPhoneNumber: " + this.phoneNumber + "\nEmail :" +
		this.email +  "\nSchool: " + this. school + "\nMajor: " + this.major + "\nMinor: " + this.minor +
	   "\nConcentration" + this.concentration +  "\nGrade Level: " + this.gradeLevel + "\nGPA: " +
	    this.gpa + "\n";
	    string += "\nExperience: \n";
	    for(int index = 0; index < skills.size(); index++) {
			String element = skills.get(index);
			string += "- " + element + "\n";
		}
		string += "\n Extra Curriculars :\n";
		for(int index = 0; index < extraCurr.size(); index++) {
			String element = extraCurr.get(index);
			string += "- " + element + "\n";
		}
		string += "\nExperience: \n - Job Occupation: " +
		this.jobOccupation + "\n - Job Type: " + this.jobtype + "\n - Employer: " + this.prevExp + "\n - Job Length: " +
		this.explength + "\n - Job Description: " + this.jobdesc; 

		return string;
		// return "Resume\nFirstname: "+ this.firstname + "\nLastname: " + this.lastname + "\nPhoneNumber: " + this.phoneNumber + "\nEmail :" +
		//  this.email +  "\nSchool: " + this. school + "\nMajor: " + this.major + "\nMinor: " + this.minor +
		// "\nConcentration" + this.concentration +  "\nGrade Level: " + this.gradeLevel + "\nGPA: " +
		// this.gpa + "\nSkills :" + this.skills + "\nExtra Curricular: " + this.extraCurr + "\nExperience: \n - Job Occupation: " +
		// this.jobOccupation + "\n - Job Type: " + this.jobtype + "\n - Employer: " + this.prevExp + "\n - Job Length: " +
		// this.explength + "\n - Job Description: " + this.jobdesc; 
	}
}
