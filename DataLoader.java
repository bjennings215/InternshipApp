import java.io.*;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoader extends UserDataContants {

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

                users.add(new User(username, password));
            }
            return users;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
