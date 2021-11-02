import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Employer extends User {
   private ArrayList<JobListing> postedJobListings;
   private ArrayList<Student> favoriteStudents;
   private Scanner scanner;
   private JobListings jobListings;

   public Employer(UUID id, String username, String password, String accounttype, String school, String company,
         String firstname, String lastname, String email, String phoneNumber, String major, String minor,
         String concentration, String gradeLevel, String gpa, ArrayList<String> skills, ArrayList<String> extraCurr,
         String status, String jobOccupation, String jobtype, String prevExp, String explength, String jobdesc) {
      super(id, username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor,
            concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength,
            jobdesc);
      this.postedJobListings = new ArrayList<>();
      this.favoriteStudents = new ArrayList<>();
      this.scanner = new Scanner(System.in);
      this.jobListings = JobListings.getInstance();
   }

   public Employer(String username, String password, String accounttype, String school, String company,
         String firstname, String lastname, String email, String phoneNumber, String major, String minor,
         String concentration, String gradeLevel, String gpa, ArrayList<String> skills, ArrayList<String> extraCurr,
         String status, String jobOccupation, String jobtype, String prevExp, String explength, String jobdesc) {
      super(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor,
            concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength,
            jobdesc);
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

      this.postedJobListings.add(new JobListing(jobTitle, jobCompany, jobDescription, jobCityLocation, jobStateLocation,
            numofMonths, companyLink, jobWagePerHour, jobReviews, studentsApplied, jobExpDate));

      this.jobListings.addJob(jobTitle, jobCompany, jobDescription, jobCityLocation, jobStateLocation, numofMonths,
            companyLink, jobWagePerHour, jobReviews, studentsApplied, jobExpDate);
   }

   public void deleteJobListing(JobListing jobListing) {
      this.postedJobListings.remove(jobListing);
      this.jobListings.removeJob(jobListing.getJobTitle());

      System.out.println("Job listings successfully deleted");
   }

   public void editJobListing(JobListing jobListing) {

   }

   public ArrayList<Student> filteringStudents(ArrayList<Student> possibleStudents) {
      System.out
            .println("Choose from the following filters\nGPA, Major, Minor, Skill, Extracurricular, or Grade Level");
      String userInput = scanner.nextLine().trim().toUpperCase();

      ResumeFilter filter = ResumeFilter.valueOf(userInput);

      switch (filter) {
      case GPA:
         return filteredByGPA(possibleStudents);
      case MAJOR:
         return filteredByMajor(possibleStudents);
      case MINOR:
         return filteredByMinor(possibleStudents);
      case SKILL:
         return filteredBySkill(possibleStudents);
      case EXTRACURRICULAR:
         return filteredByExtracurricular(possibleStudents);
      case GRADE_LEVEL:
         return filteredByGradeLevel(possibleStudents);
      default:
         System.out.println("Invalid Command");
         return null;
      }
   }

   public ArrayList<Student> filteredByGPA(ArrayList<Student> possibleStudents) {
      System.out.println("The students GPA must be greater than what value? (4.0 being the greatest)");
      ArrayList<Student> filteredStudents = new ArrayList<>();
      double userInput = Double.valueOf(scanner.nextLine());
      for (Student student : possibleStudents) {
         double studentGPA = Double.valueOf(student.getGPA());
         if (studentGPA >= userInput) {
            filteredStudents.add(student);   
         }

      }
      return filteredStudents;
   }

   public ArrayList<Student> filteredByMajor(ArrayList<Student> possibleStudents) {
      System.out.println("What major would you like to filter by?");
      ArrayList<Student> filteredStudents = new ArrayList<>();
      String userInput = scanner.nextLine();
      for (Student student : possibleStudents) {
         if (student.getMajor().equals(userInput)) {
            filteredStudents.add(student);   
         }

      }
      return filteredStudents;
   }

   public ArrayList<Student> filteredByMinor(ArrayList<Student> possibleStudents) {
      System.out.println("What minor would you like to filter by?");
      ArrayList<Student> filteredStudents = new ArrayList<>();
      String userInput = scanner.nextLine();
      for (Student student : possibleStudents) {
         if (student.getMinor().equals(userInput)) {
            filteredStudents.add(student);   
         }

      }
      return filteredStudents;
   }

   public ArrayList<Student> filteredBySkill(ArrayList<Student> possibleStudents) {
      System.out.println("What skill would you like to filter by?");
      ArrayList<Student> filteredStudents = new ArrayList<>();
      String userInput = scanner.nextLine();
      for (Student student : possibleStudents) {
         if (student.getSkills().contains(userInput)) {
            filteredStudents.add(student);   
         }

      }
      return filteredStudents;
   }

   public ArrayList<Student> filteredByExtracurricular(ArrayList<Student> possibleStudents) {
      System.out.println("What extracurricular would you like to filter by?");
      ArrayList<Student> filteredStudents = new ArrayList<>();
      String userInput = scanner.nextLine();
      for (Student student : possibleStudents) {
         if (student.getExtracurr().contains(userInput)) {
            filteredStudents.add(student);   
         }

      }
      return filteredStudents;
   }

   public ArrayList<Student> filteredByGradeLevel(ArrayList<Student> possibleStudents) {
      System.out.println("What skill would you like to filter by?");
      ArrayList<Student> filteredStudents = new ArrayList<>();
      String userInput = scanner.nextLine();
      for (Student student : possibleStudents) {
         if (student.getGradeLevel().equals(userInput)) {
            filteredStudents.add(student);   
         }

      }
      return filteredStudents;
   }

   public void acceptStudent(Student student, JobListing jobListing) {
      student.getStatus().concat("Potentially Employed: " + jobListing.getJobCompany());

      System.out.println("The students status has been updated with their potential employment");
   }

   public void rejectStudent(Student student, JobListing jobListng) {
      jobListng.getStudentsApplied().remove(student);
      student.getJobsAppliedTo().remove(jobListng);

      System.out.println("The student has been removed from the list of potential employees");
   }

}
