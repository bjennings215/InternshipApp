/**
 * @author Adam Trickett,Brandon Jennings,Brady Smoak, Esam Sartawi
 * @param users this is meant to create an instance of the class users.java
 *@param userlist this is the arraylist used to house the user
 * this Singleton class holds an arraylist of type user and adds, edits, and removes from the arraylist as well as other functionality
 */
import java.util.ArrayList;

public class Users {
    private static Users users = null;
    private static ArrayList<User> userlist = new ArrayList<User>();
    /**
     * @param users this is meant to create an instance of the class users.java
     * @param userlist this is the arraylist used to house the user
     * this is the constructor for the class users
     */
    private Users() {
        userlist = DataLoader.InputUsers();
    }
    /**
     * this is a Singleton method used to get the Instance of the class users
     * @param users this is used to create an instance of the class
     */
    public static Users getInstance() {
        if(users == null) {
        users = new Users();
        }
        return users;
    }
    /**
     * this is used to check if a user has a username and returns true(basically a find method)
     * @param userName this is the username of the person who is to be searched for
     * @return true or false based on if found or not 
     */
    public boolean haveUser(String userName) {
		for(User user : userlist) {
			if(user.getUsername().equals(userName)) {
				return true;
			}
		}
		return false;
	}
    /**
     * this method grabs the user when searching for a user 
     * @param username username of the person being searched for
     * @return the user with the search criteria username
     */
    public User getUser(String username) {
        for(User user : userlist){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
    /**
     * this method returns the arraylist of users
     * @return userlist which is the arraylist that holds 
     */
    public ArrayList<User> getUsers() {
        return userlist;
    }
    /**
     * this adds a user to the arraylist of users and then calls the datawriter method to write that data into the json file
     * @param username the username of the person to be added
     * @param password the password
     * @param accounttype the type of account (admin,student,employer)
     * @param school the school of person 
     * @param company name of company
     * @param firstname firstname
     * @param lastname lastname
     * @param email email of person
     * @param phoneNumber phonenumber
     * @param major students major
     * @param minor students minor
     * @param concentration students concentration area
     * @param gradeLevel gradelevel
     * @param gpa grade point average
     * @param skills skills the student has
     * @param extraCurr extracurricular activities
     * @param status job status
     * @param jobOccupation job occupation
     * @param jobtype job type
     * @param prevExp previous experience
     * @param explength experience length
     * @param jobdesc job description
     */
    public void addUser(String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc,ArrayList<String> jobApplied) {
        userlist.add(new User(username,password,accounttype,school,company,firstname,lastname,email,phoneNumber,major,minor,concentration,
        gradeLevel,gpa,skills,extraCurr,status,jobOccupation,jobtype,prevExp,explength,jobdesc,jobApplied));
        DataWriter.saveUsers();
    }
    /**
     * this removes a user to the arraylist of users and then calls the datawriter method to write that data into the json file
     * @param username the username of the person to be added
     * @param password the password
     * @param accounttype the type of account (admin,student,employer)
     * @param school the school of person 
     * @param company name of company
     * @param firstname firstname
     * @param lastname lastname
     * @param email email of person
     * @param phoneNumber phonenumber
     * @param major students major
     * @param minor students minor
     * @param concentration students concentration area
     * @param gradeLevel gradelevel
     * @param gpa grade point average
     * @param skills skills the student has
     * @param extraCurr extracurricular activities
     * @param status job status
     * @param jobOccupation job occupation
     * @param jobtype job type
     * @param prevExp previous experience
     * @param explength experience length
     * @param jobdesc job description
     */
    public void removeUser(String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc,ArrayList<String> jobsApplied) {
        for(int i = 0; i < userlist.size(); i++){
            if(userlist.get(i).getUsername().equals(username)){
                userlist.remove(i);
                DataWriter.saveUsers();
            }
        }
    }
    /**
     * this edits a user in the arraylist of users and then calls the datawriter method to write that data into the json file
     * @param username the username of the person to be added
     * @param password the password
     * @param accounttype the type of account (admin,student,employer)
     * @param school the school of person 
     * @param company name of company
     * @param firstname firstname
     * @param lastname lastname
     * @param email email of person
     * @param phoneNumber phonenumber
     * @param major students major
     * @param minor students minor
     * @param concentration students concentration area
     * @param gradeLevel gradelevel
     * @param gpa grade point average
     * @param skills skills the student has
     * @param extraCurr extracurricular activities
     * @param status job status
     * @param jobOccupation job occupation
     * @param jobtype job type
     * @param prevExp previous experience
     * @param explength experience length
     * @param jobdesc job description
     */
    public void editUser(String username, String password, String accounttype, String school, String company, String firstname, 
	String lastname, String email, String phoneNumber, String major, String minor, String concentration, String gradeLevel, String gpa, 
	ArrayList<String> skills, ArrayList<String> extraCurr, String status, String jobOccupation, String jobtype, String prevExp, String explength, 
	String jobdesc,ArrayList<String> jobsApplied) {
        for(int i = 0; i < userlist.size(); i++){
            if(userlist.get(i).getUsername().equals(username)){
                userlist.set(i, new User(username,password,accounttype,school,company,firstname,lastname,email,phoneNumber,major,minor,concentration,
                gradeLevel,gpa,skills,extraCurr,status,jobOccupation,jobtype,prevExp,explength,jobdesc,jobsApplied));
                DataWriter.saveUsers();
            }
        }
    }
    /**
     * this writes the data when the student logs out
     */
    public void logout(){
		DataWriter.saveUsers();
	}

}

