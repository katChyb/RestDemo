package apiWeatherTest;

import general.TestBase;
import general.WeatherHelper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;

public class weatherForLocation extends TestBase {


    @ParameterizedTest(name = "{0} has been verified")
    @MethodSource("general.DataProviderWeatherTest#testDataLocations")
    public void shouldGETweatherForGivenLocationReqRespSpec(String location) {

        WeatherHelper weatherHelper = new WeatherHelper();

        Response response =
                given()
                        .spec(weatherHelper.getRequestSpecForWetherTest(location))
                        .when()
                        .get(TestBase.BASE_WEATHER_URL)
                        .then()
                        .spec(weatherHelper.getResponseSpecForWetherTest())
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
                .get(TestBase.BASE_WEATHER_URL)
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}


