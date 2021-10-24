import java.util.UUID;

public class Administrator extends User {
	
	public Administrator(UUID id, String username, String password) {
		super(id, username, password);
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
