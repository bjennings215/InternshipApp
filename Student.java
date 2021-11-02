import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Student extends User {

    private ArrayList<JobListing> jobsAppliedTo;
    private ArrayList<Review> reviewsMade;
    private Scanner scanner;
    private Users users;
    private JobListings jobListings;

    public Student(UUID id, String username, String password, String accounttype, String school, String company,
            String firstname, String lastname, String email, String phoneNumber, String major, String minor,
            String concentration, String gradeLevel, String gpa, ArrayList<String> skills, ArrayList<String> extraCurr,
            String status, String jobOccupation, String jobtype, String prevExp, String explength, String jobdesc) {
        super(id, username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc);
        this.jobsAppliedTo = new ArrayList<>();
        this.reviewsMade = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.users = Users.getInstance();
        this.jobListings = JobListings.getInstance();
    }

    public Student(String username, String password, String accounttype, String school, String company,
            String firstname, String lastname, String email, String phoneNumber, String major, String minor,
            String concentration, String gradeLevel, String gpa, ArrayList<String> skills, ArrayList<String> extraCurr,
            String status, String jobOccupation, String jobtype, String prevExp, String explength, String jobdesc) {
        super(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major, minor,
                concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp, explength,
                jobdesc);
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

    public void newEducationEntry(String username, String password, String accounttype, String school, String company,
            String firstname, String lastname, String email, String phoneNumber, String major, String minor,
            String concentration, String gradeLevel, String gpa, ArrayList<String> skills, ArrayList<String> extraCurr,
            String status, String jobOccupation, String jobtype, String prevExp, String explength, String jobdesc) {
        System.out.println("\nFill out the information below to add a new education experience\n"
                + "(Enter 'Null' if field does not apply)\n");
        System.out.print("University Name: ");
        school = scanner.nextLine();
        System.out.print("Grade Point Average: ");
        gpa = scanner.nextLine();
        System.out.print("Major: ");
        major = scanner.nextLine();
        System.out.print("Minor: ");
        minor = scanner.nextLine();
        System.out.print("Concentration: ");
        concentration = scanner.nextLine();
        System.out.print("Grade Level: ");
        gradeLevel = scanner.nextLine();

        users.editUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc);
    }

    public void newJobExperienceEntry(String username, String password, String accounttype, String school,
            String company, String firstname, String lastname, String email, String phoneNumber, String major,
            String minor, String concentration, String gradeLevel, String gpa, ArrayList<String> skills,
            ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp,
            String explength, String jobdesc) {
        System.out.println("\nFill out the information below to add a new work experience\n"
                + "(Enter 'Null' if field does not apply)\n");
        System.out.print("Job: ");
        jobOccupation = scanner.nextLine();
        System.out.print("Type (Part-Time, Full-Time, Internship): ");
        jobtype = scanner.nextLine();
        System.out.print("Employer: ");
        prevExp = scanner.nextLine();
        System.out.print("Length of Employment (MM/YYYY - MM/YYYY): ");
        explength = scanner.nextLine();
        System.out.print("Please enter description: ");
        jobdesc = scanner.nextLine();

        users.editUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc);
    }

    public void newSkillsEntry(String username, String password, String accounttype, String school, String company,
            String firstname, String lastname, String email, String phoneNumber, String major, String minor,
            String concentration, String gradeLevel, String gpa, ArrayList<String> skills, ArrayList<String> extraCurr,
            String status, String jobOccupation, String jobtype, String prevExp, String explength, String jobdesc) {
        System.out.println(
                "\nEnter all skills below\nType an entry and press 'Enter'\nType 'Done' when finished entering skills to exit");
        while (true) {
            String newEntry = scanner.nextLine();
            if (newEntry.equalsIgnoreCase("done")) {
                break;
            }
            skills.add(newEntry);
        }
        System.out.println("All new skills added!");

        users.editUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc);
    }

    public void newExtraCurricularEntry(String username, String password, String accounttype, String school,
            String company, String firstname, String lastname, String email, String phoneNumber, String major,
            String minor, String concentration, String gradeLevel, String gpa, ArrayList<String> skills,
            ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp,
            String explength, String jobdesc) {
        System.out.println(
                "\nEnter all extracurriculars below\nType an entry and press 'Enter'\nType 'Done' when finished entering extracurriculars to exit");
        while (true) {
            String newEntry = scanner.nextLine();
            if (newEntry.equalsIgnoreCase("done")) {
                break;
            }
            extraCurr.add(newEntry);
        }
        System.out.println("All new extracurriculars added!");

        users.editUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc);
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

    public ArrayList<Review> seeJobListingReviews(JobListing jobListing) {
        return jobListing.getJobReviews();
    }

    public void filterJobListings(JobFilter jobFilter) {

    }

    public String shortToString() {
        return "Name: " + getFirstName() + " " + getLastName() + "\nGrade Level: " + getGradeLevel() + "\nStatus: "
                + getStatus() + "\nMajor: " + getMajor() + "\nGPA: " + getGPA();
    }

    public String longToString() {
        String returnString = "Name: " + getFirstName() + " " + getLastName() + "\nStatus: " + getStatus()
                + "\n\nEducation Information: \nUniversity: " + getSchool() + "\nGrade Level: " + getGradeLevel()
                + "\nGPA: " + getGPA() + "\nMajor: " + getMajor() + "\nMinor: " + getMinor() + "\nConcentration: "
                + getConcentation() + "\n\nPrevious Work Experiences: \n Cannot Print this yet \n\nSkills";
        for (String skill : getSkills()) {
            returnString.concat(skill + "\n");
        }
        returnString.concat("\n\nExtracurriculars");
        for (String extracurricular : getExtracurr()) {
            returnString.concat(extracurricular + "\n");
        }

        return returnString;
    }
}
