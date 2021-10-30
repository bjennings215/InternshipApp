
import java.util.ArrayList;
import java.util.UUID;


public class JobListing {

    private UUID jobid;
    private String link;
    private String jobTitle;
    private String jobCompany;
    private String jobDescription;
    private String jobCityLocation;
    private String jobStateLocation;
    private String numofMonths;
    private String jobWagePerHour;
    //private  jobNumberRating;
    private ArrayList<Review> jobReviews;
    private ArrayList<Student> studentsApplied;
    private String jobExpDate;

    public JobListing(String link, String jobTitle, String jobCompany, String jobDescription, String jobCityLocation, 
    String jobStateLocation, String numofMonths, String jobWagePerHour,ArrayList<Review> jobReviews, ArrayList<Student> studentsApplied, String jobExpDate) {
        this.jobid = UUID.randomUUID();
        this.link = link;
        this.jobTitle = jobTitle;
        this.jobCompany = jobCompany;
        this.jobCityLocation = jobCityLocation;
        this.jobStateLocation = jobStateLocation;
        this.numofMonths = numofMonths;
        this.jobWagePerHour = jobWagePerHour;
        this.jobReviews = jobReviews;
        this.studentsApplied = studentsApplied;
        this.jobExpDate = jobExpDate;
    }

    public JobListing(UUID jobid,String link, String jobTitle, String jobCompany, String jobDescription, String jobCityLocation, 
    String jobStateLocation, String numofMonths, String jobWagePerHour,ArrayList<Review> jobReviews, ArrayList<Student> studentsApplied, String jobExpDate){
        this.jobid = jobid;
        this.link = link;
        this.jobTitle = jobTitle;
        this.jobCompany = jobCompany;
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

    // public double getJobNumberRating() {
    //     return this.jobNumberRating;
    // }

    public ArrayList<Review> getJobReviews() {
        return jobReviews;
    }

    public ArrayList<Student> getStudentsApplied() {
        return studentsApplied;
    }

    public String getJobExpDate() {
        return jobExpDate;
    }

    public String shortToString() {
        return this.jobTitle + "\n" + this.jobCompany + "\n" + this.jobDescription;
    }

    public String getLink() {
        return this.link;
    }

    public String longToSTring() {
        String returnString = this.jobTitle + "\n" + this.jobCompany + "\n"
                + this.jobCityLocation + ", " + this.jobStateLocation + "\n" + this.jobDescription + "\nReviews made of previous experiences in this role\n";
        for (Review review : this.jobReviews) {
            returnString.concat(review.toString()+"\n");
        }
        return returnString;
    }
}
