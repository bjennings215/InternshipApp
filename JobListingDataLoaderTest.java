import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JobListingDataLoaderTest {
	private JobListings jobListings = JobListings.getInstance();
	private ArrayList<JobListing> jobListingsList = jobListings.getJobList();
	
	@BeforeEach
	public void setup() {
		jobListingsList.clear();
		Student student = null;
        ArrayList<String> jobSkills = new ArrayList<>();
			jobSkills.add("java");
		ArrayList<Student> studentsApplied = new ArrayList<>();
			studentsApplied.add(student);

        jobListingsList.add(new JobListing("", "Analyst", "Monsters Inc", "Programmer", "Columbia",
		"SC", "12", "12", jobSkills, studentsApplied, "1/1/22"));
		jobListingsList.add(new JobListing("", "Analyst", "Monsters Inc 2", "Programmer", "Columbia",
		"SC", "12", "12", jobSkills, studentsApplied, "1/1/22"));
		JobListingDataWriter.saveJobListng();
	}
	
	@AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		JobListingDataWriter.saveJobListng();
	}
	
	
	@Test
	void testGetUsersSize() {
		jobListingsList = JobListingDataLoader.InputJobListing();
		assertEquals(2, jobListingsList.size());
	}

	@Test
	void testGetUsersSizeZero() {
		JobListings.getInstance().getJobList().clear();
		JobListingDataWriter.saveJobListng();
		assertEquals(0, jobListingsList.size());
	}
	
	@Test
	void testGetUserFirstUserName() {
		jobListingsList = JobListingDataLoader.InputJobListing();
		assertEquals("Monsters Inc", jobListingsList.get(0).getJobCompany());
	}
}