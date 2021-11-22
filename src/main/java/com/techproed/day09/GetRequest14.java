package com.techproed.day09;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class GetRequest14 extends DummyTestBase {

//    http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
//    Status kodun 200 olduğunu,
//    En yüksek maaşın 725000 olduğunu,
//    En küçük yaşın 19 olduğunu,
//    İkinci en yüksek maaşın 675000
//    olduğunu test edin.

    @Test
    public void test() {
        spec03.pathParam("parametre1", "employees");

        DummyTestData expectedKopru = new DummyTestData();
        HashMap<String, Integer> expectedDataMap = expectedKopru.setupTestData1();
        System.out.println(expectedDataMap);

        Response response = given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{parametre1}");

        //response.prettyPrint();
        HashMap<String, Object> actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        Assert.assertEquals(expectedDataMap.get("statuscode"),(Integer) response.getStatusCode());

        //    En yüksek maaşın 725000 olduğunu,
        List<Integer> maaslistesi=new ArrayList<Integer>();
        int datasize=((List)actualDataMap.get("data")).size();
        for(int i=0;i<datasize;i++) {

            maaslistesi.add((Integer) ((Map) ((List) actualDataMap.get("data")).get(i)).get("employee_salary"));
        }
        Collections.sort(maaslistesi);
        Assert.assertEquals(expectedDataMap.get("enyuksekmaas"),maaslistesi.get(datasize-1));
//    İkinci en yüksek maaşın 675000
        Assert.assertEquals(expectedDataMap.get("ikinciyuksekmaas"),maaslistesi.get((datasize-2)));

//    En küçük yaşın 19 olduğunu,

        List<Integer> yaslistesi=new ArrayList<Integer>();
        int datasizeYas=((List)actualDataMap.get("data")).size();
        for(int i=0;i<datasizeYas;i++) {

            yaslistesi.add((Integer) ((Map) ((List) actualDataMap.get("data")).get(i)).get("employee_age"));
        }
        Collections.sort(yaslistesi);
        Assert.assertEquals(expectedDataMap.get("enkucukyas"),yaslistesi.get(0));


//2 JsonPath yontemi ile
        JsonPath jey=response.jsonPath();

        List<Integer> maaslistesiJey=jey.getList("data.employee_salary");
        Collections.sort(maaslistesiJey);
        Assert.assertEquals(expectedDataMap.get("enyuksekmaas"),maaslistesiJey.get(maaslistesiJey.size()-1));
        Assert.assertEquals(expectedDataMap.get("ikinciyuksekmaas"),maaslistesiJey.get(maaslistesiJey.size()-2));

        List<Integer> yaslistesiJey=jey.getList("data.employee_age");
        Collections.sort(yaslistesiJey);
        Assert.assertEquals(expectedDataMap.get("enkucukyas"),yaslistesiJey.get(0));




    }
}