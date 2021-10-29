import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends UserDataContants {

    //Load Users from JSON File
    public static ArrayList<User> InputUsers() {
        ArrayList<User> users = new ArrayList<User>();


        try {
            FileReader reader = new FileReader(USER_FILE_STRING);
            JSONParser parser = new JSONParser();
            JSONArray UsersJSON = (JSONArray) new JSONParser().parse(reader);

            for(int i = 0; i <UsersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject)UsersJSON.get(i);
                String username = (String) userJSON.get(USER_USERNAME_STRING);
                String password = (String) userJSON.get(USER_PASSWORD_STRING);
                String accounttype = (String) userJSON.get(USER_ACC_TYPE_STRING);
                String firstname = (String) userJSON.get(USER_FIRST_NAME_STRING);
                String lastname = (String) userJSON.get(USER_LAST_NAME_STRING);
                String email = (String) userJSON.get(USER_EMAIL_STRING);
                String phoneNumber = (String) userJSON.get(USER_PHONE_NUMBER_STRING);
                String school = (String) userJSON.get(USER_RESUME_SCHOOL_STRING);
                String major = (String) userJSON.get(USER_RESUME_MAJOR_STRING);
                String minor = (String) userJSON.get(USER_RESUME_MINOR_STRING);
                String concentration = (String) userJSON.get(USER_RESUME_CONC_STRING);
                String gradeLevel = (String) userJSON.get(USER_RESUME_GL_STRING);
                String gpa = (String) userJSON.get(USER_RESUME_GPA_STRING);
                JSONArray skills = (JSONArray) userJSON.get(USER_RESUME_SKILLS_STRING);
                JSONArray extraCurr = (JSONArray) userJSON.get(USER_RESUME_EC_STRING);
                String status = (String) userJSON.get(USER_RESUME_STATUS_STRING);
                //JSONArray experiences = (JSONArray) userJSON.get(USER_RESUME_EXP_STRING);
                    String jobOccupation = (String) userJSON.get(USER_RESUME_JOB_OCCUPATION_STRING);
                    String jobtype = (String) userJSON.get(USER_RESUME_JOB_TYPE_STRING);
                    String prevExp = (String) userJSON.get(USER_RESUME_PREVEXP_STRING);
                    String explength = (String) userJSON.get(USER_RESUME_EXPLENGTH_STRING);
                    JSONArray jobdesc = (JSONArray) userJSON.get(USER_RESUME_JOBDESC_STRING);
                
                String company = (String) userJSON.get(USER_EMPLOYER_COMPANY_STRING);



                users.add(new User(username,password,accounttype,school,company,firstname,lastname,email,phoneNumber,major,minor,concentration,
                gradeLevel,gpa,skills,extraCurr,status,jobOccupation,jobtype,prevExp,explength,jobdesc));
            }
            return users;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static ArrayList<JobListing> InputJobListing() {
        ArrayList<JobListing> jobListings = new ArrayList<JobListing>();
        return jobListings;
    }
}
