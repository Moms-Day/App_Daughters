package momsday.app_daughters.Main.Main.Main;

import com.google.gson.annotations.SerializedName;

public class MainModel {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("careId")
    private String careworkerId;

    @SerializedName("careName")
    private String careworkerName;

    @SerializedName("facilityCode")
    private String hospitalCode;

    @SerializedName("facilityName")
    private String hospitalName;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getCareworkerId() {
        return careworkerId;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public String getCareworkerName() {
        return careworkerName;
    }
}
