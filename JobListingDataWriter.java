import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class JobListingDataWriter extends JobListingDataConstants {
    
    public static void saveJobListng() {
        JobListings jobListings = JobListings.getInstance();
		ArrayList<JobListing> jobList = jobListings.getJobList();
		JSONArray jsonjobListings = new JSONArray();
		
		// get  current JSON objects
		for(int i=0; i< jobList.size(); i++) {
			jsonjobListings.add(getJobListingJSON(jobList.get(i)));
		}
		
		//Write to JSON file
        try (FileWriter file = new FileWriter(JOB_FILE_STRING)) {
 
            file.write(jsonjobListings.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    //set JSON object elements
    public static JSONObject getJobListingJSON(JobListing jobListing) {
		JSONObject jobDetails = new JSONObject();
		jobDetails.put(JOB_ID, jobListing.getJobID().toString());
		jobDetails.put(JOB_TITLE_STRING, jobListing.getJobTitle());
		jobDetails.put(JOB_COMPANY_STRING, jobListing.getJobCompany());
		jobDetails.put(JOB_DESC_STRING, jobListing.getJobDescription());
		jobDetails.put(JOB_LOCATION_STRING, jobListing.getJobCityLocation());
		jobDetails.put(JOB_NUMOFMONTHS_STRING, jobListing.getNumOfMonths());
		jobDetails.put(JOB_LINK_STRING, jobListing.getLink());
		jobDetails.put(JOB_WAGE_STRING, jobListing.getWagePerHour());
		jobDetails.put(JOB_REVIEW_MAJOR_STRING, jobListing.getJobReviews());
		jobDetails.put(JOB_STUDENTS_APPLIED_STRING, jobListing.getStudentsApplied());
		jobDetails.put(JOB_JOBEXPDATE_STRING, jobListing.getJobExpDate());
		
        return jobDetails;
	}
}


