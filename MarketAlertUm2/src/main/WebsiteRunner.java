package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class WebsiteRunner {

	
private static final String user_ID = "4c2e5fc8-c27f-4b7a-999f-603b551f1888";
private static ArrayList<EventType> eventsOnSystem = new ArrayList<EventType>();
private static String timeStamp;
private static int numOfAlerts;
	
public static void getRequest() throws IOException, JSONException {
		
	URL url = new URL("https://api.marketalertum.com/EventsLog/" + user_ID);
	HttpURLConnection con = (HttpURLConnection) url.openConnection();
	con.setRequestMethod("GET");
	con.connect();
	
	int code = con.getResponseCode();
		
	if (code == HttpURLConnection.HTTP_OK) 
	{
		BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
     while ((inputLine = in.readLine()) != null) {
     		response.append(inputLine);
     	}
     		in.close();
     
     //Read JSON response and print
     JSONArray jsonA = new JSONArray(response.toString());
     
     for( int i =0; i<jsonA.length(); i++) 
     	{
			 JSONObject JSONobj = jsonA.getJSONObject(i);
			 int eventLogType = JSONobj.getInt("eventLogType");
			 String id = JSONobj.getString("id");
			 String timestamp = JSONobj.getString("timestamp");
			 String userId = JSONobj.getString("userId");
			 
			 
			 String userId2 = JSONobj.getJSONObject("systemState").getString("userId");
			 Boolean loggedIn = JSONobj.getJSONObject("systemState").getBoolean("loggedIn");
			 JSONArray alerts = JSONobj.getJSONObject("systemState").getJSONArray("alerts");
			 
			 eventsOnSystem.add(new EventType(id, timestamp, eventLogType, userId, new SystemState(userId2, loggedIn, alerts)));
			 
     	}
     
	} else {
		System.out.println("The GET request failed");
	}
}
	
	public void runMethod() throws IOException, JSONException {
		
		while(true){
			
			eventsOnSystem.clear();
			getRequest();
			
			//To include switch case of eventLogTypes.
			
			for (int i =0; i<eventsOnSystem.size();i++)
			{
				
				//Getting the type of event from the get method in EventType Class.
				int typeOfEvent = eventsOnSystem.get(i).getEventLogType();
				
				timeStamp = eventsOnSystem.get(i).getTimeStamp();
				
				numOfAlerts = eventsOnSystem.get(i).getSystemState().getAlerts().length();
				
				switch(typeOfEvent)
				{	
				
				//eventLogType 0 = AlertCreated.
					case 0:
						AlertCreated();
						break;
				//eventLogType 1 = AlertsDeleted.		
					case 1:
						AlertsDeleted();
						break;
					case 5:
						UserValidLogIn();
						break;
				//eventLogType 6 = UserLoggedOut.		
					case 6:
						UserLoggedOut();
						break;
				//eventLogType 7 = UserViewedAlerts.		
					case 7:
						UserViewedAlerts();
						break;
			}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e){
					System.out.println("");
				}
		}
	}			
}

private static void AlertCreated() {
		System.out.println("An Alert has been created at: " + timeStamp);
	}

private static void AlertsDeleted() {

		System.out.println("Alerts have been deleted at: " + timeStamp);
	}

private static void UserViewedAlerts() {
	
	if (numOfAlerts == 0)
		System.out.println("The User is viewing " + numOfAlerts +" Alerts at:  " + timeStamp);
	else if(numOfAlerts > 5)
		System.out.println("The User is viewing " + numOfAlerts +" Alerts at: " + timeStamp + ", Alert Limit Exceeded.");
	else
		System.out.println("The User is viewing the created " + numOfAlerts +" Alerts at: " + timeStamp + ", Alert Limit <=5.");
}

private static void UserLoggedOut() {
	System.out.println("The User logged out at: " + timeStamp);
}

private static void UserValidLogIn() {
	System.out.println("The User has logged in at time: " + timeStamp);
} 

//Cannot use this method but keep it.
private static void UserInvalidLogin() { 
	System.out.println("The User inputted an Invalid userID " + timeStamp);
}

public static void main(String args[]) throws IOException, JSONException 
{
		
		WebsiteRunner run = new WebsiteRunner();
		
		for (int i = 0; i<eventsOnSystem.size();i++)
		{
			System.out.println(eventsOnSystem.get(i).toString());
		}
		
		run.runMethod();
	}
}

