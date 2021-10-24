import java.util.ArrayList;
//Guardians of the Git
import java.util.UUID;


public class Employer extends User {
   String company;
   private ArrayList<JobListing> jobListing;
   private ArrayList<Student> favoriteStudents;
   

   // public Employer(UUID id,String username, String password, String accounttype) {
	// 	super(id, username, password, accounttype);
	// }
   
   public Employer(UUID id, String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, ArrayList<String> prevExp, ArrayList<String> explength, 
	ArrayList<String> jobdesc) {
	   super(id, username,password,accounttype,school,company,firstname,lastname,major,minor,concentration,
      gradeLevel,gpa,skills,extraCurr,status,prevExp,explength,jobdesc);
      this.company = company;
   }
   
   public String getCompany() {
	   return "";
   }
   
   public ArrayList<JobListing> getJobListing() {
	   return jobListing;
   }
   
   public ArrayList<Student> getFavoriteStudent() {
	   return null;
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
