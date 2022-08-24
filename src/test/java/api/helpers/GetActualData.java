package api.helpers;

//This would probably be a set of helpers to check db for values that are required to run the tests.
// Without acceptance criteria I am not 100% sure what is expected, so I will just get data from response AND CONSIDER IT DB DATA
//If I had access to actual db I would use queries to get this info if needed.

import api.response.ApiResponse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetActualData {

    private static ApiResponse[] apiResponse;

    public static ApiResponse[] getAllData(){
        apiResponse = RequestBuilder.requestHouses(null, null, null).getBody().as(ApiResponse[].class);
        return apiResponse;
    }

    public static Long findLowestPrice(ApiResponse[] allData){
        Long lowestPrice = allData[0].getPrice();
        for (ApiResponse response : allData) {
            if (response.getPrice() < lowestPrice) {
                lowestPrice = response.getPrice();
            }
        }
        return lowestPrice;
    }

    public static Long findHighestPrice(ApiResponse[] allData){
        Long highestPrice = allData[0].getPrice();
        for (ApiResponse response : apiResponse) {
            if (response.getPrice() > highestPrice) {
                highestPrice = response.getPrice();
            }
        }
        return highestPrice;
    }

    public static int countAllEntries(ApiResponse[] allData){
        return allData.length;
    }

    //This is so I don't have to hardcode the city name into the test.
    //In actual project I would probably use options file with cities listed, and count number of one city entries in db
    //this city selection could be randomized, but there is no point since most common is Austin.
    public static String getFirstCityName(ApiResponse[] allData){
        return allData[0].getCity();
    }

    public static int countFirstCityNumber(ApiResponse[] allData){
        int firstCityCount = 0;
        for (ApiResponse response : allData) {
            if (response.getCity().equals(getFirstCityName(allData))) firstCityCount = firstCityCount + 1;
            }
        return firstCityCount;
    }

    public static int countDifferentCities(ApiResponse[] allData){
        List<String> cities = new ArrayList<>();
        for (ApiResponse response : allData) cities.add(response.getCity());
        Set<String> distinctSet = new HashSet<>(cities);
        return distinctSet.size();
    }

    public static int countEntriesWithinValidRange(ApiResponse[] allData, Long lPrice, Long hPrice, String city){
        int count = 0;
        if (lPrice == null){
            for (ApiResponse response : allData){
                if ((response.getPrice() <= hPrice) && (response.getCity().equals(city))) count = count + 1;
            }
        }
        if (hPrice == null){
            for (ApiResponse response : allData){
                if ((response.getPrice() >= lPrice) && (response.getCity().equals(city))) count = count + 1;
            }
        }
        if (lPrice != null && hPrice != null){
            for (ApiResponse response : allData){
                if ((response.getPrice() >= lPrice) && (response.getPrice() <= hPrice) && (response.getCity().equals(city))) count = count + 1;
            }
        }
        return count;
    }

    //I could adjust the method above to include option that city is null, but I am already making things
    // more complicated than I wanted when I started. So here is another one... On project I avoid copy/paste
    public static int countEntriesWithinValidRange(ApiResponse[] allData, Long lPrice, Long hPrice){
        int count = 0;
        if (lPrice == null){
            for (ApiResponse response : allData){
                if ((response.getPrice() <= hPrice)) count = count + 1;
            }
        }
        if (hPrice == null){
            for (ApiResponse response : allData){
                if ((response.getPrice() >= lPrice)) count = count + 1;
            }
        }
        if (lPrice != null && hPrice != null){
            for (ApiResponse response : allData){
                if ((response.getPrice() >= lPrice) && (response.getPrice() <= hPrice)) count = count + 1;
            }
        }
        return count;
    }
}
