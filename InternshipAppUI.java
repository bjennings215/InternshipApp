
import java.util.Scanner;

public class InternshipAppUI {

    private String[] logInCommands = { "Log in", "Create new account" };
    private String[] userTypeCommands = { "Student", "Employer", "Administrator" };
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
    }

    public void initialLogInMenu() {
        System.out.println("Welcome to the Internship Application!");

        while (true) {
            printPossibleCommands(logInCommands);
            int userDecision = getUserCommand(logInCommands);
            if (userDecision == 1) {
                loggingIn();
                return;
            } else if (userDecision == 2) {
                establishAccountCreation();
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    public void loggingIn() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Username: ");
            String username = scanner.next();
            System.out.print("Password: ");
            String password = scanner.next();
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

    public void establishAccountCreation() {
        System.out.println("\nWhat type of account do you wish to create?");
        while (true) {
            printPossibleCommands(userTypeCommands);
            int userDecision = getUserCommand(userTypeCommands);
            if (userDecision == 1) {
                System.out.println("\nWelcome new Student!");
                System.out.println("Enter new username and password below");
                System.out.print("Username: ");
                String username = scanner.next();
                System.out.print("Password: ");
                String password = scanner.next();
                //Create and add new student
                break;
            } else if (userDecision == 2) {
                System.out.println("\nWelcome new Employer!");
                System.out.println("Enter new username and password below");
                System.out.print("Username: ");
                String username = scanner.next();
                System.out.print("Password: ");
                String password = scanner.next();
                //Create and add new employer
                break;
            } else if (userDecision == 3) {
                System.out.println("\nWelcome new Administrator!");
                System.out.println("Enter new username and password below");
                System.out.print("Username: ");
                String username = scanner.next();
                System.out.print("Password: ");
                String password = scanner.next();
                //Create and add new administrator
                break;
            }
            System.out.println("Invalid Command");
        }
    }

    public void displayAdminMainMenu() {

    }

    public void displayEmployerMainMenu() {

    }

    public void displayStudentMainMenu() {
        System.out.println("Made it to the main menu");
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
