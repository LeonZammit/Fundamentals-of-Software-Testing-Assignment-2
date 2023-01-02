package AssignmentCPS3230.alertLimit;

import AssignmentCPS3230.alertLimit.enums.alertLimitStateEnum;
import AssignmentCPS3230.website.MarketAlertUmSiteModelTest;
import javafx.scene.control.Alert;
import junit.framework.Assert;
import nz.ac.waikato.modeljunit.*;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Test;

import java.util.Random;

public class alertLimitModelTest implements FsmModel {

    private int numOfAlerts = 0;
    private int temp =0;

    AlertLimitCase sut = new AlertLimitCase();

    private alertLimitStateEnum stateEnum = alertLimitStateEnum.staticAPI;

    @Override
    public alertLimitStateEnum getState() {
        return stateEnum;
    }

    @Override
    public void reset(boolean b) {
        if (b) {
            sut = new AlertLimitCase();
        }

        numOfAlerts = 0;
        stateEnum = alertLimitStateEnum.staticAPI;
    }

    public boolean AlertCreatedGuard() {
        return getState().equals(alertLimitStateEnum.staticAPI);
    }

    public @Action void AlertCreated(){
        temp = numOfAlerts;
        sut.AlertCreated();

        stateEnum = alertLimitStateEnum.staticAPI;
        numOfAlerts++;

        Assert.assertEquals(temp, sut.getNumberOfAlerts()-1);
    }

        public boolean AlertsDeletedGuard() {
            return getState().equals(alertLimitStateEnum.staticAPI);
        }

        public @Action void AlertsDeleted(){
            sut.AlertsDeleted();

            stateEnum = alertLimitStateEnum.staticAPI;
            numOfAlerts = 0;

            Assert.assertEquals(true, sut.isNumOfAlertsEmpty());
        }

    public boolean UserViewedAlertsGuard(){
        return getState().equals(alertLimitStateEnum.staticAPI);
    }

    public @Action void UserViewedAlerts(){
        boolean result = sut.UserViewedAlerts();

        if(numOfAlerts <= 5){
            stateEnum = alertLimitStateEnum.validNumberOfAlerts;
            Assert.assertTrue(result);
        }else{
            stateEnum = alertLimitStateEnum.invalidNumberOfAlerts;
            Assert.assertFalse(result);
        }
    }

    @Test
    public void Runner() {
        final GreedyTester tester = new GreedyTester(new alertLimitModelTest()); //Mention all the tests that I tried for a 3/3 in states.
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
