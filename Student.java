import java.util.ArrayList;
import java.util.UUID;

public class Student extends User {
    
    private Resume resume;
    private boolean employementStatus;
    private ArrayList<JobListing> favoriteJobs;
    private ArrayList<JobListing> jobsAppliedTo;
    private ArrayList<Review> reviewsMade;

    public Student(UUID id, String username, String password) {
        super(id, username, password);
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

    public boolean addFavorite() {
        return true;
    }

    public boolean removeFavorite() {
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

}
