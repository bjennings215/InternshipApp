import java.util.ArrayList;
import java.util.UUID;

public class Administrator extends User {
	
	public Administrator(UUID id, String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc) {
		super(id, username,password,accounttype,school,company,firstname,lastname,email,phoneNumber,major,minor,concentration,
		gradeLevel,gpa,skills,extraCurr,status,jobOccupation,jobtype,prevExp,explength,jobdesc);
	}
	
	private boolean editJobListing(JobListing jobListing) {
		return false;
	}
	
	private boolean deleteJobListing(JobListing jobListing) {
		return false;
	}
	
	private boolean deleteEmployer(Employer employer) {
		return false;
	}
	
	private boolean deleteStudent(Student student) {
		return false;
	}
	
	private boolean deleteReview(Review review) {
		return false;
	}
	
	private void filterStudents(ResumeFilter studentFilter) {
		
	}

	private void filterJobListing(JobFilter jobFilter) {
		
	}
	
	private Student searchStudent(Student student) {
		return student;
	}
	
	private Employer searchEmployer(Employer employer) {
		return employer;
	}
	
	private JobListing searchJobListing(JobListing jobListing) {
		return jobListing;
	}
}
