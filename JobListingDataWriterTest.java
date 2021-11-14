import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class JobListingDataWriterTest {
    private JobListings jobListings = JobListings.getInstance();
	private ArrayList<JobListing> jobList = jobListings.getJobList();

	
	@BeforeEach
	public void setup() {
		JobListings.getInstance().getJobList().clear();
        JobListingDataWriter.saveJobListng();;
	}

    @AfterEach
	public void tearDown() {
		JobListings.getInstance().getJobList().clear();
		JobListingDataWriter.saveJobListng();
	}

    @Test
	public void testWritingZeroUsers() {
		jobList = JobListingDataLoader.InputJobListing();
		assertEquals(0, jobList.size());
	}

    @Test
    public void testWritingEmptyFields(){
        String link="";
        String jobTitle="";
        String jobCompany="";
        String jobDescription="";
        String jobCityLocation="";
        String jobStateLocation="";
        String numofMonths="";
        String jobWagePerHour="";
        ArrayList<String> jobSkills= new ArrayList<>();
        ArrayList<Student> studentsApplied=new ArrayList<>();
        String jobExpDate="";
        jobList.add(new JobListing(link, jobTitle,  jobCompany,  jobDescription,jobCityLocation, 
        jobStateLocation, numofMonths, jobWagePerHour, jobSkills,  studentsApplied,  jobExpDate));
        JobListingDataWriter.saveJobListng();
         assertEquals("", JobListingDataLoader.InputJobListing().get(0).getLink());
    }

    @Test
    public void testWritingAllFields() {
        String link="www.newjob.com";
        String jobTitle="work";
        String jobCompany="the company";
        String jobDescription="working hard";
        String jobCityLocation="columbia";
        String jobStateLocation="South Carolina";
        String numofMonths="32 months";
        String jobWagePerHour="13";
        ArrayList<String> jobSkills= new ArrayList<>();
        jobSkills.add("working hard");
        ArrayList<Student> studentsApplied=new ArrayList<>();
        String jobExpDate="10/30/2022";
        jobList.add(new JobListing(link, jobTitle,  jobCompany,  jobDescription,jobCityLocation, 
        jobStateLocation, numofMonths, jobWagePerHour, jobSkills,  studentsApplied,  jobExpDate));
         JobListingDataWriter.saveJobListng();
         assertEquals("www.newjob.com", JobListingDataLoader.InputJobListing().get(0).getLink());
    }

    @Test
	void testWritingTwoDifferentJobs() {
        String link="www.newjob.com";
        String jobTitle="work";
        String jobCompany="the company";
        String jobDescription="working hard";
        String jobCityLocation="columbia";
        String jobStateLocation="South Carolina";
        String numofMonths="32 months";
        String jobWagePerHour="13";
        ArrayList<String> jobSkills= new ArrayList<>();
        jobSkills.add("working hard");
        ArrayList<Student> studentsApplied=new ArrayList<>();
        String jobExpDate="10/30/2022";
        jobList.add(new JobListing(link, jobTitle,  jobCompany,  jobDescription,jobCityLocation, 
        jobStateLocation, numofMonths, jobWagePerHour, jobSkills,  studentsApplied,  jobExpDate));
        link="www.oldjob.com";
        jobTitle="nowork";
        jobCompany="the noncompany";
        jobDescription="hardly working";
        jobCityLocation="columbia";
        jobStateLocation="South Carolina";
        numofMonths="20 months";
        jobWagePerHour="13";
        jobSkills= new ArrayList<>();
        jobSkills.add("working hard");
        studentsApplied=new ArrayList<>();
        jobExpDate="10/30/2022";
        jobList.add(new JobListing(link, jobTitle,  jobCompany,  jobDescription,jobCityLocation, 
        jobStateLocation, numofMonths, jobWagePerHour, jobSkills,  studentsApplied,  jobExpDate));
         JobListingDataWriter.saveJobListng();
         assertEquals("www.oldjob.com", JobListingDataLoader.InputJobListing().get(0).getLink());
	}

    @Test
    public void testWritingMultipleSkills() {
        String link="";
        String jobTitle="";
        String jobCompany="";
        String jobDescription="";
        String jobCityLocation="";
        String jobStateLocation="";
        String numofMonths="";
        String jobWagePerHour="";
        ArrayList<String> jobSkills= new ArrayList<>();
        jobSkills.add("working");
        jobSkills.add("cleaning");
        ArrayList<Student> studentsApplied=new ArrayList<>();
        String jobExpDate="";
        jobList.add(new JobListing(link, jobTitle,  jobCompany,  jobDescription,jobCityLocation, 
        jobStateLocation, numofMonths, jobWagePerHour, jobSkills,  studentsApplied,  jobExpDate));
         DataWriter.saveUsers();
        ArrayList testJobSkills = new ArrayList<String>();
        testJobSkills.add("working");
        testJobSkills.add("cleaning");
         assertLinesMatch(testJobSkills, JobListingDataLoader.InputJobListing().get(0).getJobSkills());
        
    }

}
