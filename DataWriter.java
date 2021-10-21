import java.util.ArrayList;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataWriter extends UserDataContants {

    public static void saveUsers() {
        Users users = Users.getInstance();
		ArrayList<User> userList = users.getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		// get  curretn JSON objects
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

    //set JSON object elements
    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
		userDetails.put(USER_ID, user.getUuid().toString());
		userDetails.put(USER_USERNAME_STRING, user.getUsername());
		userDetails.put(USER_PASSWORD_STRING, user.getPassword());
		userDetails.put(USER_ADMIN_ACC_STRING, user.getAccounttype());
		userDetails.put(USER_EMP_ACC_STRING, user.getAccounttype());
        
        return userDetails;
	}
}
