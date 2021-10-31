
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

public class InternshipAppUI {

    private static final String[] LOGIN_COMMANDS = { "Log in", "Create new account" };
    private static final String[] USER_TYPE_COMMANDS = { "Student", "Employer", "Administrator" };
    private static final String[] STUDENT_MAIN_MENU_COMMANDS = { "Browse Job Listings", "See Jobs Applied To",
            "See Reviews Made", "Edit Resume", "Edit Account", "Log Off" };
    private static final String[] EMPLOYER_MAIN_MENU_COMMANDS = { "Post New Job Listing", "See Posted Job Listings",
            "Search Students", "Log Off" };
    private static final String[] ADMIN_MAIN_MENU_COMMANDS = { "Browse All Job Listings", "Browse All Students",
            "Search Job Listings", "Search Students", "Log Off" };
    private static final String[] RESUME_CREATION_COMMANDS = { "Education", "Previous Work Experience", "Skills",
            "Extracurriculars", "Finish Resume Creation" };
    private static final String[] RESUME_EDITING_COMMANDS = { "Add new Education Entry", "Add new Job Entry",
            "Add new Skills", "Add new Extracurriculars", "Remove Current Education Entry", "Remove Current Job Entry",
            "Remove Current Skills", "Remove Current Extracurriculars", "Return" };
    private static final String[] ACCOUNT_EDITING_COMMANDS = { "Change Username", "Change Password", "Return" };

    private static final String[] STUDENT_DETAILED_JOB_LISTING_COMMANDS = { "Apply to Job", "Return" };

    private static final String[] EMPLOYER_DETAILED_JOB_LISTING_COMMANDS = { "See All Applicants",
            "Delete Job Listing" };

    private Scanner scanner;
    private User user;
    private JobListing jobListing;
    private Student student;
    private Employer employer;
    private Administrator admin;
    private Users users;
    private JobListings jobListings;

    InternshipAppUI() {
        this.scanner = new Scanner(System.in);
        users = Users.getInstance();
        jobListings = JobListings.getInstance();
    }

    public void run() {
        initialLogInMenu();

        if (this.user.getAccounttype().equals("Student")) {
            studentMainMenuFunctionality();
        } else if (this.user.getAccounttype().equals("Employer")) {
            employerMainMenuFunctionality();
        } else if (this.user.getAccounttype().equals("Admin")) {
            adminMainMenuFunctionality();
        } else {
            System.out.println("There has been an error with your account.\nUnable to run the Internship App.");
            System.exit(0);
        }
    }

    // -------------------------LOG IN FUNCTIONALITY--------------------------------

    public void initialLogInMenu() {
        System.out.println("Welcome to the Internship Application!");

        while (true) {
            printPossibleCommands(LOGIN_COMMANDS);
            int userDecision = getUserCommand(LOGIN_COMMANDS);
            if (userDecision == 1) {
                loggingIn();
                return;
            } else if (userDecision == 2) {
                newAccountCreation();
                return;
            }
            System.out.println("Invalid Command");
        }
    }

