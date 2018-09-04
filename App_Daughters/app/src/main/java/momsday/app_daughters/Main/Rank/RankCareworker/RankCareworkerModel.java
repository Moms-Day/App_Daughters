package momsday.app_daughters.Main.Rank.RankCareworker;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RankCareworkerModel {
    @SerializedName("careWorkerRanking")
    private List<Careworkers> careworkers;

    class Careworkers {
        @SerializedName("careWorkerId")
        private String careworkerId;
        @SerializedName("career")
        private int career;
        @SerializedName("imagePath")
        private String imagePath;
        @SerializedName("name")
        private String name;
        @SerializedName("overall")
        private float overall;
        @SerializedName("patientInCharge")
        private int patientInCharge;
        @SerializedName("workplace")
        private String workplace;
    }

    @SerializedName("myCareworkers")
    private List<myCareworekrs> myCareworekrs;

    class myCareworekrs {
        @SerializedName("careWorkerId")
        private String careworkerId;
        @SerializedName("career")
        private int career;
        @SerializedName("imagePath")
        private String imagePath;
        @SerializedName("name")
        private String name;
        @SerializedName("overall")
        private float overall;
        @SerializedName("patientInCharge")
        private int patientInCharge;
        @SerializedName("workplace")
        private String workplace;
    }
}
