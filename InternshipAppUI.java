
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
    private static final String[] BROWSE_JOBS_APPLIED_COMMANDS = { "Unapply to Job Listing", "See Job Listing Reviews",
            "Return" };
    private static final String[] EMPLOYER_DETAILED_JOB_LISTING_COMMANDS = { "See All Applicants", "Delete Job Listing"};
    private Scanner scanner;
    private User user;
    private JobListing jobListing;
    private Student student;
    private Employer employer;
    private Administrator admin;

    InternshipAppUI() {
        this.scanner = new Scanner(System.in);
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

    // -----------------------------------LOG IN
    // FUNCTIONALITY------------------------------------

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
        Users allUsers = Users.getInstance();

        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (verifyLoginCredentials(username, password)) {
                System.out.println("\nWelcome User!");
                this.user = allUsers.getUser(username);
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
                System.out.println("\nWelcome new Student!");
                System.out.println("Enter new username and password below");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                // Creates and adds new student
                /**
                 * String accounttype = "Student"; String school = null; String firstname =
                 * null; String lastname = null; String major = null; String minor = null;
                 * String concentration = null; String gradeLevel = null; String company = null;
                 * String gpa = null; ArrayList<String> skills = null; ArrayList<String>
                 * extraCurr = null; ArrayList<String> prevExp = null; ArrayList<String>
                 * explength = null; ArrayList<String> jobdesc = null; String status = null;
                 * users.addUser(username,password,accounttype,school,company,firstname,lastname,major,minor,concentration,
                 * gradeLevel,gpa,skills,extraCurr,status,prevExp,explength,jobdesc);
                 * ArrayList<User> accountInfo = users.getUsers(); for(User user : accountInfo){
                 * if(user.getUsername().equals(username)){ System.out.println(username);
                 * System.out.println(accounttype); System.out.println(school); } }
                 */
                break;
                // createStudentResume(username, password);
                // break;
            } else if (userDecision == 2) {
                System.out.println("\nWelcome new Employer!");
                System.out.println("Enter new username and password below");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                // Creates and adds new employer
                break;
            } else if (userDecision == 3) {
                System.out.println("\nWelcome new Administrator!");
                System.out.println("Enter new username and password below");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                // Creates and adds new administrator
                break;
            }
            System.out.println("Invalid Command");
        }
    }

    // -------------------RESUME CREATION AND EDITING DISPLAY AND
    // FUNCTIONALITY-----------------------------

    public void createStudentResume(String username, String password) {
        System.out.println("\nYou will now be prompted to set up your Resume\n");
        System.out.print("First Name: ");
        String userFirstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String userLastName = scanner.nextLine();
        while (true) {
            System.out.println("\nChoose one of the options below to add information to your Resume");
            printPossibleCommands(RESUME_CREATION_COMMANDS);
            int userDecision = getUserCommand(RESUME_CREATION_COMMANDS);
            if (userDecision == 1) {
                newEducationEntry();
            } else if (userDecision == 2) {
                newJobExperienceEntry();
            } else if (userDecision == 3) {
                newSkillsEntry();
            } else if (userDecision == 4) {
                newExtraCurricularEntry();
            } else if (userDecision == 5) {
                // this.student.createResume(new Resume());
                System.out.println("Congratulations! Resume creation finished!");
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    public void newEducationEntry() {
        System.out.println("\nFill out the information below to add a new education experience\n"
                + "(Enter 'Null' if field does not apply)\n");
        System.out.print("University Name: ");
        String uniName = scanner.nextLine();
        System.out.print("Grade Point Average: ");
        double GPA = Double.parseDouble(scanner.nextLine());
        System.out.print("Major: ");
        String major = scanner.nextLine();
        System.out.print("Minor: ");
        String minor = scanner.nextLine();
        System.out.print("Concentration: ");
        String concentration = scanner.nextLine();
        System.out.print("Grade Level: ");
        String gradeLevel = scanner.nextLine();
        System.out.print("Graduation (MM/YYYY): ");
        String graduation = scanner.nextLine();
        // Create new Resume with information
        // Will condense
    }

    public void newJobExperienceEntry() {
        System.out.println("\nFill out the information below to add a new work experience\n"
                + "(Enter 'Null' if field does not apply)\n");
        System.out.print("Company: ");
        String company = scanner.nextLine();
        System.out.print("City, State: ");
        String location = scanner.nextLine();
        System.out.print("Start Date: ");
        String startDate = scanner.nextLine();
        System.out.print("End Date: ");
        String endDate = scanner.nextLine();
        // Create Job Experience with information
        // Will condense
    }

    public void newSkillsEntry() {
        System.out
                .println("\nEnter any skills below\nSeperate all entries with a comma and press 'Enter' when finished");
        String[] skills = scanner.nextLine().split(",");
        // Adds all to persons Resume
    }

    public void newExtraCurricularEntry() {
        System.out.println(
                "\nEnter any extracurriculars below\nSeperate all entries with a comma and press 'Enter' when finished");
        String[] extracurriculars = scanner.nextLine().split(",");
        // Adds all to persons Resume
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

        // for(int i = 0; i <= jobListings.length; i++) {
        // System.out.println("[1]: "this.jobListing[i].shortToString);
        // }
        // System.out.println("Enter the number of a certain job listing to see more
        // details");
        // int userInput = Integer.valueOf(scanner.nextLine());
        // seeDetailedJobListing(this.jobListing[i-1]);
    }

    public void studentDetailedJobListing(JobListing jobListing) {
        this.jobListing.longToSTring();
        printPossibleCommands(STUDENT_DETAILED_JOB_LISTING_COMMANDS);
        int userInput = getUserCommand(STUDENT_DETAILED_JOB_LISTING_COMMANDS);
        while (true) {
            if (userInput == 1) {
                this.student.applyToJob(jobListing);
                this.student.addJobAppliedTo(jobListing);
            } else if (userInput == 2) {
                return;
            } else {
                System.out.println("Invalid Command");
            }
        }
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
        System.out.print("Job Title: ");
        String jobTitle = scanner.nextLine();
        System.out.print("Job Description: ");
        String jobDescription = scanner.nextLine();
        System.out.print("Location (City, State): ");
        String location = scanner.nextLine();
        System.out.print("Wage Per Hour: ");
        double wagePerHour = Double.valueOf(scanner.nextLine());
        System.out.print("Number of Months: ");
        int numOfMonths = Integer.valueOf(scanner.nextLine());
        System.out.print("Employer Website Link: ");
        String employerLink = scanner.nextLine();
        System.out.print("Date Posted: ");
        String datePosted = scanner.nextLine();
        this.employer.getJobListings().add(new JobListing());
        System.out.println("\nNew Job Listing Created!");
        // Add job listing to the array of job listings and to the employer's job
        // listings
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
                employerDetailedJobListing(this.employer.getJobListings().get(userInput-1));
            } else if (userInput == 0) {
                return;
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    public void employerDetailedJobListing(JobListing jobListing) {
        jobListing.longToSTring();
        printPossibleCommands(EMPLOYER_DETAILED_JOB_LISTING_COMMANDS);
        getUserCommand(EMPLOYER_DETAILED_JOB_LISTING_COMMANDS);
        int userInput = Integer.valueOf(scanner.nextLine());
        while(true) {
            if(userInput == 1) {
                
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
