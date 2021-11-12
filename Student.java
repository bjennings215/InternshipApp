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

    public Student(UUID id, String username, String password, String accounttype, String school, String company,
            String firstname, String lastname, String email, String phoneNumber, String major, String minor,
            String concentration, String gradeLevel, String gpa, ArrayList<String> skills, ArrayList<String> extraCurr,
            String status, String jobOccupation, String jobtype, String prevExp, String explength, String jobdesc,
            ArrayList<String> jobsApplied) {
        super(id, username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc, jobsApplied);
        this.jobsAppliedTo = new ArrayList<>();
        this.reviewsMade = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.users = Users.getInstance();
        this.jobListings = JobListings.getInstance();
    }

    public Student(String username, String password, String accounttype, String school, String company,
            String firstname, String lastname, String email, String phoneNumber, String major, String minor,
            String concentration, String gradeLevel, String gpa, ArrayList<String> skills, ArrayList<String> extraCurr,
            String status, String jobOccupation, String jobtype, String prevExp, String explength, String jobdesc,
            ArrayList<String> jobsApplied) {
        super(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor,
                concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength,
                jobdesc, jobsApplied);
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
            System.out.println("What job title would you like to filter by?");
            String desiredTitle = scanner.nextLine();
            return filteredByTitle(possibleJobs, desiredTitle);
        case WAGE:
            System.out.println("What is the minimum job wage you would like to filter by?");
            double desiredWage = Double.valueOf(scanner.nextLine());
            return filteredByWage(possibleJobs, desiredWage);
        case COMPANY:
            System.out.println("What company would you like to filter by?");
            String desiredCompany = scanner.nextLine();
            return filteredByCompany(possibleJobs, desiredCompany);
        case CITY:
            System.out.println("What city would you like to filter by?");
            String desiredCity = scanner.nextLine();
            return filteredByCity(possibleJobs, desiredCity);
        case STATE:
            System.out.println("What state would you like to filter by?");
            String desiredState = scanner.nextLine();
            return filteredByState(possibleJobs, desiredState);
        case SKILL:
            System.out.println("What skill would you like to filter by?");
            String desiredSkill = scanner.nextLine();
            return filteredBySkill(possibleJobs, desiredSkill);
        default:
            System.out.println("Invalid Command");
            return null;
        }
    }

    public ArrayList<JobListing> filteredByTitle(ArrayList<JobListing> possibleJobs, String desiredTitle) {
        ArrayList<JobListing> filteredJobs = new ArrayList<>();
        for (JobListing jobListing : possibleJobs) {
            if (jobListing.getJobTitle().equalsIgnoreCase(desiredTitle)) {
                filteredJobs.add(jobListing);
            }

        }
        return filteredJobs;
    }

    public ArrayList<JobListing> filteredByWage(ArrayList<JobListing> possibleJobs, double desiredWage) {
        ArrayList<JobListing> filteredJobs = new ArrayList<>();
        for (JobListing jobListing : possibleJobs) {
            double wageValue = Double.valueOf(jobListing.getWagePerHour());
            if (wageValue > desiredWage) {
                filteredJobs.add(jobListing);
            }
        }
        return filteredJobs;
    }

    public ArrayList<JobListing> filteredByCompany(ArrayList<JobListing> possibleJobs, String desiredCompany) {
        ArrayList<JobListing> filteredJobs = new ArrayList<>();
        for (JobListing jobListing : possibleJobs) {
            if (jobListing.getJobCompany().equalsIgnoreCase(desiredCompany)) {
                filteredJobs.add(jobListing);
            }

        }
        return filteredJobs;
    }

    public ArrayList<JobListing> filteredByCity(ArrayList<JobListing> possibleJobs, String desiredCity) {
        ArrayList<JobListing> filteredJobs = new ArrayList<>();
        for (JobListing jobListing : possibleJobs) {
            if (jobListing.getJobCityLocation().equalsIgnoreCase(desiredCity)) {
                filteredJobs.add(jobListing);
            }

        }
        return filteredJobs;
    }

    public ArrayList<JobListing> filteredByState(ArrayList<JobListing> possibleJobs, String desiredState) {
        ArrayList<JobListing> filteredJobs = new ArrayList<>();
        for (JobListing jobListing : possibleJobs) {
            if (jobListing.getJobStateLocation().equalsIgnoreCase(desiredState)) {
                filteredJobs.add(jobListing);
            }

        }
        return filteredJobs;
    }

    public ArrayList<JobListing> filteredBySkill(ArrayList<JobListing> possibleJobs, String desiredSkill) {
        ArrayList<JobListing> filteredJobs = new ArrayList<>();
        for (JobListing jobListing : possibleJobs) {
            if (jobListing.getJobSkills().contains(desiredSkill)) {
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
                + "\nJob Description: " + getJobDesc() + "\nSkills:\n" + getSkills() + "\nExtracurriculars:\n"
                + getExtracurr();

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
