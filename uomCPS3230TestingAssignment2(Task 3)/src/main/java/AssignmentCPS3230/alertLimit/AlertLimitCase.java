package AssignmentCPS3230.alertLimit;

public class AlertLimitCase {

    private int numOfAlerts =0;

    public void AlertCreated() {
        numOfAlerts++;
    }

    public int getNumberOfAlerts() {
        return numOfAlerts;
    }

    public int AlertsDeleted() {
        return numOfAlerts = 0;
    }

    public boolean isNumOfAlertsEmpty() {
        if(numOfAlerts == 0){
            return true;
        }else
            return false;
    }

    public boolean UserViewedAlerts() {
        if(numOfAlerts <= 5){
            return true;
        }else {
            return false;
        }
    }
}
