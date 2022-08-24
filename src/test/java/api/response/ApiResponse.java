package api.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("mls_id")
    @Expose
    private Long mlsId;
    @SerializedName("mls_listing_id")
    @Expose
    private String mlsListingId;
    @SerializedName("property_type")
    @Expose
    private String propertyType;
    @SerializedName("formatted_address")
    @Expose
    private String formattedAddress;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("location")
    @Expose
    private List<Double> location = null;
    @SerializedName("bedrooms")
    @Expose
    private Long bedrooms;
    @SerializedName("bathrooms")
    @Expose
    private Long bathrooms;
    @SerializedName("list_date")
    @Expose
    private String listDate;
    @SerializedName("mls_update_date")
    @Expose
    private String mlsUpdateDate;
    @SerializedName("price_display")
    @Expose
    private String priceDisplay;
    @SerializedName("price")
    @Expose
    private Long price;
    @SerializedName("square_feet")
    @Expose
    private Object squareFeet;
    @SerializedName("hero")
    @Expose
    private Hero hero;

    public String getId() {
        return id;
    }

    public Long getMlsId() {
        return mlsId;
    }

    public String getMlsListingId() {
        return mlsListingId;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public List<Double> getLocation() {
        return location;
    }

    public Long getBedrooms() {
        return bedrooms;
    }

    public Long getBathrooms() {
        return bathrooms;
    }

    public String getListDate() {
        return listDate;
    }

    public String getMlsUpdateDate() {
        return mlsUpdateDate;
    }

    public String getPriceDisplay() {
        return priceDisplay;
    }

    public Long getPrice() {
        return price;
    }

    public Object getSquareFeet() {
        return squareFeet;
    }

    public Hero getHero() {
        return hero;
    }
}
