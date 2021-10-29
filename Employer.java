import java.util.ArrayList;
//Guardians of the Git
import java.util.UUID;


public class Employer extends User {
   String company;
   private ArrayList<JobListing> jobListings;
   private ArrayList<Student> favoriteStudents;
   

   // public Employer(UUID id,String username, String password, String accounttype) {
	// 	super(id, username, password, accounttype);
	// }
   
   public Employer(UUID id, String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	ArrayList<String> jobdesc) {
	   super(id, username,password,accounttype,school,company,firstname,lastname,email,phoneNumber,major,minor,concentration,
      gradeLevel,gpa,skills,extraCurr,status,jobOccupation,jobtype,prevExp,explength,jobdesc);
      this.company = company;
   }
   
   public String getCompany() {
	   return this.company;
   }
   
   public ArrayList<JobListing> getJobListings() {
	   return this.jobListings;
   }
   
   public ArrayList<Student> getFavoriteStudents() {
	   return this.favoriteStudents;
   }
   
   public boolean createJobListing() {
	   return false;
   }
   
   public boolean deleteJobListing() {
	   return false;
   }
   
   public void filterStudent(ResumeFilter filter) {
	   
   }
   
   private Student searchStudent(Student student) {
	   return student;
   }
   
   public boolean acceptStudent(Student student) {
	   return true;
   }
   
   public boolean rejectStudent(Student student) {
	   return false;
   }
   
}