    public void loggingIn() {

        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (verifyLoginCredentials(username, password)) {
                System.out.println("\nWelcome User!");
                this.user = users.getUser(username);
                return;
            }
            System.out.println("\nEither username or password is incorrect");
            attempts++;
        }
        System.out.println("You have used too many attempts. Please try again later.\nGoodbye");
        System.exit(0);
    }

    public boolean verifyLoginCredentials(String username, String password) {
        Users allUsers = Users.getInstance();

        if (allUsers.haveUser(username) && allUsers.getUser(username).getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public void newAccountCreation() {
        Users users = Users.getInstance();
        System.out.println("\nWhat type of account do you wish to create?");
        while (true) {
            printPossibleCommands(USER_TYPE_COMMANDS);
            int userDecision = getUserCommand(USER_TYPE_COMMANDS);
            if (userDecision == 1) {
                newStudentAccountCreation();
                break;
            } else if (userDecision == 2) {
                newEmployerAccountCreation();
                break;
            } else if (userDecision == 3) {
                newAdminAccountCreation();
                break;
            }
            System.out.println("Invalid Command");
        }
    }

    public void newStudentAccountCreation() {
        System.out.println("\nWelcome new Student!");
        System.out.println("Enter new username and password below");

        String username = verifyAndSetUsername();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        String accounttype = "Student";
        String school = null;
        String firstname = null;
        String lastname = null;
        String major = null;
        String minor = null;
        String concentration = null;
        String gradeLevel = null;
        String company = null;
        String gpa = null;
        ArrayList<String> skills = new ArrayList<>();
        ArrayList<String> extraCurr = new ArrayList<>();
        String prevExp = null;
        String explength = null;
        String jobdesc = null;
        String status = null;
        String email = null;
        String phoneNumber = null;
        String jobOccupation = null;
        String jobtype = null;

        this.user = new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                prevExp, explength, jobdesc);
        users.addUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc);
        ArrayList<User> accountInfo = users.getUsers();
        for (User user : accountInfo) {
            if (user.getUsername().equals(username)) {
                System.out.println(username);
                System.out.println(accounttype);
                System.out.println(school);
            }
        }

        createStudentResume(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                prevExp, explength, jobdesc);
    }

    public void newEmployerAccountCreation() {
        System.out.println("\nWelcome new Employer!");
        System.out.println("Enter new username and password below");

        String username = verifyAndSetUsername();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        String accounttype = "Employer";
        String school = null;
        String firstname = null;
        String lastname = null;
        String major = null;
        String minor = null;
        String concentration = null;
        String gradeLevel = null;
        String company = null;
        String gpa = null;
        ArrayList<String> skills = new ArrayList<>();
        ArrayList<String> extraCurr = new ArrayList<>();
        String prevExp = null;
        String explength = null;
        String jobdesc = null;
        String status = null;
        String email = null;
        String phoneNumber = null;
        String jobOccupation = null;
        String jobtype = null;

        this.user = new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                prevExp, explength, jobdesc);

        users.addUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc);
        ArrayList<User> accountInfo = users.getUsers();
        for (User user : accountInfo) {
            if (user.getUsername().equals(username)) {
                System.out.println(username);
                System.out.println(accounttype);
                System.out.println(school);
            }
        }
    }

    public void newAdminAccountCreation() {
        System.out.println("\nWelcome new Administrator!");
        System.out.println("Enter new username and password below");

        String username = verifyAndSetUsername();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        String accounttype = "Admin";
        String school = null;
        String firstname = null;
        String lastname = null;
        String major = null;
        String minor = null;
        String concentration = null;
        String gradeLevel = null;
        String company = null;
        String gpa = null;
        ArrayList<String> skills = new ArrayList<>();
        ArrayList<String> extraCurr = new ArrayList<>();
        String prevExp = null;
        String explength = null;
        String jobdesc = null;
        String status = null;
        String email = null;
        String phoneNumber = null;
        String jobOccupation = null;
        String jobtype = null;

        this.user = new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                prevExp, explength, jobdesc);

        users.addUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc);
        ArrayList<User> accountInfo = users.getUsers();
        for (User user : accountInfo) {
            if (user.getUsername().equals(username)) {
                System.out.println(username);
                System.out.println(accounttype);
                System.out.println(school);
            }
        }
    }

    public String verifyAndSetUsername() {
        while (true) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            if (!users.haveUser(username)) {
                return username;
            }
            System.out.println("\nUsername is already taken. Please enter another");
        }
    }

    // --------------RESUME CREATION AND EDITING DISPLAY AND
    // FUNCTIONALITY----------------------

    public void createStudentResume(String username, String password, String accounttype, String firstname,
            String lastname, String school, String company, String email, String phoneNumber, String major,
            String minor, String concentration, String gradeLevel, String gpa, ArrayList<String> skills,
            ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp,
            String explength, String jobdesc) {
        System.out.println("\nYou will now be prompted to set up your Resume\n");
        System.out.print("First Name: ");
        firstname = scanner.nextLine();
        System.out.print("Last Name: ");
        lastname = scanner.nextLine();
        users.editUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc);
        while (true) {
            System.out.println("\nChoose one of the options below to add information to your Resume");
            printPossibleCommands(RESUME_CREATION_COMMANDS);
            int userDecision = getUserCommand(RESUME_CREATION_COMMANDS);
            if (userDecision == 1) {
                newEducationEntry(username, password, accounttype, school, company, firstname, lastname, email,
                        phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status,
                        jobOccupation, jobtype, prevExp, explength, jobdesc);
            } else if (userDecision == 2) {
                newJobExperienceEntry(username, password, accounttype, school, company, firstname, lastname, email,
                        phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status,
                        jobOccupation, jobtype, prevExp, explength, jobdesc);
            } else if (userDecision == 3) {
                newSkillsEntry(username, password, accounttype, school, company, firstname, lastname, email,
                        phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status,
                        jobOccupation, jobtype, prevExp, explength, jobdesc);
            } else if (userDecision == 4) {
                newExtraCurricularEntry(username, password, accounttype, school, company, firstname, lastname, email,
                        phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status,
                        jobOccupation, jobtype, prevExp, explength, jobdesc);
            } else if (userDecision == 5) {
                // this.student.createResume(new Resume());
                System.out.println("Congratulations! Resume creation finished!");
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    public void newEducationEntry(String username, String password, String accounttype, String firstname,
            String lastname, String school, String company, String email, String phoneNumber, String major,
            String minor, String concentration, String gradeLevel, String gpa, ArrayList<String> skills,
            ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp,
            String explength, String jobdesc) {
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

    public void newJobExperienceEntry(String username, String password, String accounttype, String firstname,
            String lastname, String school, String company, String email, String phoneNumber, String major,
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

    public void newSkillsEntry(String username, String password, String accounttype, String firstname, String lastname,
            String school, String company, String email, String phoneNumber, String major, String minor,
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

    public void newExtraCurricularEntry(String username, String password, String accounttype, String firstname,
            String lastname, String school, String company, String email, String phoneNumber, String major,
            String minor, String concentration, String gradeLevel, String gpa, ArrayList<String> skills,
            ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp,
            String explength, String jobdesc) {
        System.out.println(
                "\nEnter all extracurriculars below\nType an entry and press 'Enter'\nType 'Done' when finished entering skills to exit");
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

    public void editResumeEducation() {

    }

    public void editResumeJobExperience() {

    }

    public void editResumeSkills() {

    }

    public void editResumeExtracurriculars() {

    }

    // -----------------------------STUDENT MAIN MENU DISPLAY AND
    // FUNCTIONALITY-----------------------------------

    public void studentMainMenuFunctionality() {
        while (true) {
            System.out.println("\nMain Menu");
            printPossibleCommands(STUDENT_MAIN_MENU_COMMANDS);
            int userDecision = getUserCommand(STUDENT_MAIN_MENU_COMMANDS);
            if (userDecision == 1) {
                browseJobListings();
            } else if (userDecision == 2) {
                browseJobsApplied();
            } else if (userDecision == 3) {
                seeReviewsMade();
            } else if (userDecision == 4) {
                studentResumeEditingMenu();
            } else if (userDecision == 5) {
                studentAccountEditingMenu();
            } else if (userDecision == 6) {
                System.out.println("Thanks for using the internship app!\nGoodbye!");
                System.exit(0);
            } else {
                System.out.println("\nInvalid command");
            }
        }

    }

    public void browseJobListings() {
        int count = 1;
        for (JobListing jobListing : jobListings.getJobList()) {
            System.out.println("\n[" + count + "]: " + jobListing.shortToString());
            count++;
        }
        while (true) {
            System.out.println(
                    "\nEnter the number of a job listing to see more details.\nIf finished viewing listings enter '0' to return");
            int userInput = Integer.valueOf(scanner.nextLine());
            if (userInput == 0) {
                return;
            } else if (userInput > 0 && userInput <= jobListings.getJobList().size()) {
                studentDetailedJobListing(jobListings.getJobList().get(userInput - 1));
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    public void studentDetailedJobListing(JobListing jobListing) {
        System.out.println(jobListing.longToString());
        printPossibleCommands(STUDENT_DETAILED_JOB_LISTING_COMMANDS);
        int userInput = getUserCommand(STUDENT_DETAILED_JOB_LISTING_COMMANDS);
        while (true) {
            if (userInput == 1) {
                // this.user.applyToJob(jobListing);
                // this.user.addJobAppliedTo(jobListing);
            } else if (userInput == 2) {
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }
        return;
    }

    public void browseJobsApplied() {
        int count = 0;
        System.out.println("\nAll Jobs Applied To");
        for (JobListing jobListing : this.student.getJobsAppliedTo()) {
            System.out.println("\n [" + count + "]: " + jobListing);
            count++;
        }
        System.out.println(
                "Enter the number of a Job Listing to see more information and/or apply\nEnter '0' if you wish to return");
        int userInput = Integer.valueOf(scanner.nextLine());
        while (true) {
            if (userInput > 0 && userInput <= this.student.getJobsAppliedTo().size()) {
                studentDetailedJobListing(this.student.getJobsAppliedTo().get(userInput - 1));
            } else if (userInput == 0) {
                return;
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    public void seeReviewsMade() {
        int count = 0;
        System.out.println("\nAll Reviews Made");
        for (Review review : this.student.getReviewsMade()) {
            System.out.println("\n [" + count + "]: " + jobListing);
            count++;
        }
        System.out.println("Enter the number of a review to delete it.\nEnter '0' if you wish to return");
        int userInput = Integer.valueOf(scanner.nextLine());
        while (true) {
            if (userInput > 0 && userInput <= this.student.getReviewsMade().size()) {
                this.student.deleteJobReview(this.student.getReviewsMade().get(userInput));
            } else if (userInput == 0) {
                return;
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    public void studentResumeEditingMenu() {
        System.out.println("\nResume Editing Menu");
        printPossibleCommands(RESUME_EDITING_COMMANDS);
        int userDecision = getUserCommand(RESUME_EDITING_COMMANDS);
        if (userDecision == 1) {

        }
    }

    public void studentAccountEditingMenu() {
        System.out.println("\nAccount Editing Menu");
        printPossibleCommands(ACCOUNT_EDITING_COMMANDS);
        int userDecision = getUserCommand(ACCOUNT_EDITING_COMMANDS);
        if (userDecision == 1) {

        }
    }

    public ArrayList<JobListing> printAllJobListings() {
        // For loop that runs through each Job Listing and prints them all to the
        // console
        return new ArrayList<JobListing>();
    }

    // -----------------------------EMPLOYER MAIN MENU DISPLAY AND
    // FUNCTIONALITY---------------------------------------

    public void employerMainMenuFunctionality() {
        while (true) {
            System.out.println("\nMain Menu");
            printPossibleCommands(EMPLOYER_MAIN_MENU_COMMANDS);
            int userDecision = getUserCommand(EMPLOYER_MAIN_MENU_COMMANDS);
            if (userDecision == 1) {
                postNewJobListing();
            } else if (userDecision == 2) {
                postNewJobListing();
            } else if (userDecision == 3) {
                seeAllPostedJobListings();
            } else if (userDecision == 4) {
                System.out.println("Thanks for using the internship app!\nGoodbye!");
                System.exit(0);
            } else {
                System.out.println("\nInvalid Command");
            }
        }
    }

    public void postNewJobListing() {
        JobListings jobListings = JobListings.getInstance();
        System.out.print("Job Title: ");
        String jobTitle = scanner.nextLine();
        System.out.print("Job Description: ");
        String jobDescription = scanner.nextLine();
        System.out.print("Location (City, State): ");
        String location = scanner.nextLine();
        System.out.print("Wage Per Hour: $");
        String jobWagePerHour = scanner.nextLine();
        System.out.print("Number of Months: ");
        String numofMonths = scanner.nextLine();
        System.out.print("Employer Website Link: ");
        String employerLink = scanner.nextLine();
        System.out.print("Date Posted: ");
        String jobExpDate = scanner.nextLine();
        // this.employer.getJobListings().add(new JobListing());
        System.out.println("\nNew Job Listing Created!");
        // Add job listing to the array of job listings and to the employer's job
        // listings
        String link = "";
        String jobCompany = "";
        String jobCityLocation = "";
        String jobStateLocation = "";
        ArrayList<Review> jobReviews = null;
        ArrayList<Student> studentsApplied = null;

        jobListings.addJob(link, jobTitle, jobCompany, jobDescription, jobCityLocation, jobStateLocation, numofMonths,
                jobWagePerHour, jobReviews, studentsApplied, jobExpDate);
    }

    public void seeAllPostedJobListings() {
        int count = 0;
        for (JobListing jobListing : this.employer.getJobListings()) {
            System.out.println("\n[" + count + "]: " + jobListing.shortToString());
            count++;
        }
        System.out.println("Enter the number of a job listing to see more details.\nEnter '0' if you wish to return");
        int userInput = Integer.valueOf(scanner.nextLine());
        while (true) {
            if (userInput > 0 && userInput <= this.employer.getJobListings().size()) {
                employerDetailedJobListing(this.employer.getJobListings().get(userInput - 1));
            } else if (userInput == 0) {
                return;
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    public void employerDetailedJobListing(JobListing jobListing) {
        jobListing.longToString();
        printPossibleCommands(EMPLOYER_DETAILED_JOB_LISTING_COMMANDS);
        getUserCommand(EMPLOYER_DETAILED_JOB_LISTING_COMMANDS);
        int userInput = Integer.valueOf(scanner.nextLine());
        while (true) {
            if (userInput == 1) {

            }
        }
    }

    // -----------------------------ADMINISTRATOR MAIN MENU DISPLAY AND
    // FUNCTIONALITY---------------------------------------

    public void adminMainMenuFunctionality() {
        while (true) {
            System.out.println("\nMain Menu");
            printPossibleCommands(ADMIN_MAIN_MENU_COMMANDS);
            int userDecision = getUserCommand(ADMIN_MAIN_MENU_COMMANDS);
            if (userDecision == 1) {
                System.out.println("Option 1");
            } else if (userDecision == 2) {

            } else if (userDecision == 3) {

            } else if (userDecision == 4) {

            } else if (userDecision == 5) {
                System.out.println("Thanks for using the internship app!\nGoodbye!");
                System.exit(0);
            } else {
                System.out.println("\nInvalid Command");
            }
        }
    }

    public void searchStudent() {

    }

    public void searchForJobs() {

    }

    public void searchEmployer() {

    }

    public void rateReviewJob() {

    }

    public void addJob() {

    }

    public void addStudent() {

    }

    public void deleteStudent() {

    }

    public void deleteEmployer() {

    }

    public void deleteJobListing() {

    }

    // --------------------------GENERAL
    // FUNCTIONALITY------------------------------------

    public void printPossibleCommands(String[] availableCommands) {
        for (int i = 0; i < availableCommands.length; i++) {
            System.out.println((i + 1) + ". " + availableCommands[i]);
        }
    }

    public int getUserCommand(String[] possibleCommands) {

        int numOfPossibleCommands = possibleCommands.length;

        System.out.println("Type the number of the option you wish to choose below");

        int userChoice = Integer.parseInt(scanner.nextLine());

        if (userChoice > 0 && userChoice <= numOfPossibleCommands)
            return userChoice;
        return -1;
    }

    /**
     * public String[] getUserInformation(String[] prompts) { String[]
     * informationGathered = new String[prompts.length]; for(int i = 0; i <
     * prompts.length; i++) { System.out.println(prompts[i]); String userInfo =
     * scanner.nextLine(); informationGathered[i] = userInfo; } return
     * informationGathered; }
     */
    public static void main(String[] args) {

        InternshipAppUI internshipAppInterface = new InternshipAppUI();
        internshipAppInterface.run();
    }
}
