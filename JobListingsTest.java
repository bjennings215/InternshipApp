import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
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
    public void testHasFirstItemInList() {
        allJobListings.clear();
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc",
                "Create amazing Games!", "Miami", "Florida", "3", "15.50", null, null, null));
        JobListingDataWriter.saveJobListng();
        
        boolean hasWebDevListing = jobListings.haveJobListing("Web Developer");
        assertTrue(hasWebDevListing);
    }

    @Test
    public void testHasLastItemInList() {
        boolean hasGameDevListing = jobListings.haveJobListing("Game Developer");
        assertTrue(hasGameDevListing);
    }

    @Test
    public void testHasJobListingNotInList() {
        boolean hasFakeJobListing = jobListings.haveJobListing("Fake Job");
        assertFalse(hasFakeJobListing);
    }

    @Test
    public void testHasJobListingWithEmpty() {
        boolean hasEmptyJobListing = jobListings.haveJobListing("");
        assertFalse(hasEmptyJobListing);
    }

    @Test
    public void testHasJobListingWithNull() {
        boolean hasNullJobListing = jobListings.haveJobListing(null);
        assertFalse(hasNullJobListing);
    }

    @Test
    public void testGetJobListingByJobTitle() {
        allJobListings.clear();
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc",
                "Create amazing Games!", "Miami", "Florida", "3", "15.50", null, null, null));
        JobListingDataWriter.saveJobListng();
        
        JobListing webDevJobListing = jobListings.getJobListing("Web Developer");
        assertEquals(webDevJobListing.getJobDescription(), "Create amazing websites!");
    }

    @Test
    public void testGetJobListingWithEmpty() {
        JobListing emptyJobListing = jobListings.getJobListing("");
        assertNull(emptyJobListing);
    }

    @Test
    public void testAddingValidJobListing() {
        jobListings.addJob("www.softwareEngineers.com", "Software Engineer", "Software Engineer Inc",
                "Create amazing new software!", "Charlotte", "North Carolina", "3", "9.50", null, null, null);
        assertTrue(jobListings.haveJobListing("Software Engineer"));
    }

    @Test
    public void testAddingSameJobListing() {
        allJobListings.clear();
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc",
                "Create amazing Games!", "Miami", "Florida", "3", "15.50", null, null, null));
        JobListingDataWriter.saveJobListng();
        
        jobListings.addJob("www.webdev.com", "Web Developer", "Web Creation Inc", "Create amazing websites!",
                "Columbia", "South Carolina", "4", "12.50", null, null, null);
        int count = 0;
        for (JobListing jobListing : jobListings.getJobList()) {
            if (jobListing.getJobTitle().equals("Web Developer")) {
                count++;
            }
        }
        assertEquals(1, count);
    }

    @Test
    public void testAddingNewListingAndKeepingOldListing() {
        jobListings.addJob("www.softwareEngineers.com", "Software Engineer", "Software Engineer Inc",
        "Create amazing new software!", "Charlotte", "North Carolina", "3", "9.50", null, null, null);
        assertTrue(jobListings.haveJobListing("Software Engineer") && jobListings.haveJobListing("Web Developer"));
    }

    @Test
    public void testRemovingValidJobListing() {
        jobListings.removeJob("Web Developer");
        assertFalse(jobListings.haveJobListing("Web Developer"));
    }

    @Test
    public void testRemovingInvalidJobListing() {
        jobListings.removeJob("Network Programmer");
        assertFalse(jobListings.haveJobListing("Network Programmer"));
    }

    @Test
    public void testEditingSinglePartOfCurrentJobListing() {
        allJobListings.clear();
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc",
                "Create amazing Games!", "Miami", "Florida", "3", "15.50", null, null, null));
        JobListingDataWriter.saveJobListng();
        
        jobListings.editJob("www.webdev.com", "Web Developer", "Web Creation Inc", "Create amazing websites!",
                "Charleston", "South Carolina", "4", "12.50", null, null, null);
        assertEquals("Charleston", jobListings.getJobListing("Web Developer").getJobCityLocation());
    }

    @Test
    public void testEditingMultiplePartsOfCurrentJobListing() {
        allJobListings.clear();
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc",
                "Create amazing Games!", "Miami", "Florida", "3", "15.50", null, null, null));
        JobListingDataWriter.saveJobListng();
        
        jobListings.editJob("www.webdev.com", "Web Developer", "Web Creation Company",
                "Create the coolest websites ever!", "Charleston", "South Carolina", "3", "17.50", null, null, null);
        boolean sameJobDescription = (jobListings.getJobListing("Web Developer").getJobDescription().equals("Create the coolest websites ever!"));
        boolean sameJobCity = (jobListings.getJobListing("Web Developer").getJobCityLocation().equals("Charleston"));
        assertTrue(sameJobDescription && sameJobCity);
    }
}
