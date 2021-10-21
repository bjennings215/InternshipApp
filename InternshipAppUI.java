
import java.util.Scanner;

public class InternshipAppUI {

    private static final String[] LOGIN_COMMANDS = { "Log in", "Create new account" };
    private static final String[] USER_TYPE_COMMANDS = { "Student", "Employer", "Administrator" };
    private static final String[] STUDENT_MAIN_MENU_COMMANDS = { "Browse Job Listings", "See Jobs Applied To",
            "See Reviews Made", "Edit Resume", "Edit Account", "Log Off" };
    private static final String[] EMPLOYER_MAIN_MENU_COMMANDS = { "Post New Job Listing", "See Posted Job Listings",
            "Search Students", "Log Out" };
    private static final String[] ADMIN_MAIN_MENU_COMMANDS = { "Browse All Job Listings", "Browse All Students",
            "Search Job Listings", "Search Students" };
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
        displayStudentMainMenu();
        displayEmployerMainMenu();
        displayAdminMainMenu();
    }

    public void initialLogInMenu() {
        System.out.println("Welcome to the Internship Application!");

        while (true) {
            printPossibleCommands(LOGIN_COMMANDS);
            int userDecision = getUserCommand(LOGIN_COMMANDS);
            if (userDecision == 1) {
                loggingIn();
                return;
            } else if (userDecision == 2) {
                establishAccountCreation();
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
            //Testing logging in correctly
            //if(username != null) {
            //    return;
            //}
            //Code that will be used in the end
            //if (verifyLoginCredentials(username, password)) {
            //    return;
            //}
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
    public String determineAccountType() {

    }
    */

    public void establishAccountCreation() {
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
                break;
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

    public void displayStudentMainMenu() {
        System.out.println("\nMain Menu");
        printPossibleCommands(STUDENT_MAIN_MENU_COMMANDS);
        int userDecision = getUserCommand(STUDENT_MAIN_MENU_COMMANDS);
        if(userDecision == 1) {
            System.out.println("Option 1");
        }

    }

    public void displayEmployerMainMenu() {
        System.out.println("\nMain Menu");
        printPossibleCommands(EMPLOYER_MAIN_MENU_COMMANDS);
        int userDecision = getUserCommand(EMPLOYER_MAIN_MENU_COMMANDS);
        if(userDecision == 1) {
            System.out.println("Option 1");
        }
    }

    public void displayAdminMainMenu() {
        System.out.println("\nMain Menu");
        printPossibleCommands(ADMIN_MAIN_MENU_COMMANDS);
        int userDecision = getUserCommand(ADMIN_MAIN_MENU_COMMANDS);
        if(userDecision == 1) {
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

    public static void main(String[] args) {

        InternshipAppUI internshipAppInterface = new InternshipAppUI();
        internshipAppInterface.run();
    }
}
