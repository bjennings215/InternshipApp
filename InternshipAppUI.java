
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

public class InternshipAppUI {

    private static final String[] USERNAME_AND_PASSWORD_PROMPTS = { "Username", "Password" };

    private static final String[] LOGIN_COMMANDS = { "Log in", "Create new account" };
    private static final String[] USER_TYPE_COMMANDS = { "Student", "Employer", "Administrator" };
    private static final String[] STUDENT_MAIN_MENU_COMMANDS = { "Browse Job Listings", "See Jobs Applied To",
            "See Reviews Made", "Edit Resume", "Edit Account", "Log Off" };
    private static final String[] EMPLOYER_MAIN_MENU_COMMANDS = { "Post New Job Listing", "See Posted Job Listings",
            "Search Students", "Log Out" };
    private static final String[] ADMIN_MAIN_MENU_COMMANDS = { "Browse All Job Listings", "Browse All Students",
            "Search Job Listings", "Search Students", "Log Off" };
    private static final String[] RESUME_CREATION_COMMANDS = { "Education", "Previous Work Experience",
            "Skills and Extracurriculars", "Finish Resume Creation" };
    private Scanner scanner;
    private Users allUsers;
    private Student student;
    private Employer employer;
    private Administrator admin;

    InternshipAppUI() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        initialLogInMenu();

        
        studentMainMenu();
        // employerMainMenu();
        // adminMainMenu();
    }

//---------------------------------------------------------LOG IN FUNCTIONALITY----------------------------------------------------------------

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
            // Testing logging in correctly
            if(username != null) {
                return;
            }
            // Code that will be used in the end
            // if (verifyLoginCredentials(username, password)) {
            // return;
            // }
            System.out.println("Either username or password is incorrect");
            attempts++;
        }
        System.out.println("You have used too many attempts. Please try again later.\nGoodbye");
        System.exit(0);
    }

    public boolean verifyLoginCredentials(String username, String password) {
        if (allUsers.haveUser(username) && allUsers.getUser(username).getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    /**
     * public String determineAccountType() {
     * 
     * }
     */

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
                //Creates and adds new student
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
                ArrayList<String> skills = null;
                ArrayList<String> extraCurr = null;
                ArrayList<String> prevExp = null;
                ArrayList<String> explength = null;
                ArrayList<String> jobdesc = null;
                String status = null;
                users.addUser(username,password,accounttype,school,company,firstname,lastname,major,minor,concentration,
                gradeLevel,gpa,skills,extraCurr,status,prevExp,explength,jobdesc);
                ArrayList<User> accountInfo  = users.getUsers();
                for(User user : accountInfo){
                    if(user.getUsername().equals(username)){
                        System.out.println(username);
                        System.out.println(accounttype);
                        System.out.println(school);
                    }
                }
                break;
                //createStudentResume(username, password);
                //break;
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

//------------------------------------------------RESUME CREATION DISPLAY AND FUNCTIONALITY----------------------------------------------------

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
                newSkillsAndExtracurricularEntry();
            } else if (userDecision == 4) {
                //this.student.createResume(new Resume());
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

    public void newSkillsAndExtracurricularEntry() {
        System.out.println("\nEnter any skills or extracurriculars below\nSeperate all entries with a comma and press 'Enter' when finished");
        String[] skillsAndExtracurriculars = scanner.nextLine().split(",");
        //Adds all to persons Resume
    }

//------------------------------------------------STUDENT MAIN MENU DISPLAY AND FUNCTIONALITY----------------------------------------------------

    public void studentMainMenu() {
        System.out.println("\nMain Menu");
        printPossibleCommands(STUDENT_MAIN_MENU_COMMANDS);
        int userDecision = getUserCommand(STUDENT_MAIN_MENU_COMMANDS);
        if (userDecision == 1) {
            printAllJobListings();
        } else if (userDecision == 2) {
            System.out.println(this.student.getJobsAppliedTo());
        } else if (userDecision == 3) {
            System.out.println(this.student.getReviewsMade());
        } else if (userDecision == 4) {

        } else if (userDecision == 5) {

        } else if (userDecision == 6) {

        } else {
            System.out.println("\nInvalid command");
        }

    }

    public ArrayList<JobListing> printAllJobListings() {
        //For loop that runs through each Job Listing and prints them all to the console
        return new ArrayList<JobListing>();
    }

//------------------------------------------------EMPLOYER MAIN MENU DISPLAY AND FUNCTIONALITY----------------------------------------------------

    public void employerMainMenu() {
        System.out.println("\nMain Menu");
        printPossibleCommands(EMPLOYER_MAIN_MENU_COMMANDS);
        int userDecision = getUserCommand(EMPLOYER_MAIN_MENU_COMMANDS);
        if (userDecision == 1) {
            System.out.println("Option 1");
        }
    }

//----------------------------------------------ADMINISTRATOR MAIN MENU DISPLAY AND FUNCTIONALITY----------------------------------------------------

    public void adminMainMenu() {
        System.out.println("\nMain Menu");
        printPossibleCommands(ADMIN_MAIN_MENU_COMMANDS);
        int userDecision = getUserCommand(ADMIN_MAIN_MENU_COMMANDS);
        if (userDecision == 1) {
            System.out.println("Option 1");
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

//--------------------------------------------------------GENERAL FUNCTIONALITY---------------------------------------------------------------

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
