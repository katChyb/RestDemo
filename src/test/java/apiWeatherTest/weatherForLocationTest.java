package apiWeatherTest;

import utils.TestBase;
import utils.ReqResSpecifications;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class weatherForLocationTest extends TestBase {

//https://www.swtestacademy.com/junit5-parallel-test-execution/
    @Execution(ExecutionMode.CONCURRENT)
    @ParameterizedTest(name = "{0} has been verified")
    @MethodSource("utils.DataProviderWeatherTest#testDataLocations")
    public void shouldGETweatherForGivenLocationReqRespSpec(String location) {

        ReqResSpecifications reqResSpecifications = new ReqResSpecifications();

        Response response =
                given()
                        .spec(reqResSpecifications.getRequestSpecForWetherTest(location))
                .when()
                        .get(System.getProperty("baseWeatherURL"))
                .then()
                        .spec(reqResSpecifications.getResponseSpecForWetherTest())
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(location, jsonPath.get("name"));
    }


    @Test
    public void shouldGETweatherforLondonReqSpecification() {
        RequestSpecification specification = given()
                .param("q", "London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();
        given()
                .spec(specification)
                .when()
                .get(System.getProperty("baseWeatherURL"))
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}


