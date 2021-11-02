import java.util.ArrayList;

/**
 * @author Adam, Brandon, Brady, Esam
 */
public class Database {
    
    /**
     * retrieves list of users
     * @return the list of users
     */
    public static ArrayList<User> getUsers() {
        return new ArrayList<User>();

    }

    /**
     * retrives list of job listings
     * @return the list of job listings
     */
    public static ArrayList<JobListing> getJobListings() {
        return new ArrayList<JobListing>();
    }
}
