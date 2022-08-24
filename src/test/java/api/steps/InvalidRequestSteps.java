package api.steps;

import api.data_containers.GeneralData;
import api.helpers.GetActualData;
import api.helpers.RequestBuilder;
import io.cucumber.java.en.When;

public class InvalidRequestSteps {

    @When("user sends invalid request with {}")
    public void testInvalidData(String requestType){
        switch (requestType) {
            case "invalid city string" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(GetActualData.getFirstCityName(GeneralData.allResponseData).toLowerCase(), null, null);
            case "blank city not null" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses("", null, null);
            case "city spec character" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses("!@#$%^&*", null, null);
            case "lPrice blank not null" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(null, "", null);
            case "lPrice string not num" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(null, "string", null);
            case "hPrice blank not null" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(null, null, "");
            case "hPrice string not num" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(null, null, "string");
            case "lPrice > hPrice" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(null, GetActualData.findHighestPrice(GeneralData.allResponseData).toString(), GetActualData.findLowestPrice(GeneralData.allResponseData).toString());
        }
    }
}
