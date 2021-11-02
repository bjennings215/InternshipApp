import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

/**
 * @author Adam, Brandon, Brady, Esam
 */
public class DataWriter extends UserDataContants {

	/**
	 * Save users to JSON file
	 */
    public static void saveUsers() {
        Users users = Users.getInstance();
		ArrayList<User> userList = users.getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		// get  current JSON objects
		for(int i=0; i< userList.size(); i++) {
			jsonUsers.add(getUserJSON(userList.get(i)));
		}
		
		//Write to JSON file
        try (FileWriter file = new FileWriter(USER_FILE_STRING)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    /**
	 * set JSON object elements
	 * @param userUser being retrieved
	 * @return user JSON object
	 */
    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, user.getUuid().toString());
		userDetails.put(USER_USERNAME_STRING, user.getUsername());
		userDetails.put(USER_PASSWORD_STRING, user.getPassword());
		userDetails.put(USER_ACC_TYPE_STRING, user.getAccounttype());
		userDetails.put(USER_FIRST_NAME_STRING, user.getFirstName());
		userDetails.put(USER_LAST_NAME_STRING, user.getLastName());
		userDetails.put(USER_EMAIL_STRING, user.getEmail());
		userDetails.put(USER_PHONE_NUMBER_STRING, user.getPhoneNumber());
		userDetails.put(USER_RESUME_SCHOOL_STRING, user.getSchool());
		userDetails.put(USER_RESUME_MAJOR_STRING, user.getMajor());
		userDetails.put(USER_RESUME_MINOR_STRING, user.getMinor());
		userDetails.put(USER_RESUME_CONC_STRING, user.getConcentation());
		userDetails.put(USER_RESUME_GL_STRING, user.getGradeLevel());
		userDetails.put(USER_RESUME_GPA_STRING, user.getGPA());
		userDetails.put(USER_RESUME_SKILLS_STRING, user.getSkills());
		userDetails.put(USER_RESUME_EC_STRING, user.getExtracurr());
		userDetails.put(USER_RESUME_STATUS_STRING, user.getStatus());
		JSONArray experiences = new JSONArray();
		Map m = new LinkedHashMap(5);
		m.put(USER_RESUME_JOB_OCCUPATION_STRING, user.getjobOccupation());
		m.put(USER_RESUME_JOB_TYPE_STRING, user.getjobType());
		m.put(USER_RESUME_PREVEXP_STRING, user.getPrevExp());
		m.put(USER_RESUME_EXPLENGTH_STRING, user.getExpLength());
		m.put(USER_RESUME_JOBDESC_STRING, user.getJobDesc());
		experiences.add(m);
		userDetails.put(USER_RESUME_EXP_STRING,experiences);
		userDetails.put(USER_EMPLOYER_COMPANY_STRING, user.getCompany());
		
        return userDetails;
	}
}
