package com.techproed.testData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyTestData {

    /*   http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
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
    public HashMap<String, Object> setupTestData() {
        List<Integer> yaslar = new ArrayList<Integer>();
        yaslar.add(40);
        yaslar.add(21);
        yaslar.add(19);


        HashMap<String, Object> calisan11Map = new HashMap<String, Object>();
        calisan11Map .put("id", 11);
        calisan11Map.put("employee_name", "Jena Gaines");
        calisan11Map.put("employee_salary", 90560);
        calisan11Map.put("employee_age",30);
        calisan11Map.put("profile_image","");

        HashMap<String,Object> expectedData=new HashMap<String,Object>();
        expectedData.put("statusCode",200);
        expectedData.put("besinciCalisan","Airi Satou");
        expectedData.put("calisanSayisi",24);
        expectedData.put("sondanikinciCalisanMaas",106450);
        expectedData.put("arananYaslar",yaslar);
        expectedData.put("calisan11",calisan11Map);
        return expectedData;
    }

   // Status kodun 200 olduğunu,
//    En yüksek maaşın 725000 olduğunu,
//    En küçük yaşın 19 olduğunu,
//    İkinci en yüksek maaşın 675000
//    olduğunu test edin.
   public HashMap<String, Integer> setupTestData1() {

       HashMap<String,Integer> expectedData=new HashMap<String,Integer>();
       expectedData.put("statuscode",200);
       expectedData.put("enyuksekmaas",725000);
       expectedData.put("enkucukyas",19);
       expectedData.put("ikinciyuksekmaas",675000);
       return expectedData;

   }
   public HashMap<String,String> setUpRequestBody(){
        HashMap<String,String> reguestBody=new HashMap<String,String>();
        reguestBody.put("name","ozgurkus");
        reguestBody.put("salary","333");
        reguestBody.put("age","45");
        return reguestBody;

   }

   public HashMap<String, Object> setupExpectedData(){
//        HashMap<String,Object> icdata=new HashMap<String,Object>();
//        data.put("name","ozgurkus");
//        data.put("salary","333");
//        data.put("age","45");

       HashMap<String,Object> expectedData=new HashMap<String,Object>();
       expectedData.put("statusCode",200);
       expectedData.put("status","success");
//       expectedData.put("data",icdata);
       expectedData.put("message","Successfully! Record has been added.");
       return expectedData;



   }
   // {
//        "status": "success",
//            "data": "2",
//            "message": "Successfully! Record has been deleted"
//    }

    public JSONObject setUpDeletedExpectedData(){
        JSONObject expectedData=new JSONObject();
        expectedData.put("status","success");
        expectedData.put("message","Successfully! Record has been deleted");
        expectedData.put("data","2");

        return expectedData;
    }
}