package utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class ReqResSpecifications {

    public RequestSpecification getRequestSpecForWetherTest(String location){
        RequestSpecification requestSpecification = given()
                .param("q", location)
                .param("appid", System.getProperty("appId"))
                .log()
                .all();
        return requestSpecification;
    }


    public ResponseSpecification getResponseSpecForWetherTest(){
        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification.log().all();
        responseSpecification.statusCode(200);
        return responseSpecification;
    }
}
