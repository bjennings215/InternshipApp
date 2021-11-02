
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
            "See Reviews Made", "See Resume Details", "Edit Resume", "Edit Account", "Print Resume", "Log Off" };
    private static final String[] EMPLOYER_MAIN_MENU_COMMANDS = { "Post New Job Listing", "See Posted Job Listings",
            "Log Off" };
    private static final String[] ADMIN_MAIN_MENU_COMMANDS = { "Browse All Job Listings", "Browse All Students",
            "Browse All Employers", "Search Job Listings", "Search Students", "Search Employers", "Log Off" };
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
                    this.user.getjobType(), this.user.getPrevExp(), this.user.getExpLength(), this.user.getJobDesc());
            studentMainMenuFunctionality();
        } else if (this.user.getAccounttype().equals("Employer")) {
            this.employer = new Employer(this.user.getUsername(), this.user.getPassword(), this.user.getAccounttype(),
                    this.user.getSchool(), this.user.getCompany(), this.user.getFirstName(), this.user.getLastName(),
                    this.user.getEmail(), this.user.getPhoneNumber(), this.user.getMajor(), this.user.getMinor(),
                    this.user.getConcentation(), this.user.getGradeLevel(), this.user.getGPA(), this.user.getSkills(),
                    this.user.getExtracurr(), this.user.getStatus(), this.user.getjobOccupation(),
                    this.user.getjobType(), this.user.getPrevExp(), this.user.getExpLength(), this.user.getJobDesc());
            employerMainMenuFunctionality();
        } else if (this.user.getAccounttype().equals("Admin")) {
            this.admin = new Administrator(this.user.getUsername(), this.user.getPassword(), this.user.getAccounttype(),
                    this.user.getSchool(), this.user.getCompany(), this.user.getFirstName(), this.user.getLastName(),
                    this.user.getEmail(), this.user.getPhoneNumber(), this.user.getMajor(), this.user.getMinor(),
                    this.user.getConcentation(), this.user.getGradeLevel(), this.user.getGPA(), this.user.getSkills(),
                    this.user.getExtracurr(), this.user.getStatus(), this.user.getjobOccupation(),
                    this.user.getjobType(), this.user.getPrevExp(), this.user.getExpLength(), this.user.getJobDesc());
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
        System.out.println("Enter new username and password below");

        String username = verifyAndSetUsername();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("First Name: ");
        String firstname = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastname = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        String accounttype = "Student";
        String school = null;
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
        String jobOccupation = null;
        String jobtype = null;

        this.user = new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                prevExp, explength, jobdesc);

        users.addUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc);

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
        System.out.print("First Name: ");
        String firstname = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastname = scanner.nextLine();
        System.out.print("Company: ");
        String company = scanner.nextLine();

        String accounttype = "Employer";
        String school = null;
        String major = null;
        String minor = null;
        String concentration = null;
        String gradeLevel = null;
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

    public void createStudentResume(String username, String password, String accounttype, String school, String company,
            String firstname, String lastname, String email, String phoneNumber, String major, String minor,
            String concentration, String gradeLevel, String gpa, ArrayList<String> skills, ArrayList<String> extraCurr,
            String status, String jobOccupation, String jobtype, String prevExp, String explength, String jobdesc) {
        System.out.println("\nYou will now be prompted to set up your Resume\n");
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
                this.student.newEducationEntry(username, password, accounttype, school, company, firstname, lastname,
                        email, phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status,
                        jobOccupation, jobtype, prevExp, explength, jobdesc);
            } else if (userDecision == 2) {
                this.student.newJobExperienceEntry(username, password, accounttype, school, company, firstname,
                        lastname, email, phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr,
                        status, jobOccupation, jobtype, prevExp, explength, jobdesc);
            } else if (userDecision == 3) {
                this.student.newSkillsEntry(username, password, accounttype, school, company, firstname, lastname,
                        email, phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status,
                        jobOccupation, jobtype, prevExp, explength, jobdesc);
            } else if (userDecision == 4) {
                this.student.newExtraCurricularEntry(username, password, accounttype, school, company, firstname,
                        lastname, email, phoneNumber, major, minor, concentration, gradeLevel, gpa, skills, extraCurr,
                        status, jobOccupation, jobtype, prevExp, explength, jobdesc);
            } else if (userDecision == 5) {
                System.out.println("Congratulations! Resume creation finished!");
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    // -----------STUDENT MAIN MENU DISPLAY AND FUNCTIONALITY------------------

    public void studentMainMenuFunctionality() {
        while (true) {
            System.out.println("\nMain Menu");
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
                studentAccountEditingMenu();
            } else if (userDecision == 7) {
                printResume();
            } else if (userDecision == 8) {
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
        int count = 1;
        System.out.println("\nAll Jobs Applied To");
        for (JobListing jobListing : this.student.getJobsAppliedTo()) {
            System.out.println("\n [" + count + "]: " + jobListing.shortToString());
            count++;
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
        System.out.println("\nResume Editing Menu");
        String username = user.getUsername();
        System.out.print("Password: ");
        String password = user.getPassword();
        String accounttype = "Student";
        String school = null;
        String firstname = user.getFirstName();
        String lastname = user.getLastName();
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
        String email = user.getEmail();
        String phoneNumber = user.getPhoneNumber();
        String jobOccupation = null;
        String jobtype = null;

        this.user = new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                prevExp, explength, jobdesc);

        users.editUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc);

        createStudentResume(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                prevExp, explength, jobdesc);
    }

    public void studentAccountEditingMenu() {
        System.out.println("\nAccount Editing Menu Editing Menu");
        String username = user.getUsername();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        String accounttype = "Student";
        String school = user.getSchool();
        System.out.print("First Name: ");
        String firstname = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastname = scanner.nextLine();
        String major = user.getMajor();
        String minor = user.getMinor();
        String concentration = user.getConcentation();
        String gradeLevel = user.getGradeLevel();
        String company = user.getCompany();
        String gpa = user.getGPA();
        ArrayList<String> skills = user.getSkills();
        ArrayList<String> extraCurr = user.getExtracurr();
        String prevExp = user.getPrevExp();
        String explength = user.getExpLength();
        String jobdesc = user.getJobDesc();
        String status = user.getStatus();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = user.getPhoneNumber();
        String jobOccupation = user.getjobOccupation();
        String jobtype = user.getjobType();

        this.user = new User(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber,
                major, minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype,
                prevExp, explength, jobdesc);

        users.editUser(username, password, accounttype, school, company, firstname, lastname, email, phoneNumber, major,
                minor, concentration, gradeLevel, gpa, skills, extraCurr, status, jobOccupation, jobtype, prevExp,
                explength, jobdesc);
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

    // ----------------EMPLOYER MAIN MENU DISPLAY AND FUNCTIONALITY-------------------

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
        printAllJobListings();
        while (true) {
            System.out
                    .println("Enter the number of a job listing to see more details.\nEnter '0' if you wish to return");
            int userInput = Integer.valueOf(scanner.nextLine());
            for (int i = 1; i < jobListings.getJobList().size(); i++) {
                if (userInput == i) {
                    employerDetailedJobListing(jobListings.getJobList().get(i - 1));
                } else if (userInput == 0) {
                    return;
                } else {
                    System.out.println("Invalid command");
                    return;
                }
            }
        }
    }

    public void employerDetailedJobListing(JobListing jobListing) {
        System.out.println(jobListing.longToString());
        while (true) {
            printPossibleCommands(EMPLOYER_DETAILED_JOB_LISTING_COMMANDS);
            getUserCommand(EMPLOYER_DETAILED_JOB_LISTING_COMMANDS);
            int userInput = Integer.valueOf(scanner.nextLine());
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
                    "Enter the number of a student to see more details\nEnter '-1' if you wish to filter students\nEnter '0' if you wish to return");
            int userInput = Integer.valueOf(scanner.nextLine());
            for (int i = 1; i < jobListing.getStudentsApplied().size(); i++) {
                if (userInput == i) {
                    viewStudentDetailsMenu(jobListing.getStudentsApplied().get(i - 1), jobListing);
                } else if (userInput == -1) {
                    ArrayList<Student> filteredStudents = this.employer
                            .filteringStudents(jobListing.getStudentsApplied());
                    viewFilteredApplicants(filteredStudents);
                } else if (userInput == 0)
                    return;
                {
                    System.out.println("Invalid command");
                    return;
                }
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

            } else if (userDecision == 3) {

            } else if (userDecision == 4) {
                System.out.println(this.admin.searchJobListing().toString());
            } else if (userDecision == 5) {
                System.out.println(this.admin.searchStudent().toString());
            } else if (userDecision == 6) {
                System.out.println(this.admin.searchEmployer().toString());
            } else if (userDecision == 7) {
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
        getUserCommand(ADMIN_DETAILED_JOB_LISTING_COMMANDS);
        int userInput = Integer.valueOf(scanner.nextLine());
        if (userInput == 1) {
            this.admin.deleteJobListing(jobListing);
            return;
        } else if (userInput == 2) {
            return;
        } else {
            System.out.println("Invalid Command");
        }
    }

    public void browseAllStudents() {

    }

    // --------------------GENERAL FUNCTIONALITY------------------------

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
