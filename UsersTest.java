import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class UsersTest {

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

    }

}
