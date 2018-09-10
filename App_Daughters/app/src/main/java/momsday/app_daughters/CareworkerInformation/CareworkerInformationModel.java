package momsday.app_daughters.CareworkerInformation;

import com.google.gson.annotations.SerializedName;

public class CareworkerInformationModel {
    @SerializedName("bio")
    private String introduction;

    @SerializedName("career")
    private int career;

    @SerializedName("imagePath")
    private String imagePath;

    @SerializedName("name")
    private String name;

    @SerializedName("oneLineE")
    private String[] reviews;

    @SerializedName("overall")
    private float overall;

    @SerializedName("patientInCharge")
    private int patientNumber;

    @SerializedName("scoreDiligence")
    private float sincerityScore;

    @SerializedName("scoreKindness")
    private float kindnessScore;

    @SerializedName("workplace")
    private String hospitalName;

    public String[] getReviews() {
        return reviews;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getImagePath() {
        return imagePath;
    }

    public float getOverall() {
        return overall;
    }

    public String getName() {
        return name;
    }

    public int getCareer() {
        return career;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public float getKindnessScore() {
        return kindnessScore;
    }

    public float getSincerityScore() {
        return sincerityScore;
    }

    public int getPatientNumber() {
        return patientNumber;
    }
}
