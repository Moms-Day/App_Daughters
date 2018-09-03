package momsday.app_daughters.HospitalInformation;

import com.google.gson.annotations.SerializedName;

public class HospitalInformationModel {
    @SerializedName("address")
    private String location;

    @SerializedName("bio")
    private String introduction;

    @SerializedName("imagePath")
    private String imagePath;

    @SerializedName("name")
    private String name;

    @SerializedName("oneLineE")
    private String[] reviews;

    @SerializedName("overall")
    private int overall;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    @SerializedName("scoreCost")
    private int costScore;

    @SerializedName("scoreFacility")
    private int facilityScore;

    @SerializedName("scoreMeal")
    private int mealScore;

    @SerializedName("scoreSchedule")
    private int scheduleScore;

    @SerializedName("scoreService")
    private String serviceScore;

}
