package general;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class WeatherHelper {

    public RequestSpecification getRequestSpecForWetherTest(String location){
        RequestSpecification specification = given()
                .param("q", location)
                .param("appid", "89a2ed8a594cc497a6273490e7ca59dd")
                .log()
                .all();
        return specification;
    }


    public ResponseSpecification getResponseSpecForWetherTest(){
        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification.log().all();
        responseSpecification.statusCode(200);
        return responseSpecification;
    }
}
