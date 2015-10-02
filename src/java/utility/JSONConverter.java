package utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import entity.Person;
import java.util.List;

/**
 * @author Tobias Jacobsen
 */
public class JSONConverter {

    static Gson gson = new Gson();

    //{"fName":"Tobias","lname":"Jacobsen","phone":"31203083","id:0"}
    public static Person getPersonFromJson(String js) {
        return null;
    }

    public static String getJSONFromPerson(Person p) {
        return gson.toJson(p);
    }

    public static String getJSONFromPerson(List<Person> persons) {
        return "";
    }
}
