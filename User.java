/**
 * @author Adam Trickett,Brandon Jennings,Brady Smoak, Esam Sartawi
 * @param id this is the id that is used to make users different and is unique to all users
 * @param username the username of the person to be added
 * @param password the password
 * @param accounttype the type of account (admin,student,employer)
 * @param school the school of person 
 * @param company name of company
 * @param firstname firstname
 * @param lastname lastname
 * @param email email of person
 * @param phoneNumber phonenumber
 * @param major students major
 * @param minor students minor
 * @param concentration students concentration area
 * @param gradeLevel gradelevel
 * @param gpa grade point average
 * @param skills skills the student has
 * @param extraCurr extracurricular activities
 * @param status job status
 * @param jobOccupation job occupation
 * @param jobtype job type
 * @param prevExp previous experience
 * @param explength experience length
 * @param jobdesc job description
 * @param jobListings used to create an instance of the joblisting file
 */
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
	private ArrayList<JobListing> jobsApplied;
	/**
	 * constructor for the user.java file
	 * @param username username
	 * @param password password 
	 * @param accountType account type (student, employer, admin)
	 */
	public User(String username, String password, String accountType) {
		this.username = username;
		this.password = password;
		this.accounttype = accountType;
		this.jobListings = JobListings.getInstance();
	}
	/**
	 * this is used to get the type user
	* @param username the username of the person to be added
	* @param password the password
	* @param accounttype the type of account (admin,student,employer)
	* @param school the school of person 
	* @param company name of company
	* @param firstname firstname
	* @param lastname lastname
	* @param email email of person
	* @param phoneNumber phonenumber
	* @param major students major
	* @param minor students minor
	* @param concentration students concentration area
	* @param gradeLevel gradelevel
	* @param gpa grade point average
	* @param skills skills the student has
	* @param extraCurr extracurricular activities
	* @param status job status
	* @param jobOccupation job occupation
	* @param jobtype job type
	* @param prevExp previous experience
	* @param explength experience length
	* @param jobdesc job description
	 */
	public User(String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc,ArrayList<JobListing> jobsApplied) {
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
		this.jobsApplied = jobsApplied;
	}
	/**
	* this is used to set the type user
	* @param username the username of the person to be added
	* @param password the password
	* @param accounttype the type of account (admin,student,employer)
	* @param school the school of person 
	* @param company name of company
	* @param firstname firstname
	* @param lastname lastname
	* @param email email of person
	* @param phoneNumber phonenumber
	* @param major students major
	* @param minor students minor
	* @param concentration students concentration area
	* @param gradeLevel gradelevel
	* @param gpa grade point average
	* @param skills skills the student has
	* @param extraCurr extracurricular activities
	* @param status job status
	* @param jobOccupation job occupation
	* @param jobtype job type
	* @param prevExp previous experience
	* @param explength experience length
	* @param jobdesc job description
	*/
	public User(UUID id, String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc,ArrayList<JobListing> jobsApplied) {
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
		this.jobsApplied = jobsApplied;

	}
	/**
	 * this is used to set the unique user id
	 * @param id this is the unique user id 
	 */
	public void setUUID(UUID id) {
		this.id = id;
	}
	/**
	 * this is the getter for the uuid
	 * @return the id
	 */
	public UUID getUuid() {
		return id;
	}
	/**
	 * this gets the username
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * this is the getter for password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * this gets the account type
	 * @return the account type
	 */
	public String getAccounttype() {
		return accounttype;	
	}
	/**
	 * this gets the school
	 * @return the school 
	 */
	public String getSchool() {
        return school;
    }
	/**
	 * gets the firstname 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstname;
	}
	/**
	 * gets the lastname 
	 * @return the lastname
	 */
	public String getLastName() {
		return lastname;
	}
	/**
	 * sets the name 
	 * @return the name combined
	 */
	public String setName() {
		return firstname +" "+ lastname;
	}
	/**
	 * gets the email
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * gets the phone number
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * gets the company
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * gets the major
	 * @return returns the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * gets the minor
	 * @return the minor
	 */
	public String getMinor() {
		return minor;
	}
	/**
	 * gets the concentration
	 * @return the concentration
	 */
	public String getConcentation() {
		return concentration;
	}
	/**
	 * gets the gradelevel
	 * @return the gradelevel
	 */
	public String getGradeLevel() {
		return gradeLevel;
	}
	/**
	 * gets the gpa 
	 * @return the gpa
	 */
	public String getGPA() {
		return gpa;
	}
	/**
	 * gets the arraylist of skills
	 * @return the skills arraylist
	 */

	public ArrayList<String> getSkills() {
		return skills;
	}
	/**
	 * gets the extracurricular arraylist
	 * @return returns the extracurricular arraylist
	 */
	public ArrayList<String> getExtracurr() {
		return extraCurr;
	}
	/**
	 * gets the status
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * gets the previous experience
	 * @return the previous experience
	 */
	public String getPrevExp() {
		return prevExp;
	}
	/**
	 * gets the experience length
	 * @return the experience length
	 */
	public String getExpLength() {
		return explength;
	}
	/**
	 * gets the job description
	 * @return the job description
	 */
	public String getJobDesc() {
		return jobdesc;
	}
	/**
	 * gets the job occupation
	 * @return the job occupation
	 */
	public String getjobOccupation() {
		return jobOccupation;
	}
	/**
	 * gets the job type
	 * @return the job type
	 */
	public String getjobType() {
		return jobtype;
	}

	public ArrayList<JobListing> getJobsApplied() {
		return jobsApplied;
	}
	/**
	 * this returns a to string of all of the variables concatenated to go into the txt file
	 * @return the final product string
	 */
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
	}
}
