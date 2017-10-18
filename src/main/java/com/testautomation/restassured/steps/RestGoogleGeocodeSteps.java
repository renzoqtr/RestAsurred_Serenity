package com.testautomation.restassured.steps;


import com.testautomation.restassured.actions.RestGoogleGeocodeActions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.MatcherAssert;

public class RestGoogleGeocodeSteps extends ScenarioSteps{

    private RestGoogleGeocodeActions restGoogleGeocodeActions = new RestGoogleGeocodeActions();

    @Step
    public void requestByAddress(String address) {
        restGoogleGeocodeActions.requestByAddress(address);
    }

    @Step
    public void executeRequest() {
        restGoogleGeocodeActions.executeRequest();
    }

    @Step
    public void checkResponseStatus(String statusCode) {
        String obtainedCode = restGoogleGeocodeActions.getStatusCode();
        MatcherAssert.assertThat("The Status code wasn't the expected\n"
                + "obtained["+obtainedCode+"] expected["+statusCode+"]"
                ,obtainedCode.trim().equals(statusCode.trim()));
    }

    @Step
    public void checkUbication(float longitude, float latitude) {
        float [] obtainedLongLat = restGoogleGeocodeActions.getLongLat();
        boolean checkLongLat = obtainedLongLat[0] == longitude
                && obtainedLongLat[1] == latitude;
        MatcherAssert.assertThat("the longitude and latitude was wrong\n"
                + "Expected[longitude:"+longitude+"|latitude:"+latitude+"]\n"
                + "Obtained[longitude:"+obtainedLongLat[0]+"|latitude:"+obtainedLongLat[1]+"]"
                ,checkLongLat);
    }
}
