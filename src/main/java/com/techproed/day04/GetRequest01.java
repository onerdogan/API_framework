package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;
public class GetRequest01 {

//    https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
//    HTTP status kodunun 200
//    Content Type'in Json
//    Ve Status Line'in HTTP/1.1 200 OK
//    Oldugunu test edin

    @Test
            public void test01() {


        //1- API testi yaparken ilk olarak URI (entpoint) belirlenmeli
        String url = "https://restful-booker.herokuapp.com/booking/3";
        //2- beklenen sonuc(expected result) olusturulur.
        //bu casede benden body dugrulanmsi istenmedigi icin expected result olusturmuyoruz

        //3- Request gonderiyoruz
        Response response=given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();

        //4- Actual result olustur
        //responce body ile ilgili islem yapmayacagimiz icin simdi olusturmayacagiz
        //5- Dogrulama yap(assertion)
        System.out.println("status code :"+response.getStatusCode());
        System.out.println(" content type :"+response.getContentType());
        System.out.println("status line :"+response.getStatusLine());
        System.out.println("headers :"+response.getHeaders());

        /*
        Assert.assertEquals(200,response.getStatusCode());
        //expected kismi bize task olarak verilen degerdir, actual ise responsdan gelendegerdir,
        //status code int deger dondurur

        Assert.assertEquals("application/json; charset=utf-8",response.getContentType());

        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
*/
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");


    }
}
