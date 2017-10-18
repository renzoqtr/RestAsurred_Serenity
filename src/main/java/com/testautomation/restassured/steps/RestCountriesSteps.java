package com.testautomation.restassured.steps;


import com.testautomation.restassured.actions.RestCountriesActions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.MatcherAssert;
import org.jbehave.core.model.ExamplesTable;

public class RestCountriesSteps extends ScenarioSteps {

    private RestCountriesActions restCountriesActions = new RestCountriesActions();

    @Step
    public void requestByCity(String city) {
        restCountriesActions.setCityParameter(city);
    }

    @Step
    public void executeRequestCity() {
        restCountriesActions.executeRequestCity();
    }

    @Step
    public void responseCodeShouldBe(String expectedCode) {
        String responseCode = restCountriesActions.getResponseCode();
        MatcherAssert.assertThat("The Response Code is diferent from expected:\n"
                        + "expected[" + expectedCode + "] obtainned[" + responseCode + "]",
                expectedCode.trim().equals(responseCode.trim()));
    }

    @Step
    public void callCodeShouldBe(String expectedCallCode) {
        String callCode = restCountriesActions.getCallCode();
        MatcherAssert.assertThat("The Call Code is diferent from expected:\n"
                        + "expected[" + expectedCallCode + "] obtainned[" + callCode + "]",
                expectedCallCode.trim().equals(callCode.trim()));
    }

    @Step
    public void currencyShouldBe(ExamplesTable currencyData) {
        MatcherAssert.assertThat("The Currency Data is Wrong",
                restCountriesActions.checkCurrencyData(currencyData));
    }

    @Step
    public void responseTimeCheck(long time) {
        long responseTime = restCountriesActions.getResponseTime();
        MatcherAssert.assertThat("The Service Answer took to much time \n"
                        + "expected[" + time + "] obtained[" + responseTime + "]",
                responseTime <= time);
    }
}
