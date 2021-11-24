package com.techproed.testData;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTestData {
    public Map<String, Object> setUpTestData() {


        HashMap<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("statusCode", 200);
        expectedData.put("via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");
        expectedData.put("userId", 1);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        return expectedData;
    }

    public JSONObject setUpPostData(){

        JSONObject expectedRequest=new JSONObject();
        expectedRequest.put("statusCode",201);
        expectedRequest.put("userId",55);
        expectedRequest.put("title","Tidy your room");
        expectedRequest.put("completed",false);
        return expectedRequest;


    }
    //    {
//        "userId": 21,
//            "title": "Wash the dishes",
//            "completed": false
//    }
    public JSONObject setUpPutData(){

        JSONObject expectedRequest=new JSONObject();

        expectedRequest.put("userId",21);
        expectedRequest.put("title","Wash the dishes");
        expectedRequest.put("completed",false);
        return expectedRequest;


    }

}
