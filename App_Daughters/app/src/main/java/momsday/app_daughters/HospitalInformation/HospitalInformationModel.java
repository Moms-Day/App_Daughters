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
    private float overall;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    @SerializedName("scoreCost")
    private float costScore;

    @SerializedName("scoreFacility")
    private float facilityScore;

    @SerializedName("scoreMeal")
    private float mealScore;

    @SerializedName("scoreSchedule")
    private float scheduleScore;

    @SerializedName("scoreService")
    private float serviceScore;

    public String getName() {
        return name;
    }

    public float getOverall() {
        return overall;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getCostScore() {
        return costScore;
    }

    public float getFacilityScore() {
        return facilityScore;
    }

    public float getMealScore() {
        return mealScore;
    }

    public float getScheduleScore() {
        return scheduleScore;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getLocation() {
        return location;
    }

    public float getServiceScore() {
        return serviceScore;
    }

    public String[] getReviews() {
        return reviews;
    }
}
