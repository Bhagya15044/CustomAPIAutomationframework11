package org.example.tests.restfulbooker.crud;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;

public class TestHealthCheckup extends BaseTest
{

    @Test
    @Description("TC#3  - Verify Health")
    public void testGETHealthCheck() {
        requestSpecification.basePath(APIConstants.PING_URL);

        response = RestAssured.given(requestSpecification).when().get();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);


        assertActions.verifyTrue(response.asString().contains("Created"));


    }
}
