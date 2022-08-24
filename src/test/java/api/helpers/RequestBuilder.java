package api.helpers;

import api.data_containers.GeneralData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {

    public static Response requestHouses(String city, String lPrice, String hPrice){
        RequestSpecification request = RestAssured.given();
        if (city != null) request.queryParam("city", city);
        if (lPrice != null) request.queryParam("price_gte", lPrice);
        if (hPrice != null) request.queryParam("price_lte", hPrice);
        return request.get(GeneralData.requestUri);
    }
}
