import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author Adam, Brandon, Brady, Esam Makes an Employer object, extends from
 *         user
 */
public class Employer extends User {
   private ArrayList<JobListing> postedJobListings;
   private ArrayList<Student> favoriteStudents;
   private Scanner scanner;
   private JobListings jobListings;

   /**
    * Sets values of an employer
    * 
    * @param id            employer's if
    * @param username      employer's username
    * @param password      employer's password
    * @param accounttype   employer
    * @param school        null
    * @param company       employer's company
    * @param firstname     employer's first name
    * @param lastname      employer's last name
    * @param email         employer's email
    * @param phoneNumber   employer's number
    * @param major         null
    * @param minor         null
    * @param concentration null
    * @param gradeLevel    null
    * @param gpa           null
    * @param skills        null
    * @param extraCurr     null
    * @param status        null
    * @param jobOccupation null
    * @param jobtype       null
    * @param prevExp       null
    * @param explength     null
    * @param jobdesc       null
    */
   public Employer(UUID id, String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc,ArrayList<String> jobsApplied) {
      super(id, username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor,
            concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength,
            jobdesc,jobsApplied);
      this.postedJobListings = new ArrayList<>();
      this.favoriteStudents = new ArrayList<>();
      this.scanner = new Scanner(System.in);
      this.jobListings = JobListings.getInstance();
   }

   /**
    * Sets values of an employer
    * 
    * @param id            employer's if
    * @param username      employer's username
    * @param password      employer's password
    * @param accounttype   employer
    * @param school        null
    * @param company       employer's company
    * @param firstname     employer's first name
    * @param lastname      employer's last name
    * @param email         employer's email
    * @param phoneNumber   employer's number
    * @param major         null
    * @param minor         null
    * @param concentration null
    * @param gradeLevel    null
    * @param gpa           null
    * @param skills        null
    * @param extraCurr     null
    * @param status        null
    * @param jobOccupation null
    * @param jobtype       null
    * @param prevExp       null
    * @param explength     null
    * @param jobdesc       null
    */
   public Employer(String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc,ArrayList<String> jobsApplied) {
      super(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor,
            concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength,
            jobdesc,jobsApplied);
      this.postedJobListings = new ArrayList<>();
      this.favoriteStudents = new ArrayList<>();
      this.scanner = new Scanner(System.in);
      this.jobListings = JobListings.getInstance();
   }

   /**
    * retrives the job lsitings that are posted
    * 
    * @return list of job listings
    */
   public ArrayList<JobListing> getPostedJobListings() {
      return this.postedJobListings;
   }

   /**
    * retrieves list of students that have been accepted
    * 
    * @return list of students
    */
   public ArrayList<Student> getAcceptedStudents() {
      return this.favoriteStudents;
   }

   /**
    * allows employer to post new job listings
    */
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
      ArrayList<String> jobSkills = addJobListingNecessarySkills();

      System.out.println("\nNew Job Listing Created!");

      String jobCompany = getCompany();
      String[] locations = location.split(", ");
      String jobCityLocation = locations[0];
      String jobStateLocation = locations[1];
      ArrayList<Student> studentsApplied = new ArrayList<>();

      this.postedJobListings.add(new JobListing(companyLink, jobTitle, jobCompany, jobDescription, jobCityLocation,
            jobStateLocation, numofMonths, jobWagePerHour, jobSkills, studentsApplied, jobExpDate));

