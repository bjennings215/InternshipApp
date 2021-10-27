import java.util.ArrayList;
import java.util.UUID;

public class Student extends User {
    
    private Resume resume;
    private boolean employementStatus;
    private ArrayList<JobListing> favoriteJobs;
    private ArrayList<JobListing> jobsAppliedTo;
    private ArrayList<Review> reviewsMade;
    private String school;

    // public Student() {
        
    // }

    public Student(UUID id, String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, ArrayList<String> prevExp, ArrayList<String> explength, 
	ArrayList<String> jobdesc) {
        super(id, username,password,accounttype,school,company,firstname,lastname,email,phoneNumber,major,minor,concentration,
        gradeLevel,gpa,skills,extraCurr,status,prevExp,explength,jobdesc);
        this.school = school;
    }

    public Resume getResume() {
        return this.resume;
    }

    public boolean getEmployementStatus() {
        return true;
    }

    public ArrayList<JobListing> getFavoriteJobs() {
        return this.favoriteJobs;
    }

    public ArrayList<JobListing> getJobsAppliedTo() {
        return this.jobsAppliedTo;
    }

    public ArrayList<Review> getReviewsMade() {
        return this.reviewsMade;
    }

    public void createResume(Resume resume) {

    }

    public void editResume() {

    }

    public boolean changeUsername() {
        return true;
    }

    public boolean changePassword() {
        return true;
    }

    public boolean changeEmployementStatus() {
        return true;
    }

    public boolean addJobAppliedTo(JobListing jobListing) {
        if(getJobsAppliedTo().contains(jobListing)) {
            System.out.println("You have already applied to this job!");
            return false;
        }
        return true;
    }

    public boolean removeJobAppliedTo() {
        return true;
    }

    public void giveJobReview(JobListing jobListing) {

    }

    public boolean deleteJobReview(Review review) {
        return true;
    }

    public JobListing searchJobListings(JobListing jobListing) {
        return jobListing;
    }

    public ArrayList<Review> seeJobListingReviews(JobListing jobListing) {
        return jobListing.getJobReviews();
    }

    public void filterJobListings(JobFilter jobFilter) {

    }

    public boolean applyToJob(JobListing jobListing) {
        return true;
    }

    public String getSchool() {
        return school;
    }
}
