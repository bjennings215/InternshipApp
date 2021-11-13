import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class UsersTest {

    private Users users = Users.getInstance();
    private ArrayList<User> userList = users.getUsers();

    @BeforeEach
    public void setup() {
        userList.clear();
        userList.add(new User("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null));
        userList.add(new User("amyLove18", "amyLove1", "Student", "USC", null, "Amy", "Love", "amymail@gmail.com",
                "999-999-9999", "Computer Science", null, null, "Sophomore", "2.0", null, null, "Unemployed", null,
                null, null, null, null, null));
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @Test
    public void testHasFirstItemInList() {
        userList.clear();
        userList.add(new User("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null));
        userList.add(new User("amyLove18", "amyLove1", "Student", "USC", null, "Amy", "Love", "amymail@gmail.com",
                "999-999-9999", "Computer Science", null, null, "Sophomore", "2.0", null, null, "Unemployed", null,
                null, null, null, null, null));
        DataWriter.saveUsers();
        
        boolean hasDave = users.haveUser("davejones");
        assertTrue(hasDave);
    }

    @Test
    public void testHasLastItemInList() {
        boolean hasAmy = users.haveUser("amyLove18");
        assertTrue(hasAmy);
    }

    @Test
    public void testHaveUserNotInlist() {
        boolean hasDerek = users.haveUser("derekp");
        assertFalse(hasDerek);
    }

    @Test
    public void testHaveUserWithEmpty() {
        boolean hasEmpty = users.haveUser("");
        assertFalse(hasEmpty);
    }

    @Test
    public void testHaveUserWithNull() {
        boolean hasNull = users.haveUser(null);
        assertFalse(hasNull);
    }

    @Test
    public void testGetUserUsername() {
        userList.clear();
        userList.add(new User("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null));
        userList.add(new User("amyLove18", "amyLove1", "Student", "USC", null, "Amy", "Love", "amymail@gmail.com",
                "999-999-9999", "Computer Science", null, null, "Sophomore", "2.0", null, null, "Unemployed", null,
                null, null, null, null, null));
        DataWriter.saveUsers();
        String password = users.getUser("davejones").getPassword();
        assertEquals(password, "dmjones1");
    }

    @Test
    public void testGetUserwithEmpty() {
        User getEmpty = users.getUser("");
        assertNull(getEmpty);
    }

    @Test
    public void testAddingBrandNewUser() {
        users.addUser("mikesmith22", "mikespassword", "Student", "USC", null, "Mike", "Smith", "msmith@email.sc.edu",
                "987-654-3210", "Computer Science", "Statistics", null, "Junior", "3.1", null, null, "Unemployed", null,
                null, null, null, null, null);
        assertTrue(users.haveUser("mikesmith22"));
    }

    @Test
    public void testAddingSameUser() {
        userList.clear();
        userList.add(new User("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null));
        userList.add(new User("amyLove18", "amyLove1", "Student", "USC", null, "Amy", "Love", "amymail@gmail.com",
                "999-999-9999", "Computer Science", null, null, "Sophomore", "2.0", null, null, "Unemployed", null,
                null, null, null, null, null));
        DataWriter.saveUsers();
        
        users.addUser("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null);
        int count = 0;
        for (User user : users.getUsers()) {
            if (user.getUsername().equals("davejones")) {
                count++;
            }
        }
        assertEquals(1, count);
    }

    @Test
    public void testRemovingCurrentUser() {
        users.removeUser("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null);
        assertFalse(users.haveUser("davejones"));
    }

    @Test
    public void testRemovingFakeUser() {
        int beginningSize = users.getUsers().size();
        users.removeUser("mikesmith22", "mikespassword", "Student", "USC", null, "Mike", "Smith", "msmith@email.sc.edu",
                "987-654-3210", "Computer Science", "Statistics", null, "Junior", "3.1", null, null, "Unemployed", null,
                null, null, null, null, null);
        assertEquals(beginningSize, users.getUsers().size());
    }

    @Test
    public void testEditingSinglePartOfCurrentUser() {
        users.editUser("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
        "123-456-7890", "Computer Science", null, null, "Senior", "2.2", null, null, "Unemployed", null, null,
        null, null, null, null);
        assertEquals(users.getUser("davejones").getGPA(), "2.2");
    }

    @Test
    public void testEditingMultiplePartsOfCurrentUser() {
        users.editUser("davejones", "davidjones1000", "Student", "USC", null, "David", "Jones", "davidjones@gmail.com",
        "808-808-8008", "Computer Science", null, null, "Senior", "2.2", null, null, "Employed", null, null,
        null, null, null, null);
        assertTrue(users.getUser("davejones").getStatus().equals("Employed") && users.getUser("davejones").getGPA().equals("2.2")); 
    }

    @Test
    public void testEditingDoesNotMakeDuplicateUsers() {
        int count = users.getUsers().size();
        users.editUser("davejonesEDITED", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
        "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
        null, null, null, null);
        assertEquals(count, users.getUsers().size());
    }

    
}
