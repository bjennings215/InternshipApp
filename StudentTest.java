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

public class StudentTest {

    private Student student;
    private JobListings jobListings = JobListings.getInstance();
    private ArrayList<JobListing> allJobListings = jobListings.getJobList();

    @BeforeEach
    public void setup() {
        this.student = new Student("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null);
        allJobListings.clear();
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc",
                "Create amazing Games!", "Miami", "Florida", "3", "15.50", null, null, null));
        allJobListings.add(new JobListing("www.softwareengineers.com", "Software Engineer", "Software Engineering Inc",
                "Design great software!", "Charleston", "South Carolina", "4", "9.50", null, null, null));
        JobListingDataWriter.saveJobListng();
    }

    @AfterEach
    public void tearDown() {
        JobListings.getInstance().getJobList().clear();
        JobListingDataWriter.saveJobListng();
    }

    @Test
    public void testFilteringByTitle() {
        this.student = new Student("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null);
        ArrayList<JobListing> filteredJobs = student.filteredByTitle(allJobListings, "Web Developer");
        assertTrue(filteredJobs.size() == 1);
    }

    @Test
    public void testFilteringByWage() {
        this.student = new Student("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null);
        allJobListings.clear();
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc",
                "Create amazing Games!", "Miami", "Florida", "3", "15.50", null, null, null));
        allJobListings.add(new JobListing("www.softwareengineers.com", "Software Engineer", "Software Engineering Inc",
                "Design great software!", "Charleston", "South Carolina", "4", "9.50", null, null, null));
        JobListingDataWriter.saveJobListng();
        ArrayList<JobListing> filteredJobs = student.filteredByWage(allJobListings, 10.00);
        assertEquals(2, filteredJobs.size());
    }

    @Test
    public void testFilteringByCompany() {
        this.student = new Student("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null);
        allJobListings.clear();
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc",
                "Create amazing Games!", "Miami", "Florida", "3", "15.50", null, null, null));
        allJobListings.add(new JobListing("www.softwareengineers.com", "Software Engineer", "Software Engineering Inc",
                "Design great software!", "Charleston", "South Carolina", "4", "9.50", null, null, null));
        JobListingDataWriter.saveJobListng();
        ArrayList<JobListing> filteredJobs = student.filteredByCompany(allJobListings, "Web Creation Inc");
        assertEquals(1, filteredJobs.size());
    }

    @Test
    public void testFilteringByCity() {
        this.student = new Student("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null);
        this.student = new Student("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null);
        allJobListings.clear();
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc",
                "Create amazing Games!", "Miami", "Florida", "3", "15.50", null, null, null));
        allJobListings.add(new JobListing("www.softwareengineers.com", "Software Engineer", "Software Engineering Inc",
                "Design great software!", "Charleston", "South Carolina", "4", "9.50", null, null, null));
        JobListingDataWriter.saveJobListng();
        ArrayList<JobListing> filteredJobs = student.filteredByCity(allJobListings, "Charleston");
        assertTrue(filteredJobs.size() == 1);
    }

    @Test
    public void testFilteringByState() {
        this.student = new Student("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null);
        allJobListings.clear();
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", null, null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc",
                "Create amazing Games!", "Miami", "Florida", "3", "15.50", null, null, null));
        allJobListings.add(new JobListing("www.softwareengineers.com", "Software Engineer", "Software Engineering Inc",
                "Design great software!", "Charleston", "South Carolina", "4", "9.50", null, null, null));
        JobListingDataWriter.saveJobListng();
        ArrayList<JobListing> filteredJobs = student.filteredByState(allJobListings, "South Carolina");
        assertTrue(filteredJobs.size() == 2);
    }

    @Test
    public void testFilteringBySkill() {
        this.student = new Student("davejones", "dmjones1", "Student", "USC", null, "Dave", "Jones", "djones@gmail.com",
                "123-456-7890", "Computer Science", null, null, "Senior", "3.5", null, null, "Unemployed", null, null,
                null, null, null, null);

        ArrayList<String> jobOneSkills = new ArrayList<>();
        ArrayList<String> jobTwoSkills = new ArrayList<>();
        ArrayList<String> jobThreeSkills = new ArrayList<>();

        jobOneSkills.add("JavaScript");
        jobOneSkills.add("HTML");
        jobTwoSkills.add("Python");
        jobTwoSkills.add("Level Design");
        jobThreeSkills.add("Java");
        jobThreeSkills.add("JavaScript");

        allJobListings.clear();
        allJobListings.add(new JobListing("www.webdev.com", "Web Developer", "Web Creation Inc",
                "Create amazing websites!", "Columbia", "South Carolina", "4", "12.50", jobOneSkills , null, null));
        allJobListings.add(new JobListing("www.newgamedev.com", "Game Developer", "Game Creation Inc",
                "Create amazing Games!", "Miami", "Florida", "3", "15.50", jobTwoSkills, null, null));
        allJobListings.add(new JobListing("www.softwareengineers.com", "Software Engineer", "Software Engineering Inc",
                "Design great software!", "Charleston", "South Carolina", "4", "9.50", jobThreeSkills, null, null));
        JobListingDataWriter.saveJobListng();
        ArrayList<JobListing> filteredJobs = student.filteredBySkill(allJobListings, "JavaScript");
        assertTrue(filteredJobs.size() == 2);
    }

}
