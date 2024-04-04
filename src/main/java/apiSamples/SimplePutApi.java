package apiSamples;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimplePutApi {
    public static void main(String[] args) {
        Map<String, Object> requestBody = new HashMap<>();
        Map<String, Object> bookingDates1 = new HashMap<>();
        bookingDates1.put("checkin","2024-06-01");
        bookingDates1.put("checkout","2025-01-01");
        requestBody.put("firstname", "Tommy");
        requestBody.put("lastname", "Penner");
        requestBody.put("totalprice", 1000);
        requestBody.put("depositpaid", true);
        requestBody.put("bookingdates", bookingDates1);
        requestBody.put("additionalneeds", "Lunch");

        String token = getToken();

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON)
                .and().header("Cookie", "token=" + token)
                .and().baseUri("https://restful-booker.herokuapp.com")
                .and().basePath("/booking/{id}")
                .and().pathParam("id", 9)
                .and().filters(new ResponseLoggingFilter(), new RequestLoggingFilter())
                .and().body(requestBody)
                .when().put()
                .then().statusCode(200);
    }

    public static String getToken() {

        Map<String, String> request = new HashMap<>();
        request.put("username", "admin");
        request.put("password", "password123");

        RequestSpecification requestSpecification = RestAssured.given();
        Response response = requestSpecification.contentType(ContentType.JSON)
                .and().filters(new ResponseLoggingFilter(), new RequestLoggingFilter())
                .and().baseUri("https://restful-booker.herokuapp.com")
                .and().basePath("/auth")
                .and().body(request)
                .when().post();
        String token = response
                .then().statusCode(200)
                .and().extract().jsonPath().getString("token");

        return token;
    }
}
