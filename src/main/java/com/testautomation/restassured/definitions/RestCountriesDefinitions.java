package com.testautomation.restassured.definitions;

import com.testautomation.restassured.steps.RestCountriesSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class RestCountriesDefinitions {
    @Steps
    private RestCountriesSteps restCountriesSteps;

    @Given("i have a capital city '$city'")
    public void resquestByCity(String city){
        restCountriesSteps.requestByCity(city);
    }

    @When("i request the information")
    public void executeRequest(){
        restCountriesSteps.executeRequestCity();
    }

    @Then("i should get response status code '$expectedCode'")
    public void responseCodeShouldBe(String expectedCode){
        restCountriesSteps.responseCodeShouldBe(expectedCode);
    }

    @Then("i should get the call code '$expectedCallCode'")
    public void callCodeShouldBe(String expectedCallCode){
        restCountriesSteps.callCodeShouldBe(expectedCallCode);
    }

    @Then("i should get currency data $currencyData")
    public void currencyShouldBe(ExamplesTable currencyData){
        restCountriesSteps.currencyShouldBe(currencyData);
    }

    @Then("response time should be '$time' miliseconds")
    public void responseTimeCheck(long time){
        restCountriesSteps.responseTimeCheck(time);
    }
}
