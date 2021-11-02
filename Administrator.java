import java.util.ArrayList;
import java.util.UUID;

public class Administrator extends User {
	
	private JobListings allListings;

	public Administrator(UUID id, String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc) {
		super(id, username,password,accounttype,school,company,firstname,lastname,email,phoneNumber,major,minor,concentration,
		gradeLevel,gpa,skills,extraCurr,status,jobOccupation,jobtype,prevExp,explength,jobdesc);
		this.allListings = JobListings.getInstance();
	}

	public Administrator(String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc) {
		super(username,password,accounttype,school,company,firstname,lastname,email,phoneNumber,major,minor,concentration,
		gradeLevel,gpa,skills,extraCurr,status,jobOccupation,jobtype,prevExp,explength,jobdesc);
		this.allListings = JobListings.getInstance();
	}

	
	public void deleteJobListing(JobListing jobListing) {
		if(allListings.getJobList().contains(jobListing)) {
            allListings.removeJob(jobListing.getJobTitle());
            System.out.println("Job listing sucessfully deleted");
        } else {
            System.out.println("Could not find job listing");
        }
	}

	public boolean deleteEmployer(Employer employer) {
		return false;
	}
	
	public boolean deleteStudent(Student student) {
		return false;
	}
	
	public boolean deleteReview(Review review) {
		return false;
	}
	
	public void filterStudents(ResumeFilter studentFilter) {
		
	}

	public void filterJobListing(JobFilter jobFilter) {
		
	}
	
	public Student searchStudent(Student student) {
		return student;
	}
	
	public Employer searchEmployer(Employer employer) {
		return employer;
	}
	
	public JobListing searchJobListing(JobListing jobListing) {
		return jobListing;
	}
}
