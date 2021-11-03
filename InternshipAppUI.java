
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

public class InternshipAppUI {

    private static final String[] LOGIN_COMMANDS = { "Log in", "Create new account" };
    private static final String[] USER_TYPE_COMMANDS = { "Student", "Employer", "Administrator" };
    private static final String[] STUDENT_MAIN_MENU_COMMANDS = { "Browse Job Listings", "See Jobs Applied To",
            "See Reviews Made", "See Resume Details", "Edit Resume", "Print Resume", "Log Off" };
    private static final String[] EMPLOYER_MAIN_MENU_COMMANDS = { "Post New Job Listing", "See Posted Job Listings",
            "Log Off" };
    private static final String[] ADMIN_MAIN_MENU_COMMANDS = { "Browse All Job Listings", "Browse All Students",
            "Browse All Employers", "Log Off" };
    private static final String[] RESUME_CREATION_COMMANDS = { "Education", "Previous Work Experience", "Skills",
            "Extracurriculars", "Finish Resume Creation" };
    private static final String[] STUDENT_DETAILED_JOB_LISTING_COMMANDS = { "Apply to Job", "Return" };
    private static final String[] EMPLOYER_DETAILED_JOB_LISTING_COMMANDS = { "See All Applicants", "Edit Job Listing",
            "Delete Job Listing", "Return" };
    private static final String[] ADMIN_DETAILED_JOB_LISTING_COMMANDS = { "Delete Job Listing", "Return" };
    private static final String[] EMPLOYER_VIEWING_STUDENT_DETAILS_COMMANDS = { "Accept Student for Position",
            "Reject Student for Position", "Return" };

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
            this.student = new Student(this.user.getUsername(), this.user.getPassword(), this.user.getAccounttype(),
                    this.user.getSchool(), this.user.getCompany(), this.user.getFirstName(), this.user.getLastName(),
                    this.user.getEmail(), this.user.getPhoneNumber(), this.user.getMajor(), this.user.getMinor(),
                    this.user.getConcentation(), this.user.getGradeLevel(), this.user.getGPA(), this.user.getSkills(),
                    this.user.getExtracurr(), this.user.getStatus(), this.user.getjobOccupation(),
                    this.user.getjobType(), this.user.getPrevExp(), this.user.getExpLength(), this.user.getJobDesc(),
                    this.user.getJobsApplied());
            studentMainMenuFunctionality();
        } else if (this.user.getAccounttype().equals("Employer")) {
            this.employer = new Employer(this.user.getUsername(), this.user.getPassword(), this.user.getAccounttype(),
                    this.user.getSchool(), this.user.getCompany(), this.user.getFirstName(), this.user.getLastName(),
                    this.user.getEmail(), this.user.getPhoneNumber(), this.user.getMajor(), this.user.getMinor(),
                    this.user.getConcentation(), this.user.getGradeLevel(), this.user.getGPA(), this.user.getSkills(),
                    this.user.getExtracurr(), this.user.getStatus(), this.user.getjobOccupation(),
                    this.user.getjobType(), this.user.getPrevExp(), this.user.getExpLength(), this.user.getJobDesc(),
                    this.user.getJobsApplied());
            employerMainMenuFunctionality();
        } else if (this.user.getAccounttype().equals("Admin")) {
            this.admin = new Administrator(this.user.getUsername(), this.user.getPassword(), this.user.getAccounttype(),
                    this.user.getSchool(), this.user.getCompany(), this.user.getFirstName(), this.user.getLastName(),
                    this.user.getEmail(), this.user.getPhoneNumber(), this.user.getMajor(), this.user.getMinor(),
                    this.user.getConcentation(), this.user.getGradeLevel(), this.user.getGPA(), this.user.getSkills(),
                    this.user.getExtracurr(), this.user.getStatus(), this.user.getjobOccupation(),
                    this.user.getjobType(), this.user.getPrevExp(), this.user.getExpLength(), this.user.getJobDesc(),
                    this.user.getJobsApplied());
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

        if (users.haveUser(username) && users.getUser(username).getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public void newAccountCreation() {
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

        String accounttype = "Student";
        String status = "Looking for Work";

        System.out.println("\nYou will be prompted to set up your account information below\n");

        System.out.println("Enter new username and password below");

        String username = verifyAndSetUsername();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.println("\nEnter basic information and contact information below\n");
        System.out.print("First Name: ");
        String firstname = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastname = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        while (true) {
            System.out.println("\nWould you like to set up your resume now? Enter 'Yes' or 'No'");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("Yes")) {
                System.out.println("\nFill out the information below to add a new education experience\n"
                        + "(Enter 'None' if field does not apply)\n");
                System.out.print("University Name: ");
                String school = scanner.nextLine();
                System.out.print("Grade Point Average: ");
                String gpa = scanner.nextLine();
                System.out.print("Major: ");
                String major = scanner.nextLine();
                System.out.print("Minor: ");
                String minor = scanner.nextLine();
                System.out.print("Concentration: ");
                String concentration = scanner.nextLine();
                System.out.print("Grade Level: ");
                String gradeLevel = scanner.nextLine();

                String jobOccupation;
                String company;
                String jobtype;
                String prevExp;
                String explength;
                String jobdesc;
                while (true) {
                    System.out.println("\nWould you like to enter a previous job experience? Enter 'Yes' or 'No'\n");
                    String jobInput = scanner.nextLine().trim();
                    if (jobInput.equalsIgnoreCase("Yes")) {
                        System.out.println("\nFill out the information below to add a new work experience\n"
                                + "(Enter 'None' if field does not apply)\n");
                        System.out.print("Job: ");
                        jobOccupation = scanner.nextLine();
                        System.out.print("Company: ");
                        company = scanner.nextLine();
                        System.out.print("Type (Part-Time, Full-Time, Internship): ");
                        jobtype = scanner.nextLine();
                        System.out.print("Length of Employment (MM/YYYY - MM/YYYY): ");
                        explength = scanner.nextLine();
                        System.out.print("Please enter description: ");
                        jobdesc = scanner.nextLine();
                        prevExp = "None";
                        break;
                    } else if (jobInput.equalsIgnoreCase("No")) {
                        jobOccupation = "None";
                        company = "None";
                        jobtype = "None";
                        prevExp = "None";
                        explength = "None";
                        jobdesc = "None";
                        break;
                    } else {
                        System.out.println("\nInvalid Command\n");
                    }
                }

                ArrayList<String> skills = new ArrayList<>();
                while (true) {
                    System.out.println("\nWould you like to enter personal skills? Enter 'Yes' or 'No'\n\n");
                    String skillsInput = scanner.nextLine().trim();
                    if (skillsInput.equalsIgnoreCase("Yes")) {
                        System.out.println(
                                "\nEnter all skills below\nType an entry and press 'Enter'\nType 'Done' when finished entering skills to move on");
                        while (true) {
                            String newEntry = scanner.nextLine();
                            if (newEntry.equalsIgnoreCase("done")) {
                                break;
                            }
                            skills.add(newEntry);
                        }
                        System.out.println("All new skills added!");
                        break;
                    } else if (skillsInput.equalsIgnoreCase("No")) {
                        break;
                    } else {
                        System.out.println("Invalid Command");
                    }

                }

                ArrayList<String> extraCurr = new ArrayList<>();
                while (true) {
                    System.out.println("\nWould you like to enter extracurricular activities? Enter 'Yes' or 'No'\n");
                    String extracurrInput = scanner.nextLine().trim();
                    if (extracurrInput.equalsIgnoreCase("Yes")) {
                        System.out.println(
                                "\nEnter all extracurriculars below\nType an entry and press 'Enter'\nType 'Done' when finished entering extracurriculars to move on");
                        while (true) {
                            String newEntry = scanner.nextLine();
                            if (newEntry.equalsIgnoreCase("done")) {
                                break;
                            }
                            extraCurr.add(newEntry);
                        }
                        System.out.println("\nAll new extracurriculars added!");
                        break;
                    } else if (extracurrInput.equalsIgnoreCase("No")) {
                        break;
                    } else {
                        System.out.println("\nInvalid Command");
                    }
                }

                ArrayList<String> jobsApplied = new ArrayList<>();

                this.student = new Student(username, password, accounttype, school, company, firstname, lastname, email,
                        phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status,
                        jobOccupation, jobtype, prevExp, explength, jobdesc, jobsApplied);

                this.user = new User(username, password, accounttype, school, company, firstname, lastname, email,
                        phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status,
                        jobOccupation, jobtype, prevExp, explength, jobdesc, jobsApplied);

                users.addUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                        major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                        prevExp, explength, jobdesc, jobsApplied);

            } else if (userInput.equalsIgnoreCase("No")) {
                String school = "None";
                String major = "None";
                String minor = "None";
                String concentration = "None";
                String gradeLevel = "None";
                String gpa = "None";
                ArrayList<String> skills = new ArrayList<>();
                ArrayList<String> extraCurr = new ArrayList<>();
                String company = "None";
                String prevExp = "None";
                String explength = "None";
                String jobdesc = "None";
                String jobOccupation = "None";
                String jobtype = "None";
                ArrayList<String> jobsApplied = new ArrayList<>();

                this.student = new Student(username, password, accounttype, school, company, firstname, lastname, email,
                        phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status,
                        jobOccupation, jobtype, prevExp, explength, jobdesc, jobsApplied);

                this.user = new User(username, password, accounttype, school, company, firstname, lastname, email,
                        phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status,
                        jobOccupation, jobtype, prevExp, explength, jobdesc, jobsApplied);

                users.addUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                        major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                        prevExp, explength, jobdesc, jobsApplied);
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    public void newEmployerAccountCreation() {
        System.out.println("\nWelcome new Employer!");
        System.out.println("Enter new username and password below");

        String username = verifyAndSetUsername();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("First Name: ");
        String firstname = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastname = scanner.nextLine();
        System.out.print("Company: ");
        String company = scanner.nextLine();

        String accounttype = "Employer";
        String school = "None";
        String major = "None";
        String minor = "None";
        String concentration = "None";
        String gradeLevel = "None";
        String gpa = "None";
        ArrayList<String> skills = new ArrayList<>();
        ArrayList<String> extraCurr = new ArrayList<>();
        String prevExp = "None";
        String explength = "None";
        String jobdesc = "None";
        String status = "None";
        String email = "None";
        String phoneNumber = "None";
        String jobOccupation = "None";
        String jobtype = "None";
        ArrayList<String> jobsApplied = new ArrayList<>();

        this.employer = new Employer(username, password, accounttype, school, company, firstname, lastname, email,
                phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation,
                jobtype, prevExp, explength, jobdesc, jobsApplied);

        this.user = new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                prevExp, explength, jobdesc, jobsApplied);

        users.addUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc, jobsApplied);
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
        String school = "None";
        String firstname = "None";
        String lastname = "None";
        String major = "None";
        String minor = "None";
        String concentration = "None";
        String gradeLevel = "None";
        String company = "None";
        String gpa = "None";
        ArrayList<String> skills = new ArrayList<>();
        ArrayList<String> extraCurr = new ArrayList<>();
        String prevExp = "None";
        String explength = "None";
        String jobdesc = "None";
        String status = "None";
        String email = "None";
        String phoneNumber = "None";
        String jobOccupation = "None";
        String jobtype = "None";
        ArrayList<String> jobsApplied = new ArrayList<>();

        this.admin = new Administrator(username, password, accounttype, school, company, firstname, lastname, email,
                phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation,
                jobtype, prevExp, explength, jobdesc, jobsApplied);

        this.user = new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                prevExp, explength, jobdesc, jobsApplied);

        users.addUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc, jobsApplied);
        ArrayList<User> accountInfo = users.getUsers();
        for (User user : accountInfo) {
            if (user.getUsername().equals(username)) {
                System.out.println(username);
                System.out.println(accounttype);
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

    // -----------STUDENT MAIN MENU DISPLAY AND FUNCTIONALITY------------------

    public void studentMainMenuFunctionality() {
        while (true) {
            System.out.println("\n\nMain Menu");
            printPossibleCommands(STUDENT_MAIN_MENU_COMMANDS);
            int userDecision = getUserCommand(STUDENT_MAIN_MENU_COMMANDS);
            if (userDecision == 1) {
                studentBrowseJobListings();
            } else if (userDecision == 2) {
                browseJobsApplied();
            } else if (userDecision == 3) {
                seeReviewsMade();
            } else if (userDecision == 4) {
                this.student.seeResumeDetails();
            } else if (userDecision == 5) {
                studentResumeEditingMenu();
            } else if (userDecision == 6) {
                printResume();
            } else if (userDecision == 7) {
                System.out.println("Thanks for using the internship app!\nGoodbye!");
                System.exit(0);
            } else {
                System.out.println("\nInvalid command");
            }
        }

    }

    public void studentBrowseJobListings() {
        while (true) {
            printAllJobListings();
            System.out.println(
                    "\nEnter the number of a job listing to see more details.\nTo filter job lisings enter '-1'\nIf finished viewing listings enter '0' to return");
            int userInput = Integer.valueOf(scanner.nextLine());
            if (userInput == 0) {
                return;
            } else if (userInput > 0 && userInput <= jobListings.getJobList().size()) {
                studentDetailedJobListing(jobListings.getJobList().get(userInput - 1));
            } else if (userInput == -1) {
                ArrayList<JobListing> filteredListings = this.student.filteringJobListings(jobListings.getJobList());
                printFilteredJobListings(filteredListings);
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    public void printFilteredJobListings(ArrayList<JobListing> filteredJobListings) {
        while (true) {
            int count = 1;
            System.out.println("\nJob listings have been filtered!\n");
            for (JobListing jobListing : filteredJobListings) {
                System.out.println("\n[" + count + "]: " + jobListing.shortToString());
                count++;
            }
            System.out.println(
                    "\nEnter the number of a filtered job listing to see more details.\nIf finished viewing listings enter '0' to return");
            int userInput = Integer.valueOf(scanner.nextLine());
            if (userInput == 0) {
                return;
            } else if (userInput > 0 && userInput <= filteredJobListings.size()) {
                studentDetailedJobListing(jobListings.getJobList().get(userInput - 1));
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    public void studentDetailedJobListing(JobListing jobListing) {
        System.out.println(jobListing.longToString());
        while (true) {
            printPossibleCommands(STUDENT_DETAILED_JOB_LISTING_COMMANDS);
            int userInput = getUserCommand(STUDENT_DETAILED_JOB_LISTING_COMMANDS);
            if (userInput == 1) {
                applyToJobListing(jobListing);
                return;
            } else if (userInput == 2) {
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }
        return;
    }

    public void applyToJobListing(JobListing jobListing) {
        if (jobListing.getStudentsApplied().contains(this.student)) {
            System.out.println("You have already applied to this position");
        } else {
            jobListing.getStudentsApplied().add(student);
            student.getJobsAppliedTo().add(jobListing);
            System.out.println(
                    "You have successfully applied to this position!\nThis job listing will now appear in your list of Jobs Applied To!");
        }
    }

    public void browseJobsApplied() {
        System.out.println("\nAll Jobs Applied To\n");
        for (JobListing jobListing : this.student.getJobsAppliedTo()) {
            System.out.println(
                    "\n [" + (jobListings.getJobList().indexOf(jobListing) + 1) + "]: " + jobListing.shortToString());
        }
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

    public void seeReviewsMade() {
        int count = 0;
        System.out.println("\nAll Reviews Made");
        for (Review review : this.student.getReviewsMade()) {
            System.out.println("\n [" + count + "]: " + review);
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

        System.out.println("\nYou will be prompted to edit Resume information below\n");

        System.out.println("Before beginning enter new username and password below to confim identity");

        String accounttype = this.user.getAccounttype();
        String status = this.user.getStatus();

        String username = this.user.getUsername();
        String password = this.user.getPassword();

        System.out.print("Username: ");
        if (!scanner.nextLine().equals(this.user.getUsername())) {
            System.out.println("Incorrect username.\nResume editing aborted");
            return;
        }

        System.out.print("Password: ");
        if (!scanner.nextLine().equals(this.user.getPassword())) {
            System.out.println("Incorrect password.\nResume editing aborted");
            return;
        }

        String firstname = this.user.getFirstName();
        String lastname = this.user.getLastName();
        String phoneNumber = this.user.getPhoneNumber();
        String email = this.user.getEmail();
        while (true) {
            System.out.println("Would you like to edit your name or contact information? Enter 'Yes' or 'No'\n");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("Yes")) {
                System.out.println("\nEnter basic information and contact information below\n");
                System.out.print("First Name: ");
                firstname = scanner.nextLine();
                System.out.print("Last Name: ");
                lastname = scanner.nextLine();
                System.out.print("Phone Number: ");
                phoneNumber = scanner.nextLine();
                System.out.print("Email: ");
                email = scanner.nextLine();
                break;
            } else if (userInput.equalsIgnoreCase("No")) {
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }

        String school = this.user.getSchool();
        String gpa = this.user.getGPA();
        String major = this.user.getMajor();
        String minor = this.user.getMinor();
        String concentration = this.user.getConcentation();
        String gradeLevel = this.user.getGradeLevel();
        while (true) {
            System.out.println("\nWould you like to edit your education experience? Enter 'Yes' or 'No'\n");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("Yes")) {
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
                break;
            } else if (userInput.equalsIgnoreCase("No")) {
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }

        String jobOccupation = this.user.getjobOccupation();
        String company = this.user.getCompany();
        String jobtype = this.user.getjobType();
        String prevExp = this.user.getPrevExp();
        String explength = this.user.getExpLength();
        String jobdesc = this.user.getJobDesc();
        while (true) {
            System.out.println("\nWould you like to edit your previous job experience? Enter 'Yes' or 'No'\n");
            String userInput = scanner.nextLine().trim();
            if (userInput.equalsIgnoreCase("Yes")) {
                System.out.println("\nFill out the information below to add a new work experience\n"
                        + "(Enter 'None' if field does not apply)\n");
                System.out.print("Job: ");
                jobOccupation = scanner.nextLine();
                System.out.print("Company: ");
                company = scanner.nextLine();
                System.out.print("Type (Part-Time, Full-Time, Internship): ");
                jobtype = scanner.nextLine();
                System.out.print("Length of Employment (MM/YYYY - MM/YYYY): ");
                explength = scanner.nextLine();
                System.out.print("Please enter description: ");
                jobdesc = scanner.nextLine();
                prevExp = "None";
                break;
            } else if (userInput.equalsIgnoreCase("No")) {
                break;
            } else {
                System.out.println("\nInvalid Command\n");
            }
        }

        ArrayList<String> skills = new ArrayList<>();
        while (true) {
            System.out.println("\nWould you like to edit personal skills? Enter 'Yes' or 'No'\n");
            String userInput = scanner.nextLine().trim();
            if (userInput.equalsIgnoreCase("Yes")) {
                System.out.println(
                        "\nEnter all skills below\nType an entry and press 'Enter'\nType 'Done' when finished entering skills to move on");
                while (true) {
                    String newEntry = scanner.nextLine();
                    if (newEntry.equalsIgnoreCase("done")) {
                        break;
                    }
                    skills.add(newEntry);
                }
                System.out.println("All new skills added!");
                break;
            } else if (userInput.equalsIgnoreCase("No")) {
                break;
            } else {
                System.out.println("Invalid Command");
            }

        }

        ArrayList<String> extraCurr = new ArrayList<>();
        while (true) {
            System.out.println("\nWould you like to edit extracurricular activities? Enter 'Yes' or 'No'\n");
            String userInput = scanner.nextLine().trim();
            if (userInput.equalsIgnoreCase("Yes")) {
                System.out.println(
                        "\nEnter all extracurriculars below\nType an entry and press 'Enter'\nType 'Done' when finished entering extracurriculars to move on");
                while (true) {
                    String newEntry = scanner.nextLine();
                    if (newEntry.equalsIgnoreCase("done")) {
                        break;
                    }
                    extraCurr.add(newEntry);
                }
                System.out.println("\nAll new extracurriculars added!");
                break;
            } else if (userInput.equalsIgnoreCase("No")) {
                break;
            } else {
                System.out.println("\nInvalid Command");
            }
        }

        ArrayList<String> jobsApplied = this.user.getJobsApplied();

        this.student = new Student(username, password, accounttype, school, company, firstname, lastname, email,
                phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation,
                jobtype, prevExp, explength, jobdesc, jobsApplied);

        this.user = new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                prevExp, explength, jobdesc, jobsApplied);

        users.editUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc, jobsApplied);

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

    // ----------------EMPLOYER MAIN MENU DISPLAY AND
    // FUNCTIONALITY-------------------

    public void employerMainMenuFunctionality() {
        while (true) {
            System.out.println("\nMain Menu");
            printPossibleCommands(EMPLOYER_MAIN_MENU_COMMANDS);
            int userDecision = getUserCommand(EMPLOYER_MAIN_MENU_COMMANDS);
            if (userDecision == 1) {
                this.employer.postNewJobListing();
            } else if (userDecision == 2) {
                seeAllPostedJobListings();
            } else if (userDecision == 3) {
                System.out.println("Thanks for using the internship app!\nGoodbye!");
                System.exit(0);
            } else {
                System.out.println("\nInvalid Command");
            }
        }
    }

    public void seeAllPostedJobListings() {
        int count = 1;
        for (JobListing jobListing : this.employer.getPostedJobListings()) {
            System.out.println("\n[" + count + "]: " + jobListing.shortToString());
            count++;
        }
        while (true) {
            System.out.println(
                    "\nEnter the number of a job listing to see more details.\nEnter '0' if you wish to return");
            int userInput = Integer.valueOf(scanner.nextLine());

            if (userInput > 0 && userInput <= this.employer.getPostedJobListings().size()) {
                employerDetailedJobListing(this.employer.getPostedJobListings().get(userInput - 1));
            } else if (userInput == 0) {
                return;
            } else {
                System.out.println("Invalid command");
                return;
            }

        }
    }

    public void employerDetailedJobListing(JobListing jobListing) {
        System.out.println("\n" + jobListing.longToString() + "\n");
        while (true) {
            printPossibleCommands(EMPLOYER_DETAILED_JOB_LISTING_COMMANDS);
            int userInput = getUserCommand(EMPLOYER_DETAILED_JOB_LISTING_COMMANDS);
            if (userInput == 1) {
                viewAllApplicants(jobListing);
            } else if (userInput == 2) {
                this.employer.editJobListing(jobListing);
            } else if (userInput == 3) {
                this.employer.deleteJobListing(jobListing);
            } else if (userInput == 4) {
                return;
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    public void viewAllApplicants(JobListing jobListing) {
        int count = 1;
        for (Student student : jobListing.getStudentsApplied()) {
            System.out.println("[" + count + "]: " + student.shortToString());
        }
        while (true) {
            System.out.println(
                    "\nEnter the number of a student to see more details\nEnter '-1' if you wish to filter students\nEnter '0' if you wish to return");
            int userInput = Integer.valueOf(scanner.nextLine());
            if (userInput > 0 && userInput <= jobListing.getStudentsApplied().size()) {
                viewStudentDetailsMenu(student, jobListing);
            } else if (userInput == -1) {
                ArrayList<Student> filteredStudents = this.employer.filteringStudents(jobListing.getStudentsApplied());
                viewFilteredApplicants(filteredStudents);
            } else if (userInput == 0) {
                return;
            } else {
                System.out.println("Invalid command");
                return;
            }

        }
    }

    public void viewFilteredApplicants(ArrayList<Student> filteredStudents) {
        int count = 1;
        for (Student student : filteredStudents) {
            System.out.println("[" + count + "]: " + student.shortToString());
        }
        while (true) {
            System.out.println("Enter the number of a student to see more details\nEnter '0' if you wish to return");
            int userInput = Integer.valueOf(scanner.nextLine());
            for (int i = 1; i < jobListing.getStudentsApplied().size(); i++) {
                if (userInput == i) {
                    viewStudentDetailsMenu(jobListing.getStudentsApplied().get(i - 1), jobListing);
                } else if (userInput == 0)
                    return;
                {
                    System.out.println("Invalid command");
                    return;
                }
            }
        }
    }

    public void viewStudentDetailsMenu(Student student, JobListing jobListing) {
        System.out.println(student.longToString());
        while (true) {
            printPossibleCommands(EMPLOYER_VIEWING_STUDENT_DETAILS_COMMANDS);
            getUserCommand(EMPLOYER_VIEWING_STUDENT_DETAILS_COMMANDS);
            int userInput = Integer.valueOf(scanner.nextLine());
            if (userInput == 1) {
                this.employer.acceptStudent(student, jobListing);
            } else if (userInput == 2) {
                this.employer.rejectStudent(student, jobListing);
            } else if (userInput == 3) {
                return;
            } else {
                System.out.println("Invalid command");
            }
        }
    }

    // -------------ADMINISTRATOR MAIN MENU DISPLAY AND FUNCTIONALITY-----------

    public void adminMainMenuFunctionality() {
        while (true) {
            System.out.println("\nMain Menu");
            printPossibleCommands(ADMIN_MAIN_MENU_COMMANDS);
            int userDecision = getUserCommand(ADMIN_MAIN_MENU_COMMANDS);
            if (userDecision == 1) {
                adminBrowseJobListings();
            } else if (userDecision == 2) {
                adminBrowseAllStudents();
            } else if (userDecision == 3) {

            } else if (userDecision == 4) {
                System.out.println("Thanks for using the internship app!\nGoodbye!");
                System.exit(0);
            } else {
                System.out.println("\nInvalid Command");
            }
        }
    }

    public void adminBrowseJobListings() {
        while (true) {
            printAllJobListings();
            System.out.println(
                    "\nEnter the number of a job listing to see more details.\nIf finished viewing listings enter '0' to return");
            int userInput = Integer.valueOf(scanner.nextLine());
            if (userInput == 0) {
                return;
            } else if (userInput > 0 && userInput <= jobListings.getJobList().size()) {
                adminDetailedJobListing(jobListings.getJobList().get(userInput - 1));
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    public void adminDetailedJobListing(JobListing jobListing) {
        jobListing.longToString();
        printPossibleCommands(ADMIN_DETAILED_JOB_LISTING_COMMANDS);
        int userInput = getUserCommand(ADMIN_DETAILED_JOB_LISTING_COMMANDS);
        if (userInput == 1) {
            this.admin.deleteJobListing(jobListing);
            return;
        } else if (userInput == 2) {
            return;
        } else {
            System.out.println("Invalid Command");
        }
    }

    public void adminBrowseAllStudents() {
        int count = 1;
        for (User user : getAllStudentUsers()) {
            System.out.println("[" + count + "]: " + user.UserResumetoFile());
        }
        while (true) {
            System.out
                    .println("Enter the number of a Student user you wish to delete\nEnter '0' if you wish to return");
            int userInput = Integer.valueOf(scanner.nextLine());
            if (userInput > 0 && userInput <= getAllStudentUsers().size()) {
                System.out.println("Are you aure you want to delete user \'"
                        + getAllStudentUsers().get(userInput - 1).getFirstName() + " "
                        + getAllStudentUsers().get(userInput - 1).getLastName() + "\'?\n'Yes' or 'No'");
                String userConfirm = scanner.nextLine();
                if (userConfirm.equalsIgnoreCase("Yes")) {
                    this.admin.deleteStudent(getAllStudentUsers().get(userInput - 1));
                    System.out.println("\nStudent User Deleted");
                    break;
                } else if (userConfirm.equalsIgnoreCase("No")) {
                    System.out.println("Deletion of Student User was Cancelled");
                    return;
                } else {
                    System.out.println("Invalid Command\nAboritng Student User Deletion Process");
                    return;
                }
            } else if (userInput == 0) {
                return;
            } else {
                System.out.println("Invalid Command");
            }
        }

    }

    public void adminBrowseAllEmployers() {
        int count = 1;
        for (User user : getAllEmployerUsers()) {
            System.out.println("[" + count + "]: " + user.UserResumetoFile());
        }
        while (true) {
            System.out.println(
                    "Enter the number of an Employer user you wish to delete\nEnter '0' if you wish to return");
            int userInput = Integer.valueOf(scanner.nextLine());
            if (userInput > 0 && userInput <= getAllEmployerUsers().size()) {
                System.out.println("Are you aure you want to delete user \'"
                        + getAllEmployerUsers().get(userInput - 1).getFirstName() + " "
                        + getAllEmployerUsers().get(userInput - 1).getLastName() + "\'?\n'Yes' or 'No'");
                String userConfirm = scanner.nextLine();
                if (userConfirm.equalsIgnoreCase("Yes")) {
                    this.admin.deleteEmployer(getAllStudentUsers().get(userInput - 1));
                    System.out.println("\nEmployer User Deleted");
                    break;
                } else if (userConfirm.equalsIgnoreCase("No")) {
                    System.out.println("Deletion of Student User was Cancelled");
                    return;
                } else {
                    System.out.println("Invalid Command\nAboritng Employer User Deletion Process");
                    return;
                }
            } else if (userInput == 0) {
                return;
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    // --------------------GENERAL FUNCTIONALITY------------------------

    public ArrayList<User> getAllStudentUsers() {
        ArrayList<User> students = new ArrayList<>();
        for (User user : users.getUsers()) {
            if (user.getAccounttype().equals("Student")) {
                students.add(user);
            }
        }
        return students;
    }

    public ArrayList<User> getAllEmployerUsers() {
        ArrayList<User> employers = new ArrayList<>();
        for (User user : users.getUsers()) {
            if (user.getAccounttype().equals("Student")) {
                employers.add(user);
            }
        }
        return employers;
    }

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
        return -2;
    }

    public void printAllJobListings() {
        int count = 1;
        for (JobListing jobListing : jobListings.getJobList()) {
            System.out.println("\n[" + count + "]: " + jobListing.shortToString());
            count++;
        }
    }

    public static void main(String[] args) {

        InternshipAppUI internshipAppInterface = new InternshipAppUI();
        internshipAppInterface.run();
    }
}
