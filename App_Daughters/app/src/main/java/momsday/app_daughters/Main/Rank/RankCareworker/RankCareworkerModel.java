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

        public String getName() {
            return name;
        }

        public float getOverall() {
            return overall;
        }

        public int getCareer() {
            return career;
        }

        public int getPatientInCharge() {
            return patientInCharge;
        }

        public String getCareworkerId() {
            return careworkerId;
        }

        public String getImagePath() {
            return imagePath;
        }

        public String getWorkplace() {
            return workplace;
        }
    }

    @SerializedName("myCareWorkers")
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

        public String getImagePath() {
            return imagePath;
        }

        public String getWorkplace() {
            return workplace;
        }

        public String getCareworkerId() {
            return careworkerId;
        }

        public int getPatientInCharge() {
            return patientInCharge;
        }

        public int getCareer() {
            return career;
        }

        public float getOverall() {
            return overall;
        }

        public String getName() {
            return name;
        }
    }

    public List<Careworkers> getCareworkers() {
        return careworkers;
    }

    public List<myCareworekrs> getMyCareworekrs() {
        return myCareworekrs;
    }
}
