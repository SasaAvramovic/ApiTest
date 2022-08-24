package api.steps;

import api.data_containers.GeneralData;
import api.helpers.GetActualData;
import api.helpers.RequestBuilder;
import api.response.ApiResponse;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidRequestsSteps {

    @When("user sends request with {}")
    public void testValidData(String requestType){
        switch (requestType) {
            case "no values" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(null, null, null);
            case "city only" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(GetActualData.getFirstCityName(GeneralData.allResponseData), null, null);
            case "lowest price only" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(null, GetActualData.findLowestPrice(GeneralData.allResponseData).toString(), null);
            case "highest price only" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(null, null, GetActualData.findHighestPrice(GeneralData.allResponseData).toString());
            case "city and border values" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(GetActualData.getFirstCityName(GeneralData.allResponseData),
                            GetActualData.findLowestPrice(GeneralData.allResponseData).toString(),
                            GetActualData.findHighestPrice(GeneralData.allResponseData).toString());
            case "city and border +-1" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(GetActualData.getFirstCityName(GeneralData.allResponseData),
                            Long.toString(GetActualData.findLowestPrice(GeneralData.allResponseData) + 1),
                            Long.toString(GetActualData.findHighestPrice(GeneralData.allResponseData) - 1));
            case "same lPrice and hPrice" ->
                    GeneralData.apiResponse = RequestBuilder.requestHouses(null,
                            GetActualData.findLowestPrice(GeneralData.allResponseData).toString(),
                            GetActualData.findLowestPrice(GeneralData.allResponseData).toString());
        }
    }

    @Then("response code is {}")
    public void checkResponseCode(int code){
        assertThat(GeneralData.apiResponse.getStatusCode()).isEqualTo(code);
    }

    @Then("response has {} listings")
    public void checkNumberOfListings(String numberOfListings){
        switch (numberOfListings) {
            case "all" ->
                    assertThat(GeneralData.apiResponse.getBody().as(ApiResponse[].class).length).isEqualTo(GetActualData.countAllEntries(GeneralData.allResponseData));
            case "first city count" ->
                    assertThat(GeneralData.apiResponse.getBody().as(ApiResponse[].class).length).isEqualTo(GetActualData.countFirstCityNumber(GeneralData.allResponseData));
            case "count from data" ->
                    assertThat(GeneralData.apiResponse.getBody().as(ApiResponse[].class).length)
                            .isEqualTo(GetActualData.countEntriesWithinValidRange(GeneralData.allResponseData,
                            GetActualData.findLowestPrice(GeneralData.allResponseData),
                            GetActualData.findHighestPrice(GeneralData.allResponseData),
                            GetActualData.getFirstCityName(GeneralData.allResponseData)));
            case "count from data +-1" ->
                    assertThat(GeneralData.apiResponse.getBody().as(ApiResponse[].class).length)
                            .isEqualTo(GetActualData.countEntriesWithinValidRange(GeneralData.allResponseData,
                            GetActualData.findLowestPrice(GeneralData.allResponseData) + 1,
                            GetActualData.findHighestPrice(GeneralData.allResponseData) - 1,
                            GetActualData.getFirstCityName(GeneralData.allResponseData)));
            case "count from data HL" ->
                    assertThat(GeneralData.apiResponse.getBody().as(ApiResponse[].class).length)
                            .isEqualTo(GetActualData.countEntriesWithinValidRange(GeneralData.allResponseData,
                            GetActualData.findLowestPrice(GeneralData.allResponseData),
                            GetActualData.findLowestPrice(GeneralData.allResponseData)));
            case "0" ->
                    assertThat(GeneralData.apiResponse.getBody().as(ApiResponse[].class).length).isEqualTo(0);
        }
    }

    @Then("response contains {} different cities")
    public void countDifferentCities(int cities){
        assertThat(GetActualData.countDifferentCities(GeneralData.apiResponse.getBody().as(ApiResponse[].class))).isEqualTo(cities);
    }
}
