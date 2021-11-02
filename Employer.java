import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;


public class Employer extends User {
   private ArrayList<JobListing> postedJobListings;
   private ArrayList<Student> favoriteStudents;
   private Scanner scanner;
   private JobListings jobListings;
   
   public Employer(UUID id, String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc) {
	   super(id, username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
      minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
      explength, jobdesc);
      this.postedJobListings = new ArrayList<>();
      this.favoriteStudents = new ArrayList<>();
      this.scanner = new Scanner(System.in);
      this.jobListings = JobListings.getInstance();
   }

   public Employer(String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc) {
      super(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
      minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
      explength, jobdesc);
      this.postedJobListings = new ArrayList<>();
      this.favoriteStudents = new ArrayList<>();
      this.scanner = new Scanner(System.in);
      this.jobListings = JobListings.getInstance();
   }
   
   public ArrayList<JobListing> getPostedJobListings() {
	   return this.postedJobListings;
   }
   
   public ArrayList<Student> getAcceptedStudents() {
	   return this.favoriteStudents;
   }
   
   public void postNewJobListing() {
      JobListings jobListings = JobListings.getInstance();
      System.out.print("Job Title: ");
      String jobTitle = scanner.nextLine();
      System.out.print("Job Description: ");
      String jobDescription = scanner.nextLine();
      System.out.print("Location (City, State): ");
      String location = scanner.nextLine();
      System.out.print("Wage Per Hour: $");
      String jobWagePerHour = scanner.nextLine();
      System.out.print("Number of Months: ");
      String numofMonths = scanner.nextLine();
      System.out.print("Employer Website Link: ");
      String companyLink = scanner.nextLine();
      System.out.print("Date Posted: ");
      String jobExpDate = scanner.nextLine();
      System.out.println("\nNew Job Listing Created!");

      String jobCompany = getCompany();
      String[] locations = location.split(", ");
      String jobCityLocation = locations[0];
      String jobStateLocation = locations[1];
      ArrayList<Review> jobReviews = new ArrayList<>();
      ArrayList<Student> studentsApplied = new ArrayList<>();

      this.postedJobListings.add(new JobListing(jobTitle, jobCompany, jobDescription, jobCityLocation,
              jobStateLocation, numofMonths, companyLink, jobWagePerHour, jobReviews, studentsApplied, jobExpDate));

      this.jobListings.addJob(jobTitle, jobCompany, jobDescription, jobCityLocation, jobStateLocation, numofMonths,
              companyLink, jobWagePerHour, jobReviews, studentsApplied, jobExpDate);
   }
   
   public boolean deleteJobListing(JobListing jobListing) {
	   return false;
   }

   public void editJobListing(JobListing jobListing) {

   }

   public void filterStudent(ResumeFilter filter) {
	   
   }
   
   private Student searchStudent(Student student) {
	   return student;
   }
   
   public boolean acceptStudent(Student student, JobListing jobListing) {
	   return true;
   }
   
   public boolean rejectStudent(Student studentm, JobListing jobListng) {
	   return false;
   }
   
}
