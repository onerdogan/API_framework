package com.techproed.testData;

import com.google.gson.JsonObject;
import org.json.JSONObject;

import java.util.HashMap;

public class HerokuappTestData {
    /*
   https://restful-booker.herokuapp.com/booking/1 url ine bir istek gönderildiğinde
dönen response body nin
{
"firstname": "Eric",
"lastname": "Smith",
"totalprice": 555,
"depositpaid": false,
"bookingdates": {
"checkin": "2016-09-09",
"checkout": "2017-09-21"
}
} gibi olduğunu test edin
*/
    public HashMap<String, Object> setUpTestData() {
        HashMap<String, Object> bookingdates = new HashMap<String, Object>();
        bookingdates.put("checkin", "2020-11-17");
        bookingdates.put("checkout", "2021-05-23");

        HashMap<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("firstname", "Eric");
        expectedData.put("lastname", "Wilson");
        expectedData.put("totalprice", 935);
        expectedData.put("depositpaid", false);
        expectedData.put("bookingdates", bookingdates);
        return expectedData;
    }

    public JSONObject setUpTestAndRequestData() {
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2021-01-05");
        bookingdates.put("checkout", "2021-01-10");
        JSONObject expectedRequest = new JSONObject();
        expectedRequest.put("firstname", "ozgur");
        expectedRequest.put("lastname", "kus");
        expectedRequest.put("totalprice", 123);
        expectedRequest.put("depositpaid", false);
        expectedRequest.put("bookingdates", bookingdates);
        return expectedRequest;

    }
}