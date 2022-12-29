package utils;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;
import providers.PropertiesFactory;


public class TestBase {
    private static PropertiesFactory propertiesFactory;


    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";



    @BeforeAll

    public static void setup() {
        propertiesFactory = PropertiesFactory.getInstance();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

}
