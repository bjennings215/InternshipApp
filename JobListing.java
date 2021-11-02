
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

/**
 * Creates a joblisting object
 * @author Adam, Brandon, Brady, Esam
 */
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

    /**
     * retrives parameters
     * @param jobTitle job title of listing
     * @param jobCompany company of the listing
     * @param jobDescription description of listing
     * @param jobCityLocation city of listing
     * @param jobStateLocation state of listing
     * @param numofMonths how long is the position
     * @param companyLink link for listing
     * @param jobWagePerHour wage for listing
     * @param jobReviews reviews for job
     * @param studentsApplied list of students that have applied
     * @param jobExpDate when the listing expires
     */
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

    /**
     * sets parameters
     * @param jobTitle job title of listing
     * @param jobCompany company of the listing
     * @param jobDescription description of listing
     * @param jobCityLocation city of listing
     * @param jobStateLocation state of listing
     * @param numofMonths how long is the position
     * @param companyLink link for listing
     * @param jobWagePerHour wage for listing
     * @param jobReviews reviews for job
     * @param studentsApplied list of students that have applied
     * @param jobExpDate when the listing expires
     */
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

    /**
     * retrieves listin ID
     * @return ID
     */
    public UUID getJobID() {
        return jobid;
    }

    /**
     * gets the date when listing was posting
     * @return the date
     */
    public LocalDate getpostDate() {
        return post_Date;
    }

    /**
     * retrieves job title
     * @return job title
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * retrieves company
     * @return company
     */
    public String getJobCompany() {
        return jobCompany;
    }

    /**
     * retrieves job description
     * @return job description
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * retrieves city of job
     * @return city
     */
    public String getJobCityLocation() {
        return jobCityLocation;
    }

    /**
     * retrieves state of job
     * @return state
     */
    public String getJobStateLocation() {
        return jobStateLocation;
    }

    /**
     * retrieves length of job
     * @return length
     */
    public String getNumOfMonths() {
        return numofMonths;
    }

    /**
     * wage of job
     * @return wage
     */
    public String getWagePerHour() {
        return jobWagePerHour;
    }

    /**
     * retrieves exp date of job
     * @return exp date
     */
    public String getJobExpDate() {
        return jobExpDate;
    }

    /**
     * retireves link of job
     * @return link
     */
    public String getLink() {
        return this.compnayLink;
    }

    // public double getJobNumberRating() {
    // return this.jobNumberRating;
    // }

    /**
     * retireves list of reviews for job
     * @return list of reviews
     */
    public ArrayList<Review> getJobReviews() {
        return jobReviews;
    }

    /**
     * retrieves list of students that applies
     * @return list of students
     */
    public ArrayList<Student> getStudentsApplied() {
        return studentsApplied;
    }

    /**
     * short to String
     * @return String
     */
    public String shortToString() {
        return this.jobTitle + "\nCompany: " + this.jobCompany + "\nDescription: " + this.jobDescription;
    }

    /**
     * long to string
     * @return String
     */
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
