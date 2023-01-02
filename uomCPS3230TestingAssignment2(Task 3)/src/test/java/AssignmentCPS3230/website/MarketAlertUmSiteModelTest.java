package AssignmentCPS3230.website;

import AssignmentCPS3230.website.enums.WebsiteStateEnum;
import junit.framework.Assert;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Test;

import java.util.Random;

public class MarketAlertUmSiteModelTest implements FsmModel {
    MarketAlertUmSite sut = new MarketAlertUmSite();

    private boolean isLogged = false;

    private WebsiteStateEnum stateEnum = WebsiteStateEnum.homePage;

    @Override
    public WebsiteStateEnum getState() {
        return stateEnum;
    }

    @Override
    public void reset(boolean b) {
        if (b) {
            sut = new MarketAlertUmSite();
        }
        isLogged = false;
        stateEnum = WebsiteStateEnum.homePage;
    }

    public boolean UserValidLogInGuard() {
        return getState().equals(WebsiteStateEnum.logInPage);
    }

    public @Action
    void UserValidLogIn() {
        sut.UserValidLogin();

        stateEnum = WebsiteStateEnum.alertsPage;
        isLogged = true;

        Assert.assertEquals(isLogged, sut.isUserLoggedIn());
    }

    public boolean UserInvalidLogInGuard() {
        return getState().equals(WebsiteStateEnum.logInPage);
    }

    public @Action
    void UserInvalidLogIn() {
        sut.UserInvalidLogIn();

        stateEnum = WebsiteStateEnum.logInPage;
        isLogged = false;

        Assert.assertEquals(isLogged, sut.isUserLoggedIn());
    }

    public boolean UserLoggedOutGuard() {
        return getState().equals(WebsiteStateEnum.alertsPage) || getState().equals(WebsiteStateEnum.homePage);
    }

    public @Action
    void UserLoggedOut() {
        sut.UserLoggedOut();

        if (isLogged = true) {
            stateEnum = WebsiteStateEnum.homePage;
            isLogged = false;
            Assert.assertEquals(isLogged, sut.isLoggedStatus());
        }

        stateEnum = WebsiteStateEnum.homePage;
        isLogged = true;


        Assert.assertEquals(false, sut.isUserLoggedIn()); //to check maybe: isUserLoggedOut?
    }


    public boolean UserViewedAlertsGuard() {
        return getState().equals(WebsiteStateEnum.alertsPage);
    }
    public @Action void UserViewedAlerts() {
        sut.UserViewedAlerts();

        stateEnum = WebsiteStateEnum.alertsPage;
        isLogged = true;

        Assert.assertEquals(true, sut.isUserLoggedIn());
    }

    public boolean logInPressedGuard() {
        return getState().equals(WebsiteStateEnum.homePage);
    }

    public @Action void logInPressed() {
        sut.logInPressed();
        stateEnum = WebsiteStateEnum.logInPage;
        isLogged = false;

        Assert.assertEquals(false, sut.isUserLoggedIn());
    }

    public boolean alertsPressedGuard(){
        return getState().equals(WebsiteStateEnum.homePage);
    }

    public @Action void alertsPressed() {
        sut.alertsPressed();
        stateEnum = WebsiteStateEnum.alertsPage;
        isLogged = false;

        Assert.assertEquals(false, sut.isUserLoggedIn());
    }

    @Test
    public void Runner() {
        final GreedyTester tester = new GreedyTester(new MarketAlertUmSiteModelTest());
        tester.setRandom(new Random());
        tester.buildGraph();
        tester.addListener(new StopOnFailureListener());
        tester.addListener("verbose");
        tester.addCoverageMetric(new TransitionPairCoverage());
        tester.addCoverageMetric(new StateCoverage());
        tester.addCoverageMetric(new ActionCoverage());
        tester.generate(500);
        tester.printCoverage();

    }
}


