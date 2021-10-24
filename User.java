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
	private String major;
	private String concentration;
	private String minor;
	private String gradeLevel;
	private String gpa;
	private ArrayList<String> extraCurr;
	private String status;
	private ArrayList<String> prevExp;
	private ArrayList<String> explength;
	private ArrayList<String> jobdesc;
	
	public User(String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, ArrayList<String> prevExp, ArrayList<String> explength, 
	ArrayList<String> jobdesc) {
		this.id = UUID.randomUUID();
		this.username = username;
		this.password = password;
		this.accounttype = accounttype;
		this.school = school;
		this.company = company;
		this.firstname = firstname;
		this.lastname = lastname;
		this.major = major;
		this.minor = minor;
		this.concentration =concentration;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.skills = skills;
		this.extraCurr = extraCurr;
		this.status = status;
		this.prevExp = prevExp;
		this.explength = explength;
		this.jobdesc = jobdesc;
	}

	public User(UUID id, String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, ArrayList<String> prevExp, ArrayList<String> explength, 
	ArrayList<String> jobdesc) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.accounttype = accounttype;
		this.school = school;
		this.company = company;
		this.firstname = firstname;
		this.lastname = lastname;
		this.major = major;
		this.minor = minor;
		this.concentration =concentration;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.skills = skills;
		this.extraCurr = extraCurr;
		this.status = status;
		this.prevExp = prevExp;
		this.explength = explength;
		this.jobdesc = jobdesc;

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

	public String gradelevel() {
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

	public ArrayList<String> getPrevExp() {
		return prevExp;
	}

	public ArrayList<String> getExpLength() {
		return explength;
	}

	public ArrayList<String> getJobDesc() {
		return jobdesc;
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
}
