package json;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class Demo_org_json {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		orgJson();
	}
	
	// π”√org.json
	static void orgJson() {
		try{
			String keyValue = "{\"name\":\"xiongdaping\"}";  //key : value
			JSONObject jsonObj = new JSONObject(keyValue);
			
			String name = jsonObj.getString("name");

			jsonObj.put("initial", name.substring(5, name.length()).toUpperCase());

			String[] likes = new String[] { "JavaScript", "Skiing", "Apple Pie" };
			jsonObj.put("likes", Arrays.toString(likes));

			HashMap<String, String> ingredients = new HashMap<String, String>();
			ingredients.put("apples", "3kg");
			ingredients.put("sugar", "1kg");
			ingredients.put("pastry", "2.4kg");
			ingredients.put("bestEaten", "outdoors");
			jsonObj.put("ingredients", ingredients);
			
//			String person ="[ { \"firstName\": \"Brett\", \"lastName\":\"McLaughlin\", \"email\": \"aaaa\" },{ \"firstName\": \"Jason\", \"lastName\":\"Hunter\", \"email\": \"bbbb\" },{ \"firstName\": \"Elliotte\", \"lastName\":\"Harold\", \"email\": \"cccc\" }]" ;
//			jsonObj.put("person", person);
			
			
			System.out.println(jsonObj);
//			System.out.println(jsonObj);
		}catch(JSONException e){
			e.printStackTrace();
		}
		

		
	}

}
