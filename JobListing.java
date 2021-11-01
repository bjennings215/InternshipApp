
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

public class JobListing {

    private UUID jobid;
    private String compnayLink;
    private String jobTitle;
    private String jobCompany;
    private String jobDescription;
    private String jobCityLocation;
    private String jobStateLocation;
    private String numofMonths;
    private String jobWagePerHour;
    // private jobNumberRating;
    private ArrayList<Review> jobReviews;
    private ArrayList<Student> studentsApplied;
    private LocalDate post_Date;
    private String jobExpDate;

    public JobListing(String jobTitle, String jobCompany, String jobDescription,
            String jobCityLocation, String jobStateLocation, String numofMonths, String companyLink, String jobWagePerHour,
            ArrayList<Review> jobReviews, ArrayList<Student> studentsApplied, String jobExpDate) {
        this.jobid = UUID.randomUUID();
        this.post_Date = LocalDate.now();
        this.compnayLink = companyLink;
        this.jobTitle = jobTitle;
        this.jobCompany = jobCompany;
        this.jobDescription = jobDescription;
        this.jobCityLocation = jobCityLocation;
        this.jobStateLocation = jobStateLocation;
        this.numofMonths = numofMonths;
        this.jobWagePerHour = jobWagePerHour;
        this.jobReviews = jobReviews;
        this.studentsApplied = studentsApplied;
        this.jobExpDate = jobExpDate;
    }

    public JobListing(UUID jobid, LocalDate post_Date, String companyLink, String jobTitle, String jobCompany,
            String jobDescription, String jobCityLocation, String jobStateLocation, String numofMonths,
            String jobWagePerHour, ArrayList<Review> jobReviews, ArrayList<Student> studentsApplied,
            String jobExpDate) {
        this.jobid = jobid;
        this.post_Date = post_Date;
        this.compnayLink = companyLink;
        this.jobTitle = jobTitle;
        this.jobCompany = jobCompany;
        this.jobDescription = jobDescription;
        this.jobCityLocation = jobCityLocation;
        this.jobStateLocation = jobStateLocation;
        this.numofMonths = numofMonths;
        this.jobWagePerHour = jobWagePerHour;
        this.jobReviews = jobReviews;
        this.studentsApplied = studentsApplied;
        this.jobExpDate = jobExpDate;
    }

    public UUID getJobID() {
        return jobid;
    }

    public LocalDate getpostDate() {
        return post_Date;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobCompany() {
        return jobCompany;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getJobCityLocation() {
        return jobCityLocation;
    }

    public String getJobStateLocation() {
        return jobStateLocation;
    }

    public String getNumOfMonths() {
        return numofMonths;
    }

    public String getWagePerHour() {
        return jobWagePerHour;
    }

    public String getJobExpDate() {
        return jobExpDate;
    }

    public String getLink() {
        return this.compnayLink;
    }

    // public double getJobNumberRating() {
    // return this.jobNumberRating;
    // }

    public ArrayList<Review> getJobReviews() {
        return jobReviews;
    }

    public ArrayList<Student> getStudentsApplied() {
        return studentsApplied;
    }

    public String shortToString() {
        return this.jobTitle + "\nCompany: " + this.jobCompany + "\nDescription: " + this.jobDescription;
    }

    public String longToString() {
        String returnString = this.jobTitle + "\nCompany: " + this.jobCompany + "\nLocation: " + this.jobCityLocation
                + ", " + this.jobStateLocation + "\nLength: " + this.numofMonths + "\nEarnings Per Hour: "
                + this.jobWagePerHour + "\nCompany Link: " + this.compnayLink + "\nDescription: " + this.jobDescription
                + "\nReviews made of previous experiences in this role\n" + this.jobReviews;
        for (Review review : this.jobReviews) {
            returnString.concat(review.toString() + "\n");
        }
        return returnString;
    }
}
