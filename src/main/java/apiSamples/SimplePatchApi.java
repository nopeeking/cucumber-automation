package apiSamples;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.BookingPriceRequest;

import java.util.HashMap;
import java.util.Map;

public class SimplePatchApi {
    public static void main(String[] args) {

        String token = getToken();

//        Map<String, Object> requestBody = new HashMap<>();
//        requestBody.put("totalprice", 666);

        BookingPriceRequest priceRequest = new BookingPriceRequest();
        priceRequest.setTotalprice(777);



        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON)
                .and().filters(new ResponseLoggingFilter(), new RequestLoggingFilter())
                .and().header("Cookie","token=" + token)
                .and().baseUri("https://restful-booker.herokuapp.com")
                .and().basePath("/booking/{id}")
                .and().pathParam("id", 9)
                .and().body(priceRequest)
                .when().patch()
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
