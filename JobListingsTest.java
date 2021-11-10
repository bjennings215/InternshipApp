import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class JobListingsTest {
    
    private JobListings jobListings = JobListings.getInstance();
    private ArrayList<JobListing> allJobListings = jobListings.getJobList();

    @BeforeEach
    public void setup() {
        allJobListings.clear();
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc", "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc", "Create amazing Games!", "Miami", "Florida", "3", "15.50", null, null, null));
        JobListingDataWriter.saveJobListng();
    }

    @AfterEach
    public void tearDown() {
        JobListings.getInstance().getJobList().clear();
        JobListingDataWriter.saveJobListng();
    }

    @Test
    void testHasFirstItemInList() {
        boolean hasWebDevListing = jobListings.haveJobListing("Web Developer");
        assertTrue(hasWebDevListing);
    }

    @Test
    void testHasLastItemInList() {
        boolean hasGameDevListing = jobListings.haveJobListing("Game Developer");
        assertTrue(hasGameDevListing);
    }

    @Test
    void testHasJobListingNotInList() {
        boolean hasFakeJobListing = jobListings.haveJobListing("Software Engineer");
        assertFalse(hasFakeJobListing);
    }

    @Test 
    void testHasJobListingWithEmpty() {
        boolean hasEmptyJobListing = jobListings.haveJobListing("");
        assertFalse(hasEmptyJobListing);
    }

    
}
