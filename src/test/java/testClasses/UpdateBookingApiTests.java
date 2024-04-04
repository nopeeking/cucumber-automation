package testClasses;

import api.UpdateBookingApi;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class UpdateBookingApiTests {
    @Test(description = "Validating firstname and lastname update")
    public void updateApiTest() {
        UpdateBookingApi updateBookingApi = new UpdateBookingApi(9);
        updateBookingApi.setHeader("Cookie", "token=" + this.getToken());
        updateBookingApi.setBody(this.getUpdateRequestMap("Kim","Burton"));
        updateBookingApi.sendRequest().then().statusCode(200);
    }
    private Map<String, Object> getUpdateRequestMap(String firstname, String lastname) {
        Map<String, Object> requestBody = new HashMap<>();
        Map<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2024-06-01");
        bookingDates.put("checkout", "2025-01-01");
        requestBody.put("firstname", firstname);
        requestBody.put("lastname", lastname);
        requestBody.put("totalprice", 1000);
        requestBody.put("depositpaid", true);
        requestBody.put("bookingdates", bookingDates);
        requestBody.put("additionalneeds", "Lunch");
        return requestBody;
    }


    private String getToken() {

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
