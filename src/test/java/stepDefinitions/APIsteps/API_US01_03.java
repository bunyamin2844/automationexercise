package stepDefinitions.APIsteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;


import pojo.Brand;
import pojo.BrandList;
import pojo.ProductList;
import utilities.WriteToTxt;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class API_US01_03 {
    Response response;
    JsonPath jsonPath;
    ObjectMapper objectMapper = new ObjectMapper();
    String productList = "https://automationexercise.com/api/productsList";
    String brandListUrl = "https://automationexercise.com/api/brandsList";
    Map<String, String> map = new HashMap<>();

    @Test
    public void getList() throws IOException {

        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(productList);

         response.prettyPrint();

        ProductList productList;
        productList = objectMapper.readValue(response.asString(), ProductList.class);

        // kac tane product var
        System.out.println("productList.getProducts().size() = " + productList.getProducts().size());

        String str = "Rs. 500";
        //fiyati 1000 den kucuk olan urunleri txt dosyasina yazdir
        for (int i = 0; i < productList.getProducts().size(); i++) {
            if (getPriceStringToInt(productList.getProducts().get(i).getPrice()) < 1000) {
                System.out.println(getPriceStringToInt(productList.getProducts().get(i).getPrice()));
                WriteToTxt.saveTitle("bunyamin", String.valueOf(getPriceStringToInt(productList.getProducts().get(i).getPrice())) + " , ");
            }
        }

        productList
                .getProducts()
                .stream()
                .map(t -> getPriceStringToInt(t.getPrice()))
                .filter(t -> t < 1000)
                .forEach(t -> WriteToTxt.saveTitle("bun", t + " "));


        // status code
        Assertions.assertEquals(response.statusCode(), 200, " response code 200 degil");


    }

    @Test
    public void getBrand() throws IOException {
        BrandList brandList;

        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(brandListUrl);

        Assertions.assertEquals(response.statusCode(), 200);

        brandList = objectMapper.readValue(response.asString(), BrandList.class);

        int polo = 0;
        int HM = 0;
        Set<String> markalarSet = new HashSet<>();
        // polo marka 4 tane
        for (int i = 0; i < brandList.getBrands().size(); i++) {
            if (brandList.getBrands().get(i).getBrand().equals("Polo")) {
                polo++;
            }
            if (brandList.getBrands().get(i).getBrand().equals("H&M")) {
                HM++;
            }

            markalarSet.add(brandList.getBrands().get(i).getBrand());

        }

        Assertions.assertEquals(polo,6);
        System.out.println("polo = " + polo);

        Assertions.assertEquals(HM,5);
        System.out.println("HM = " + HM);

        Assertions.assertEquals(markalarSet.size(),8);
        System.out.println(" Marka sayisi :"+markalarSet.size());




//        Assertions.assertEquals(brandList.getBrands()
//                .stream().filter(t -> t.getBrand()
//                        .equals("Polo")).count(), 6);
//        // hnm marka 5 tane
//        Assertions.assertEquals(brandList.getBrands()
//                .stream().filter(t -> t.getBrand()
//                        .equals("H&M")).count(), 5);
//        // 8 farkli urun cesidi
//        Assertions.assertEquals(brandList.getBrands()
//                .stream().map(Brand::getBrand).distinct().count(), 8);

    }

    int getPriceStringToInt(String priceString) {
        //  String str = "Rs. 500";
        return Integer.parseInt(priceString.split(" ")[1]);

    }

}
