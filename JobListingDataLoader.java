import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;
public class JobListingDataLoader extends JobListingDataConstants{
    public static ArrayList<JobListing> InputJobListing() {
        ArrayList<JobListing> jobListings = new ArrayList<JobListing>();
        
        try {
            FileReader reader2 = new FileReader(JOB_FILE_STRING);
            JSONParser parser2 = new JSONParser();
            JSONArray JobListingJSON = (JSONArray) new JSONParser().parse(reader2);

            for(int i = 0; i <JobListingJSON.size(); i++) {
                JSONObject jobListingJSON = (JSONObject)JobListingJSON.get(i);
                String jobTitle  = (String) jobListingJSON.get(JOB_TITLE_STRING);
                String link = (String) jobListingJSON.get(JOB_LINK_STRING);
                String jobCompany = (String) jobListingJSON.get(JOB_COMPANY_STRING);
                String jobDescription = (String) jobListingJSON.get(JOB_DESC_STRING);
                String jobCityLocation = (String) jobListingJSON.get(JOB_CITY_LOCATION_STRING);
                String jobStateLocation = (String) jobListingJSON.get(JOB_STATE_LOCATION_STRING);
                String numofMonths = (String) jobListingJSON.get(JOB_NUMOFMONTHS_STRING);
                String jobWagePerHour = (String) jobListingJSON.get(JOB_WAGE_STRING);
                JSONArray jobSkills  = (JSONArray) jobListingJSON.get(JOB_SKILLS_MAJOR_STRING);
                JSONArray studentsApplied = (JSONArray) jobListingJSON.get(JOB_STUDENTS_APPLIED_STRING);
                String jobExpDate = (String) jobListingJSON.get(JOB_JOBEXPDATE_STRING);



                jobListings.add(new JobListing(link, jobTitle,  jobCompany,  jobDescription,jobCityLocation, 
                jobStateLocation, numofMonths, jobWagePerHour, jobSkills,  studentsApplied,  jobExpDate));
            }
            return jobListings;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
