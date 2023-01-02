package AssignmentCPS3230.website;

public class MarketAlertUmSite {

    private boolean isLogged = false;


    public boolean UserValidLogin() {
        if(isLogged = true) {
        }
        return true;
    }

    public boolean UserInvalidLogIn() {
        if(isLogged != true){
        }
        return true;
    }

    public boolean UserLoggedOut() {
        if(isLogged = true) {
            isLogged = false;
        }
        return true;
    }

    public boolean UserViewedAlerts() {
        if(isLogged = true){
            return true;
        }else {
            throw new IllegalStateException();
        }
    }

    public boolean logInPressed() {
        if(isLogged){
            isLogged = false;
        }
        return true;
    }

    public boolean alertsPressed() {
        if(isLogged){
            isLogged = false;
        }
        return true;
    }

    public boolean isLoggedStatus() {
        return isLogged;
    }

    public boolean isUserLoggedIn() {
        return isLogged;
    }
}
