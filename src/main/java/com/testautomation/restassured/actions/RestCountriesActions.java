package com.testautomation.restassured.actions;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import org.jbehave.core.model.ExamplesTable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RestCountriesActions {

    private static final String URLBYCAPITALCITY= "http://restcountries.eu/rest/v2/capital/";

    public RestCountriesActions() {
    }

    public void setCityParameter(String city) {
        Serenity.setSessionVariable("City").to(city);
    }

    public void executeRequestCity(){
        SerenityRest.given().contentType("application/json")
                .when().get(URLBYCAPITALCITY
                        + Serenity.getCurrentSession().get("City").toString());
    }

    public String getResponseCode() {
        return "" + SerenityRest.then().extract().statusCode();
    }

    public String getCallCode() {
        List<String> codigosLlamadas = SerenityRest.then().
                extract().body().jsonPath().get("callingCodes[0]");
        return codigosLlamadas.get(0);
    }

    public boolean checkCurrencyData(ExamplesTable currencyData) {
       boolean answer = true;
        ArrayList<Map<String,String>> currencyAnswer = SerenityRest.then().
                extract().body().jsonPath().get("currencies[0]");
        Map<String,String> answerData = currencyAnswer.get(0);
        Map<String,String> expectedData = currencyData.getRow(0);
        Iterator<String> iterator = expectedData.keySet().iterator();
            while (iterator.hasNext() && answer) {
                String key = iterator.next();
                if (!expectedData.get(key).trim().equals(answerData.get(key))) {
                    answer = false;
                }
            }
        return answer;
    }
    
    public long getResponseTime(){
        return SerenityRest.then().extract().timeIn(TimeUnit.MILLISECONDS);
    }

}
