package main;

import java.util.Date;

public class EventType {
private String Id; 
private String Timestamp;
private int EventLogType;
private String UserId = "4c2e5fc8-c27f-4b7a-999f-603b551f1888";
private SystemState SystemState;


public EventType (String id, String timestamp, int eventLogType, String userId, SystemState systemState){
	Id = id;
	Timestamp = timestamp;
	EventLogType = eventLogType;
	UserId = userId;
	SystemState = systemState;
}

public String toString(){
	return "Id: " + Id + "Timestamp: " + Timestamp + "Event Log Type: " + EventLogType + "UserId: " + "SystemState" + SystemState.toString();
}
	
public String getId() {
	return Id;
}

public String getTimeStamp() {
	return Timestamp;
}

public int getEventLogType() {
	return EventLogType;
}

public String getUserId() {
	return UserId;
}

public SystemState getSystemState() {
	return SystemState;
}
}