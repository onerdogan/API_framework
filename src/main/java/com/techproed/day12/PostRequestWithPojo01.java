package com.techproed.day12;

import com.techproed.pojos.TodosPojo;
import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo01 extends JsonPlaceHolderTestBase {
//    https://jsonplaceholder.typicode.com/todos url ‘ine bir request gönderildiğinde
//    Request body {
//        "userId": 21,
//                "id": 201,
//                "title": "Tidy your room",
//                "completed": false
//    }
//    Status kodun 201, response body ‘nin ise
//    {
//        "userId": 21,
//            "id": 201,
//            "title": "Tidy your room",
//            "completed": false
//    }

@Test
    public void test(){
    spec01.pathParam("parametre","todos");

    TodosPojo requestExpected=new TodosPojo(21,201,"Tidy your room",false);
    System.out.println(requestExpected);

    Response response=given().
            contentType(ContentType.JSON).
            spec(spec01).
            auth().basic("admin","password123").
            body(requestExpected).
            when().
            post("/{parametre}");
    response.prettyPrint();

    //de serialization
    TodosPojo actualdata=response.as(TodosPojo.class);
    Assert.assertEquals(201,response.getStatusCode());
    Assert.assertEquals(requestExpected.getUserId(),actualdata.getUserId());
    Assert.assertEquals(requestExpected.getId(),actualdata.getId());
    Assert.assertEquals(requestExpected.getTitle(),actualdata.getTitle());
    Assert.assertEquals(requestExpected.isCompleted(),actualdata.isCompleted());

}
}