import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNull;
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
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc",
                "Create amazing Games!", "Miami", "Florida", "3", "15.50", null, null, null));
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

    @Test
    void testHasJobListingWithNull() {
        boolean hasNullJobListing = jobListings.haveJobListing(null);
        assertFalse(hasNullJobListing);
    }

    @Test
    void testGetJobListingByJobTitle() {
        JobListing webDevJobListing = jobListings.getJobListing("Web Developer");
        assertEquals(webDevJobListing, new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
    }

    @Test
    void testGetJobListingWithEmpty() {
        JobListing emptyJobListing = jobListings.getJobListing("");
        assertNull(emptyJobListing);
    }

    @Test
    void testAddingValidJobListing() {
        jobListings.addJob("www.softwareEngineers.com", "Software Engineer", "Software Engineer Inc",
                "Create amazing new software!", "Charlotte", "North Carolina", "3", "9.50", null, null, null);
        assertTrue(jobListings.haveJobListing("Software Engineer"));
    }

    @Test
    void testAddingSameJobListing() {
        jobListings.addJob("www.webdev.com", "Web Developer", "Web Creation Inc", "Create amazing websites!",
                "Columbia", "South Carolina", "4", "12.50", null, null, null);
        ArrayList<JobListing> returnedListings = new ArrayList<>();
        for (JobListing jobListing : jobListings.getJobList()) {
            if (jobListing.getJobTitle().equals("Web Developer")) {
                returnedListings.add(jobListing);
            }
        }
        assertTrue(returnedListings.size() == 1);
    }

    @Test
    void testRemovingValidJobListing() {
        jobListings.removeJob("Web Developer");
        assertFalse(jobListings.haveJobListing("Web Developer"));
    }

    @Test
    void testRemovingInvalidJobListing() {
        jobListings.removeJob("Network Programmer");
        assertFalse(jobListings.haveJobListing("Network Programmer"));
    }

    @Test
    void testEditingSinglePartOfCurrentJobListing() {
        jobListings.editJob("www.webdev.com", "Web Developer", "Web Creation Inc", "Create amazing websites!",
                "Charleston", "South Carolina", "4", "12.50", null, null, null);
        assertEquals("Charleston", jobListings.getJobListing("Web Developer").getJobCityLocation());
    }

    @Test
    void testEditingMultiplePartsOfCurrentJobListing() {
        jobListings.editJob("www.webdev.com", "Web Developer", "Web Creation Company",
                "Create the coolest websites ever!", "Charleston", "South Carolina", "3", "17.50", null, null, null);
        assertEquals(jobListings.getJobListing("Web Developer"), new JobListing("www.webdev.com", "Web Developer", "Web Creation Company",
                        "Create the coolest websites ever!", "Charleston", "South Carolina", "3", "17.50", null, null,
                        null));
    }
}
