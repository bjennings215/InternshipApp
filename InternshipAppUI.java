
import java.util.Scanner;

public class InternshipAppUI {

    private String[] logInCommands = { "Log in", "Create new account" };
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
    }

    public void initialLogInMenu() {
        System.out.println("Welcome to the Internship Application!");

        printPossibleCommands(logInCommands);
        if (getUserCommand(logInCommands.length) == 1) {
            loggingIn();
        } else if(getUserCommand(logInCommands.length) == 2) {
            
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
                //return;
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

    public int getUserCommand(int numOfPossibleCommands) {

        System.out.println("Type the number of the option you wish to choose below");

        int userChoice = Integer.parseInt(scanner.nextLine());

        if (userChoice > 0 && userChoice <= numOfPossibleCommands - 1)
            return userChoice;
        return -1;
    }

    public static void main(String[] args) {

        InternshipAppUI internshipAppInterface = new InternshipAppUI();
        internshipAppInterface.run();
    }
}
