package com.techproed.day08;


import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest13 extends DummyTestBase {
   // private RequestSpecificationImpl spec03;
/*
    http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    Status kodun 200 olduğunu,
      5. Çalışan isminin "Airi Satou" olduğunu ,
      çalışan sayısının 24 olduğunu,
    Sondan 2. çalışanın maaşının 106450 olduğunu
40,21 ve 19 yaslarında çalışanlar olup olmadığını
11. Çalışan bilgilerinin
    {
 “id”:”11”
        "employee_name": "Jena Gaines",
            "employee_salary": "90560",
            "employee_age": "30",
            "profile_image": "" }
} gibi olduğunu test edin.
*/

    @Test
    public void test() {
        spec03.pathParam("parametre1", "employees");

        DummyTestData expectedKopru = new DummyTestData();
        HashMap<String, Object> expectedDataMap = expectedKopru.setupTestData();
        System.out.println(expectedDataMap);

        Response response = given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{parametre1}");

     //   response.prettyPrint();
    //Deserialization islemi
        HashMap<String, Object> actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        //statusCode
        Assert.assertEquals(expectedDataMap.get("statusCode"),response.getStatusCode());
        //5. calisan
        Assert.assertEquals(expectedDataMap.get("besinciCalisan"),((Map)((List)actualDataMap.get("data")).get(4)).get("employee_name"));
        //calisan sayisinin 24 oldugu
        Assert.assertEquals(expectedDataMap.get("calisanSayisi"),((List) actualDataMap.get("data")).size());
        //sondan 2.nin maasi//once actual datadan bize donen listenin sayisini almaliyiz
        int datasize=((List) actualDataMap.get("data")).size();
        Assert.assertEquals(expectedDataMap.get("sondanikinciCalisanMaas"),
                ((Map)((List)actualDataMap.get("data")).get(datasize-2)).get("employee_salary"));

        //40,21 ve 19 yaslarında çalışanlar olup olmadığını
        List<Integer> actualYasListesi=new ArrayList<Integer>();
        for (int i=0;i<datasize;i++){
            actualYasListesi.add((Integer) ((Map) ((List) actualDataMap.get("data")).get(i)).get("employee_age"));
        }

        Assert.assertTrue(actualYasListesi.containsAll((List)expectedDataMap.get("arananYaslar")));
        //id si 11 olan kisi

        Assert.assertEquals(((Map)expectedDataMap.get("calisan11")).get("employee_name"),
                ((Map)((List<?>) actualDataMap.get("data")).get(10)).get("employee_name"));


        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("calisan11")).get("employee_salary"),
                ((Map) ((List<?>) actualDataMap.get("data")).get(10)).get("employee_salary"));
        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("calisan11")).get("employee_age"),
                ((Map) ((List<?>) actualDataMap.get("data")).get(10)).get("employee_age"));
        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("calisan11")).get("profile_image"),
                ((Map) ((List<?>) actualDataMap.get("data")).get(10)).get("profile_image"));
    }

    }
