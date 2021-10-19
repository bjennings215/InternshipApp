import java.util.ArrayList;

public class Users {
    private static Users users = null;
    private static ArrayList<User> userlist = new ArrayList<User>();

    private Users() {
        userlist = DataLoader.InputUsers();
    }

    public static Users getInstance() {
        if(users == null) {
        users = new Users();
        }
        return users;
    }

    public ArrayList<User> getUsers() {
        return userlist;
    }

    public void addPerson(String username, String password) {
        userlist.add(new User(username,password));
        DataWriter.saveUsers();
    }

    public void removePerson(String username, String password) {
        userlist.remove(new User(username,password));
        DataWriter.saveUsers();
    }

}
