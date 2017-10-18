package com.testautomation.restassured.actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;
import java.util.Map;


public class RestGoogleGeocodeActions {

    private static final String URLGOOGLEGEOCODE = "https://maps.googleapis.com/maps/api/geocode/json";

    public RestGoogleGeocodeActions() {
    }

    public void requestByAddress(String address) {
        Serenity.setSessionVariable("Address").to(address);
    }

    public void executeRequest() {
        Map<String, String> params = new HashMap<>();
        params.put("address", Serenity.getCurrentSession().get("Address").toString());
        SerenityRest.given().contentType("application/json")
                .and().params(params)
                .when().get(URLGOOGLEGEOCODE);
    }

    public String getStatusCode() {
        return  "" + SerenityRest.then().extract().statusCode();
    }

    public float[] getLongLat() {
        float [] longLat = {0,0};
            longLat[0] = SerenityRest.then().extract().body().jsonPath().get("results.geometry.location.lng[0]");
            longLat[1] = SerenityRest.then().extract().body().jsonPath().get("results.geometry.location.lat[0]");
        return longLat;
    }
}
