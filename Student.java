import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Student extends User {

    private ArrayList<JobListing> jobsAppliedTo;
    private ArrayList<Review> reviewsMade;
    private Scanner scanner;
    private Users users;
    private JobListings jobListings;
    private User user;

    public Student(UUID id, String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc,ArrayList<String> jobsApplied) {
        super(id, username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc,jobsApplied);
        this.jobsAppliedTo = new ArrayList<>();
        this.reviewsMade = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.users = Users.getInstance();
        this.jobListings = JobListings.getInstance();
    }

    public Student(String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc,ArrayList<String> jobsApplied) {
        super(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor,
                concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength,
                jobdesc,jobsApplied);
        this.jobsAppliedTo = new ArrayList<>();
        this.reviewsMade = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.users = Users.getInstance();
        this.jobListings = JobListings.getInstance();
    }

    public ArrayList<JobListing> getJobsAppliedTo() {
        return this.jobsAppliedTo;
    }

    public ArrayList<Review> getReviewsMade() {
        return this.reviewsMade;
    }

    public void seeResumeDetails() {
        System.out.println(longToString());
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

    public ArrayList<String> seeJobListingReviews(JobListing jobListing) {
        return jobListing.getJobSkills();
    }

    public ArrayList<JobListing> filteringJobListings(ArrayList<JobListing> possibleJobs) {
        System.out.println("Choose from the following filters\n Title, Wage, Company, City, or State");
        String userInput = scanner.nextLine().trim().toUpperCase();

        JobFilter filter = JobFilter.valueOf(userInput);

        switch (filter) {
        case TITLE:
            return filteredByTitle(possibleJobs);
        case WAGE:
            return filteredByWage(possibleJobs);
        case COMPANY:
            return filteredByCompany(possibleJobs);
        case CITY:
            return filteredByCity(possibleJobs);
        case STATE:
            return filteredByState(possibleJobs);
        case SKILL:
            return filteredBySkill(possibleJobs);
        default:
            System.out.println("Invalid Command");
            return null;
        }
    }

    private ArrayList<JobListing> filteredByTitle(ArrayList<JobListing> possibleJobs) {
        System.out.println("What job title would you like to filter by?");
        ArrayList<JobListing> filteredJobs = new ArrayList<>();
        String userInput = scanner.nextLine();
        for (JobListing jobListing : possibleJobs) {
            if (jobListing.getJobTitle().equalsIgnoreCase(userInput)) {
                filteredJobs.add(jobListing);
            }

        }
        return filteredJobs;
    }

    private ArrayList<JobListing> filteredByWage(ArrayList<JobListing> possibleJobs) {
        System.out.println("What would you like to be the minimum wage requirement?");
        ArrayList<JobListing> filteredJobs = new ArrayList<>();
        double userInput = Double.valueOf(scanner.nextLine());
        for (JobListing jobListing : possibleJobs) {
            double wageValue = Double.valueOf(jobListing.getWagePerHour());
            if (wageValue > userInput) {
                filteredJobs.add(jobListing);
            }
        }
        return filteredJobs;
    }

    private ArrayList<JobListing> filteredByCompany(ArrayList<JobListing> possibleJobs) {
        System.out.println("What company would you like to filter by?");
        ArrayList<JobListing> filteredJobs = new ArrayList<>();
        String userInput = scanner.nextLine();
        for (JobListing jobListing : possibleJobs) {
            if (jobListing.getJobCompany().equalsIgnoreCase(userInput)) {
                filteredJobs.add(jobListing);
            }

        }
        return filteredJobs;
    }

    private ArrayList<JobListing> filteredByCity(ArrayList<JobListing> possibleJobs) {
        System.out.println("What city would you like to filter by?");
        ArrayList<JobListing> filteredJobs = new ArrayList<>();
        String userInput = scanner.nextLine();
        for (JobListing jobListing : possibleJobs) {
            if (jobListing.getJobCityLocation().equalsIgnoreCase(userInput)) {
                filteredJobs.add(jobListing);
            }

        }
        return filteredJobs;
    }

    private ArrayList<JobListing> filteredByState(ArrayList<JobListing> possibleJobs) {
        System.out.println("What job title would you like to filter by?");
        ArrayList<JobListing> filteredJobs = new ArrayList<>();
        String userInput = scanner.nextLine();
        for (JobListing jobListing : possibleJobs) {
            if (jobListing.getJobStateLocation().equalsIgnoreCase(userInput)) {
                filteredJobs.add(jobListing);
            }

        }
        return filteredJobs;
    }

    private ArrayList<JobListing> filteredBySkill(ArrayList<JobListing> possibleJobs) {
        System.out.println("What skill would you like to filter by?");
        ArrayList<JobListing> filteredJobs = new ArrayList<>();
        String userInput = scanner.nextLine();
        for (JobListing jobListing : possibleJobs) {
            if (jobListing.getJobSkills().contains(userInput)) {
                filteredJobs.add(jobListing);
            }

        }
        return filteredJobs;
    }

    public String shortToString() {
        return "Name: " + getFirstName() + " " + getLastName() + "\nGrade Level: " + getGradeLevel() + "\nStatus: "
                + getStatus() + "\nMajor: " + getMajor() + "\nGPA: " + getGPA();
    }

    public String longToString() {
        String returnString = "Name: " + getFirstName() + " " + getLastName() + "\nStatus: " + getStatus()
                + "\n\nEducation Information: \nUniversity: " + getSchool() + "\nGrade Level: " + getGradeLevel()
                + "\nGPA: " + getGPA() + "\nMajor: " + getMajor() + "\nMinor: " + getMinor() + "\nConcentration: "
                + getConcentation() + "\n\nPrevious Work Experiences: \nJob: " + getjobOccupation() + "\nCompany: "
                + getCompany() + "\nJob Type :" + getjobType() + "\nJob Length: " + getExpLength()
                + "\nJob Description: " + getJobDesc() + "\nSkills:\n" + getSkills() + "\nExtracurriculars:\n" + getExtracurr();

        return returnString;
    }
    public void printResume() {
        try {
            FileWriter myWriter = new FileWriter("resume.txt");
            myWriter.write(user.UserResumetoFile());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
