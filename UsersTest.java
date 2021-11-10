import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

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
    void testHasFirstItemInList() {
        boolean hasDave = users.haveUser("davejones");
        assertTrue(hasDave);
    }

    @Test
    void testHasLastItemInList() {
        boolean hasAmy = users.haveUser("amyLove18");
        assertTrue(hasAmy);
    }

    @Test
    void testHaveUserNotInlist() {
        boolean hasDerek = users.haveUser("derekp");
        assertFalse(hasDerek);
    }

    @Test
    void testHaveUserWithEmpty() {
        boolean hasEmpty = users.haveUser("");
        assertFalse(hasEmpty);
    }

    @Test
    void testHaveUserWithNull() {
        boolean hasNull = users.haveUser(null);
        assertFalse(hasNull);
    }

    @Test
    void testGetUserUsername() {
        User getDave = users.getUser("daveJones");
        assertEquals(getDave,
                new User("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                        "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null,
                        null, null, null, null, null));
    }

    @Test
    void testGetUserwithEmpty() {
        User getEmpty = users.getUser("");
        assertNull(getEmpty);
    }

    @Test
    void testAddingBrandNewUser() {
        users.addUser("mikesmith22", "mikespassword", "Student", "USC", null, "Mike", "Smith", "msmith@email.sc.edu",
                "987-654-3210", "Computer Science", "Statistics", null, "Junior", "3.1", null, null, "Unemployed", null,
                null, null, null, null, null);
        assertTrue(users.haveUser("mikesmith22"));
    }

    @Test
    void testAddingSameUser() {
        users.addUser("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null);
        int count = 0;
        for (User user : users.getUsers()) {
            if (user.getUsername().equals("daveJones")) {
                count++;
            }
        }
        assertTrue(count == 1);
    }

    @Test
    void testRemovingCurrentUser() {
        users.removeUser("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null);
        assertFalse(users.haveUser("davejones"));
    }

    @Test
    void testRemovingFakeUser() {
        int beginningSize = users.getUsers().size();
        users.removeUser("mikesmith22", "mikespassword", "Student", "USC", null, "Mike", "Smith", "msmith@email.sc.edu",
                "987-654-3210", "Computer Science", "Statistics", null, "Junior", "3.1", null, null, "Unemployed", null,
                null, null, null, null, null);
        assertEquals(beginningSize, users.getUsers().size());
    }

    @Test
    void testEditingSinglePartOfCurrentUser() {
        users.editUser("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
        "123-456-7890", "Computer Science", null, null, "Senior", "2.2", null, null, "Unemployed", null, null,
        null, null, null, null);
        assertEquals(users.getUser("davejones").getGPA(), "2.2");
    }

    @Test
    void testEditingMultiplePartsOfCurrentUser() {
        users.editUser("davejones", "davidjones1000", "Student", "USC", null, "David", "Jones", "davidjones@gmail.com",
        "808-808-8008", "Computer Science", null, null, "Senior", "2.2", null, null, "Employed", null, null,
        null, null, null, null);
        assertEquals(users.getUser("davejones"), new User("davejones", "davidjones1000", "Student", "USC", null, "David", "Jones", "davidjones@gmail.com",
        "808-808-8008", "Computer Science", null, null, "Senior", "2.2", null, null, "Employed", null, null,
        null, null, null, null));
    }

    @Test
    void testEditingDoesNotMakeDuplicateUsers() {
        int count = users.getUsers().size();
        users.editUser("davejonesEDITED", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
        "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
        null, null, null, null);
        assertEquals(count, users.getUsers().size());
    }

    
}
