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
    private int overall;

    @SerializedName("patientInCharge")
    private int patientNumber;

    @SerializedName("scoreDiligence")
    private int sincerityScore;

    @SerializedName("scoreKindness")
    private int kindnessScore;

    @SerializedName("workplace")
    private String hospitalName;
}
