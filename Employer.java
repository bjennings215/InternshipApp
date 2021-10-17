import java.util.ArrayList;
//Guardians of the Git


public class Employer {
   String company;
   private ArrayList<JobListing> jobListing;
   private ArrayList<Student> favoriteStudents;
   
   public Employer(String username, String password) {
		
	}
   
   public Employer(String username, String password, String company) {
	   
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
