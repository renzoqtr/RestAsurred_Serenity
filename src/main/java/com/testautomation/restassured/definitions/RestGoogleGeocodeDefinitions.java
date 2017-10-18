package com.testautomation.restassured.definitions;


import com.testautomation.restassured.steps.RestGoogleGeocodeSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class RestGoogleGeocodeDefinitions {

    @Steps
    private RestGoogleGeocodeSteps restGoogleGeocodeSteps;


    @Given("I have an address '$address'")
    public void requestByAddress(String address){
        restGoogleGeocodeSteps.requestByAddress(address);
    }

    @When("I request google api for geocode with address")
    public void requestGeocode(){
        restGoogleGeocodeSteps.executeRequest();
    }

    @Then("I should get response status code '$statusCode'")
    public void checkResponseStatus(String statusCode){
        restGoogleGeocodeSteps.checkResponseStatus(statusCode);
    }

    @Then("I should get longitude '$longitude' and latitude '$latitude'")
    public void checkLongLat(float longitude,float latitude){
        restGoogleGeocodeSteps.checkUbication(longitude,latitude);
    }
}
