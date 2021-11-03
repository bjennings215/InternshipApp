import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author Adam, Brandon, Brady, Esam
 */
public class Administrator extends User {

	private Scanner scanner;
	private JobListings allListings;
	private Users users;

    /**
	 * Sets up admin user
	 * @param id admin's id
	 * @param username admin's username
	 * @param password admin's password
	 * @param accounttype account type of user, this case admin
	 * @param school null
	 * @param company null
	 * @param firstname null
	 * @param lastname null
	 * @param email admin's email
	 * @param phoneNumber admin's number
	 * @param major null	
	 * @param minor null
	 * @param concentration null
	 * @param gradeLevel null
	 * @param gpa null
	 * @param skills null
	 * @param extraCurr null
	 * @param status null
	 * @param jobOccupation null
	 * @param jobtype null
	 * @param prevExp null
	 * @param explength null
	 * @param jobdesc null
	 */
	public Administrator(UUID id, String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc,ArrayList<String> jobsApplied) {
		super(id, username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
				minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
				explength, jobdesc,jobsApplied);
		this.scanner = new Scanner(System.in);
		this.allListings = JobListings.getInstance();
		this.users = Users.getInstance();
	}

	/**
	 * Sets up admin user
	 * @param id admin's id
	 * @param username admin's username
	 * @param password admin's password
	 * @param accounttype account type of user, this case admin
	 * @param school null
	 * @param company null
	 * @param firstname null
	 * @param lastname null
	 * @param email admin's email
	 * @param phoneNumber admin's number
	 * @param major null	
	 * @param minor null
	 * @param concentration null
	 * @param gradeLevel null
	 * @param gpa null
	 * @param skills null
	 * @param extraCurr null
	 * @param status null
	 * @param jobOccupation null
	 * @param jobtype null
	 * @param prevExp null
	 * @param explength null
	 * @param jobdesc null
	 */
	public Administrator(String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc,ArrayList<String> jobsApplied) {
		super(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor,
				concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength,
				jobdesc,jobsApplied);
		this.scanner = new Scanner(System.in);
		this.allListings = JobListings.getInstance();
		this.users = Users.getInstance();
	}
    /**
	 * allows Admin to delete a job listing
	 * @param jobListing the job being deleted
	 */
	public void deleteJobListing(JobListing jobListing) {
		if (allListings.getJobList().contains(jobListing)) {
			allListings.removeJob(jobListing.getJobTitle());
			System.out.println("Job listing sucessfully deleted");
		} else {
			System.out.println("Could not find job listing");
		}
	}

	/**
	 * allows admin to delete employer account
	 * @param user account being deleted
	 */
	public void deleteEmployer(User user) {
		this.users.removeUser(user.getUsername(), user.getPassword(), user.getAccounttype(),
				user.getSchool(), user.getCompany(), user.getFirstName(), user.getLastName(),
				user.getEmail(), user.getPhoneNumber(), user.getMajor(), user.getMinor(),
				user.getConcentation(), user.getGradeLevel(), user.getGPA(), user.getSkills(),
				user.getExtracurr(), user.getStatus(), user.getjobOccupation(), user.getjobType(),
				user.getPrevExp(), user.getExpLength(), user.getJobDesc(),user.getJobsApplied());
	}

	/**
	 * allows admin to delete student account
	 * @param user account being deleted
	 */
	public void deleteStudent(User user) {
		this.users.removeUser(user.getUsername(), user.getPassword(), user.getAccounttype(),
		user.getSchool(), user.getCompany(), user.getFirstName(), user.getLastName(),
		user.getEmail(), user.getPhoneNumber(), user.getMajor(), user.getMinor(),
		user.getConcentation(), user.getGradeLevel(), user.getGPA(), user.getSkills(),
		user.getExtracurr(), user.getStatus(), user.getjobOccupation(), user.getjobType(),
		user.getPrevExp(), user.getExpLength(), user.getJobDesc(),user.getJobsApplied());
	}

	/**
	 * allows admin to delete a review
	 * @param review review being deleted
	 * @return
	 */
	public boolean deleteReview(Review review) {
		return false;
	}
}
