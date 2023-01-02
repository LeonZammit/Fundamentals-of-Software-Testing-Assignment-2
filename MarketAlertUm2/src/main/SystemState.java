package main;

import java.util.ArrayList;

import org.json.JSONArray;

public class SystemState {
	
private String UserId = "4c2e5fc8-c27f-4b7a-999f-603b551f1888";
private boolean LoggedIn;
private JSONArray Alerts; 

public SystemState(String userId, boolean loggedIn, JSONArray alerts){
	UserId = userId;
	LoggedIn = loggedIn;
	Alerts = alerts; 
}

public String toString() {
	
	return "UserId: " + UserId + "LoggedIn: " + LoggedIn + "Alerts: " + Alerts.toString();
}
//www.javatpoint.com/understanding-toString()-method https://www.tabnine.com/code/java/methods/org.json.JSONArray/getJSONObject https://chillyfacts.com/java-send-http-getpost-request-and-read-json-response/

	public String getUserId(){
		return UserId;
	}
	
	public boolean getLoggedIn(){
		return LoggedIn;
	}
	
	public JSONArray getAlerts() {
		return Alerts;
	}
}




