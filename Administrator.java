import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Administrator extends User {

	private Scanner scanner;
	private JobListings allListings;
	private Users users;


	public Administrator(UUID id, String username, String password, String accounttype, String school, String company,
			String firstname, String lastname, String email, String phoneNumber, String major, String minor,
			String concentration, String gradeLevel, String gpa, ArrayList<String> skills, ArrayList<String> extraCurr,
			String status, String jobOccupation, String jobtype, String prevExp, String explength, String jobdesc) {
		super(id, username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
				minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
				explength, jobdesc);
		this.scanner = new Scanner(System.in);
		this.allListings = JobListings.getInstance();
		this.users = Users.getInstance();
	}

	public Administrator(String username, String password, String accounttype, String school, String company,
			String firstname, String lastname, String email, String phoneNumber, String major, String minor,
			String concentration, String gradeLevel, String gpa, ArrayList<String> skills, ArrayList<String> extraCurr,
			String status, String jobOccupation, String jobtype, String prevExp, String explength, String jobdesc) {
		super(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor,
				concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength,
				jobdesc);
		this.scanner = new Scanner(System.in);
		this.allListings = JobListings.getInstance();
		this.users = Users.getInstance();
	}

	public void deleteJobListing(JobListing jobListing) {
		if (allListings.getJobList().contains(jobListing)) {
			allListings.removeJob(jobListing.getJobTitle());
			System.out.println("Job listing sucessfully deleted");
		} else {
			System.out.println("Could not find job listing");
		}
	}

	public void deleteEmployer(Employer employer) {
		this.users.removeUser(employer.getUsername(), employer.getPassword(), employer.getAccounttype(),
				employer.getSchool(), employer.getCompany(), employer.getFirstName(), employer.getLastName(),
				employer.getEmail(), employer.getPhoneNumber(), employer.getMajor(), employer.getMinor(),
				employer.getConcentation(), employer.getGradeLevel(), employer.getGPA(), employer.getSkills(),
				employer.getExtracurr(), employer.getStatus(), employer.getjobOccupation(), employer.getjobType(),
				employer.getPrevExp(), employer.getExpLength(), employer.getJobDesc());
	}

	public void deleteStudent(Student student) {
		this.users.removeUser(student.getUsername(), student.getPassword(), student.getAccounttype(),
				student.getSchool(), student.getCompany(), student.getFirstName(), student.getLastName(),
				student.getEmail(), student.getPhoneNumber(), student.getMajor(), student.getMinor(),
				student.getConcentation(), student.getGradeLevel(), student.getGPA(), student.getSkills(),
				student.getExtracurr(), student.getStatus(), student.getjobOccupation(), student.getjobType(),
				student.getPrevExp(), student.getExpLength(), student.getJobDesc());
	}

	public boolean deleteReview(Review review) {
		return false;
	}

	public User searchStudent() {
		System.out.println("Enter the name of the student you want to search for");
		System.out.print("First Name: ");
		String firstName = scanner.nextLine();
		System.out.print("Last Name: ");
		String lastName = scanner.nextLine();
		for(User user : users.getUsers()) {
			if(user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
				return user;
			}
		}
		return null;
	}

	public User searchEmployer() {
		System.out.println("Enter the name of the employer you want to search for");
		System.out.print("First Name: ");
		String firstName = scanner.nextLine();
		System.out.print("Last Name: ");
		String lastName = scanner.nextLine();
		for(User user : users.getUsers()) {
			if(user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
				return user;
			}
		}
		return null;
	}

	public JobListing searchJobListing() {
		System.out.println("Enter the job title you wish to search for");
		System.out.print("Job Title: ");
		String jobTitle = scanner.nextLine();
		return this.allListings.getJobListing(jobTitle);
	}
}
