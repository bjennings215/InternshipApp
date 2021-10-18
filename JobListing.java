import java.sql.Date;
import java.util.ArrayList;

public class JobListing {
    
    private String jobTitle;
    private String jobCompany;
    private String jobDescription;
    private String jobCityLocation;
    private String jobStateLocation;
    private int numofMonths;
    private double jobWagePerHour;
    private double jobNumberRating;
    private ArrayList<Review> jobReviews;
    private Date jobExpDate;

    public JobListing() {

    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public String getJobCompany() {
        return this.jobCompany;
    }

    public String getJobDescription() {
        return this.jobDescription;
    }

    public String getJobCityLocation() {
        return this.jobCityLocation;
    }

    public String getJobStateLocation() {
        return this.jobStateLocation;
    }

    public int getNumOfMonths() {
        return this.numofMonths;
    }

    public double getWagePerHour() {
        return this.jobWagePerHour;
    }

    public double getJobNumberRating() {
        return this.jobNumberRating;
    }

    public ArrayList<Review> getJobReviews() {
        return this.jobReviews;
    }    

    public Date getJobExpDate() {
        return this.jobExpDate;
    }
}