      this.jobListings.addJob(companyLink, jobTitle, jobCompany, jobDescription, jobCityLocation, jobStateLocation,
            numofMonths, jobWagePerHour, jobSkills, studentsApplied, jobExpDate);
   }

   public ArrayList<String> addJobListingNecessarySkills() {
      ArrayList<String> necessarySkills = new ArrayList<>();
      System.out.println(
            "\nEnter all skills for a potential employee to have below\nType an entry and press 'Enter'\nType 'Done' when finished entering skills to finish new Job Listing creation");
      while (true) {
         String newEntry = scanner.nextLine();
         if (newEntry.equalsIgnoreCase("done")) {
            break;
         }
         necessarySkills.add(newEntry);
      }
      return necessarySkills;
   }

   /**
    * allows user to delete a job listing
    */
   public void deleteJobListing(JobListing jobListing) {
      this.postedJobListings.remove(jobListing);
      this.jobListings.removeJob(jobListing.getJobTitle());

      System.out.println("Job listings successfully deleted");
   }

   public void editJobListing(JobListing jobListing) {

   }

   /**
    * allows user to filter through the students applying by different ways
    * 
    * @param possibleStudents the list of possible students
    * @return the list of filtered students
    */
   public ArrayList<Student> filteringStudents(ArrayList<Student> possibleStudents) {
      System.out
            .println("Choose from the following filters\nGPA, Major, Minor, Skill, Extracurricular, or Grade Level");
      String userInput = scanner.nextLine().trim().toUpperCase();

      ResumeFilter filter = ResumeFilter.valueOf(userInput);

      switch (filter) {
      case GPA:
         System.out.println("The students GPA must be greater than what value? (4.0 being the greatest)");
         double gpaMinimum = Double.valueOf(scanner.nextLine());
         return filteredByGPA(possibleStudents, gpaMinimum);
      case MAJOR:
         System.out.println("What major would you like to filter by?");
         String desiredMajor = scanner.nextLine();
         return filteredByMajor(possibleStudents, desiredMajor);
      case MINOR:
         System.out.println("What minor would you like to filter by?");
         String desiredMinor = scanner.nextLine();
         return filteredByMinor(possibleStudents, desiredMinor);
      case SKILL:
         System.out.println("What skill would you like to filter by?");
         String desiredSkill = scanner.nextLine();
         return filteredBySkill(possibleStudents, desiredSkill);
      case EXTRACURRICULAR:
      System.out.println("What extracurricular would you like to filter by?");
         String desiredExc = scanner.nextLine();
         return filteredByExtracurricular(possibleStudents, desiredExc);
      case GRADELEVEL:
      System.out.println("What grade level would you like to filter by?");
         String desiredGradeLevel = scanner.nextLine();
         return filteredByGradeLevel(possibleStudents, desiredGradeLevel);
      default:
         System.out.println("Invalid Command");
         return null;
      }
   }

   /**
    * filtering through students by GPA
    * 
    * @param possibleStudents list of possible of students
    * @return the list of filtered students
    */
   public ArrayList<Student> filteredByGPA(ArrayList<Student> possibleStudents, double gpaMinimum) {
      ArrayList<Student> filteredStudents = new ArrayList<>();
      for (Student student : possibleStudents) {
         double studentGPA = Double.valueOf(student.getGPA());
         if (studentGPA >= gpaMinimum) {
            filteredStudents.add(student);
         }

      }
      return filteredStudents;
   }

   /**
    * Filter possible students by major
    * 
    * @param possibleStudents list of possible students
    * @return the list of filtered students
    */
   public ArrayList<Student> filteredByMajor(ArrayList<Student> possibleStudents, String desiredMajor) {
      ArrayList<Student> filteredStudents = new ArrayList<>();     
      for (Student student : possibleStudents) {
         if (student.getMajor().equals(desiredMajor)) {
            filteredStudents.add(student);
         }

      }
      return filteredStudents;
   }

   /**
    * filter possible students by minor
    * 
    * @param possibleStudents list of possible students
    * @return list of filtered students
    */
   public ArrayList<Student> filteredByMinor(ArrayList<Student> possibleStudents, String desiredMinor) {
      ArrayList<Student> filteredStudents = new ArrayList<>();
      for (Student student : possibleStudents) {
         if (student.getMinor().equals(desiredMinor)) {
            filteredStudents.add(student);
         }

      }
      return filteredStudents;
   }

   /**
    * filter possible students by their skills
    * 
    * @param possibleStudents list of possible students
    * @return the list of filtered students
    */
   public ArrayList<Student> filteredBySkill(ArrayList<Student> possibleStudents, String desiredSkill) {
      ArrayList<Student> filteredStudents = new ArrayList<>();
      for (Student student : possibleStudents) {
         if (student.getSkills().contains(desiredSkill)) {
            filteredStudents.add(student);
         }

      }
      return filteredStudents;
   }

   /**
    * filter possible students by their extracurricular activites
    * 
    * @param possibleStudents list of possible students
    * @return list of filtered students
    */
   public ArrayList<Student> filteredByExtracurricular(ArrayList<Student> possibleStudents, String desiredExc) {
      ArrayList<Student> filteredStudents = new ArrayList<>();
      for (Student student : possibleStudents) {
         if (student.getExtracurr().contains(desiredExc)) {
            filteredStudents.add(student);
         }

      }
      return filteredStudents;
   }

   /**
    * filter possible students by their grade level
    * 
    * @param possibleStudents list of possible students
    * @return list of filtered students
    */
   public ArrayList<Student> filteredByGradeLevel(ArrayList<Student> possibleStudents, String desiredGrade) {
      ArrayList<Student> filteredStudents = new ArrayList<>();
      for (Student student : possibleStudents) {
         if (student.getGradeLevel().equals(desiredGrade)) {
            filteredStudents.add(student);
         }

      }
      return filteredStudents;
   }

   /**
    * allows user(employer) to accept students for the position
    * 
    * @param student    student being accepted
    * @param jobListing job they are being accepted for
    */
   public void acceptStudent(Student student, JobListing jobListing) {
      student.getStatus().concat("Potentially Employed: " + jobListing.getJobCompany());

      System.out.println("The students status has been updated with their potential employment");
   }

   /**
    * allows employer to reject students for a position
    * 
    * @param student   student being rejected
    * @param jobListng job listing they are bing rejected for
    */
   public void rejectStudent(Student student, JobListing jobListng) {
      jobListng.getStudentsApplied().remove(student);
      student.getJobsAppliedTo().remove(jobListng);

      System.out.println("The student has been removed from the list of potential employees");
   }

   /**
    * prints out the employer object
    */
   public String toString() {
      return "Name: " + getFirstName() + " " + getLastName() + "\nCompany: " + getCompany() + "\nJob Listings Created: "
            + getPostedJobListings().size();
   }

}
