import java.util.ArrayList;
//Guardians of the Git
import java.util.UUID;


public class Employer extends User {
   String company;
   private ArrayList<JobListing> jobListing;
   private ArrayList<Student> favoriteStudents;
   

   public Employer(UUID id,String username, String password) {
		super(id, username, password);
	}
   
   public Employer(UUID id, String username, String password, String company) {
	   super(id, username, password);
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
