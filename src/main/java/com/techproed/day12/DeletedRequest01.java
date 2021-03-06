package com.techproed.day12;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeletedRequest01 extends DummyTestBase {
//    http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde
//
//    Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
//    {
//        "status": "success",
//            "data": "2",
//            "message": "Successfully! Record has been deleted"
//    }

    @Test
    public void test(){
        spec03.pathParams("parametre1","delete","parametre2",2);


        DummyTestData testData=new DummyTestData();
        JSONObject expecteddata=testData.setUpDeletedExpectedData();

        Response response=given().
                contentType(ContentType.JSON).
                spec(spec03).
                auth().basic("admin","password123").
                when().
                delete("/{parametre1}/{parametre2}");
        response.prettyPrint();
        //Matchers class++
        response.then().
                assertThat().
                statusCode(200).
                body("status", equalTo(expecteddata.getString("status")),
                        "data",equalTo(expecteddata.getString("data")),
                        "message",equalTo(expecteddata.getString("message")));

        //de serialization
        HashMap<String,Object> actualData=response.as(HashMap.class);
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(expecteddata.getString("status"),actualData.get("status"));
        Assert.assertEquals(expecteddata.getString("data"),actualData.get("data"));
        Assert.assertEquals(expecteddata.getString("message"),actualData.get("message"));
    }
}
