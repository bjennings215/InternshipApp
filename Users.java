import java.util.ArrayList;

//Singleton class get ArrayList of Users
public class Users {
    private static Users users = null;
    private static ArrayList<User> userlist = new ArrayList<User>();

    private Users() {
        userlist = DataLoader.InputUsers();
    }

    //Singleton 
    public static Users getInstance() {
        if(users == null) {
        users = new Users();
        }
        return users;
    }

    //check to see if user already exist
    public boolean haveUser(String username) {
		for(User user : userlist) {
			if(user.getUsername().equals(username)) {
				return true;
			}
		}
		
		return false;
	}

    //gets User from Arraylist of Users
    public User getUser(String username) {
        for(User user : userlist){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    //return Arraylist of Users
    public ArrayList<User> getUsers() {
        return userlist;
    }

    //adds user to Arraylist and writes to JSON file(database)
    public void addUser(String username, String password) {
        userlist.add(new User(username,password));
        DataWriter.saveUsers();
    }

    //removes user from ArrayList and removes from JSON file(database)
    public void removeUser(String username, String password) {
        userlist.remove(new User(username,password));
        DataWriter.saveUsers();
    }


    public void editUser(String username, String password) {
        for(int i = 0; i < userlist.size(); i++){
            if(userlist.get(i).getUsername().equals(username)){
                userlist.set(i,new User(username,password));
                DataWriter.saveUsers();
            }
        }
    }

}

