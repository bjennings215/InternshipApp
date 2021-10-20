
import java.util.Scanner;

public class InternshipAppUI {

    private String[] logInCommands = {"Log in", "Create new account"};
    private Scanner scanner;

    InternshipAppUI() {
        this.scanner = new Scanner(System.in);
    }
    
    public void run() {
        logIn();
    }

    public void printPossibleCommands(String[] availableCommands) {
        for(int i=0; i<availableCommands.length; i++) {
            System.out.println((i+1)+". "+availableCommands[i]);
        }
    } 

    public int getUserCommand(int numOfPossibleCommands) {
        
        System.out.println("Type the number of the option you wish to choose below");

        int userChoice = Integer.parseInt(scanner.nextLine()) - 1;

        if(userChoice > 0 && userChoice <= numOfPossibleCommands - 1)
            return userChoice;
        return -1;
    }

    
    public void logIn() {
        System.out.println("Welcome to the Internship Application!");
        printPossibleCommands(logInCommands);
        getUserCommand(logInCommands.length);
    }

    public void displayAdminMainMenu() {

    }

    public void displayEmployerMainMenu() {

    }
    
    public void displayStudentMainMenu() {

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

    public static void main(String[] args) {

        InternshipAppUI internshipAppInterface = new InternshipAppUI();
        internshipAppInterface.run();
    }
}
