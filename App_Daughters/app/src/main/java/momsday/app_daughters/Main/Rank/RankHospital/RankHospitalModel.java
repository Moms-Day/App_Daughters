package momsday.app_daughters.Main.Rank.RankHospital;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RankHospitalModel{
    @SerializedName("facilityRanking")
    private List<Facilities> facilities;

    class Facilities {
        @SerializedName("address")
        private String hospitalAddress;
        @SerializedName("facilityCode")
        private String hospitalCode;
        @SerializedName("imagePath")
        private String hospitalImagePath;
        @SerializedName("medals")
        private String[] hospitalMedals;
        @SerializedName("name")
        private String hospitalName;
        @SerializedName("overall")
        private String hospitalOverAll;

        public void setHospitalAddress(String hospitalAddress) {
            this.hospitalAddress = hospitalAddress;
        }

        public void setHospitalCode(String hospitalCode) {
            this.hospitalCode = hospitalCode;
        }

        public void setHospitalImagePath(String hospitalImagePath) {
            this.hospitalImagePath = hospitalImagePath;
        }

        public void setHospitalMedals(String[] hospitalMedals) {
            this.hospitalMedals = hospitalMedals;
        }

        public void setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
        }

        public void setHospitalOverAll(String hospitalOverAll) {
            this.hospitalOverAll = hospitalOverAll;
        }
    }

    @SerializedName("myFacilities")
    private List<MyFacilities> myFacilities;

    class MyFacilities {
        @SerializedName("address")
        private String myHospitalAddress;
        @SerializedName("facilityCode")
        private String myHospitalCode;
        @SerializedName("imagePath")
        private String myHospitalImagePath;
        @SerializedName("medals")
        private String[] myHospitalMedals;
        @SerializedName("name")
        private String myHospitalName;
        @SerializedName("overall")
        private String myHospitalOverAll;

        public void setMyHospitalAddress(String myHospitalAddress) {
            this.myHospitalAddress = myHospitalAddress;
        }

        public void setMyHospitalCode(String myHospitalCode) {
            this.myHospitalCode = myHospitalCode;
        }

        public void setMyHospitalImagePath(String myHospitalImagePath) {
            this.myHospitalImagePath = myHospitalImagePath;
        }

        public void setMyHospitalMedals(String[] myHospitalMedals) {
            this.myHospitalMedals = myHospitalMedals;
        }

        public void setMyHospitalName(String myHospitalName) {
            this.myHospitalName = myHospitalName;
        }

        public void setMyHospitalOverAll(String myHospitalOverAll) {
            this.myHospitalOverAll = myHospitalOverAll;
        }
    }

    public void setFacilities(List<Facilities> facilities) {
        this.facilities = facilities;
    }

    public void setMyFacilities(List<MyFacilities> myFacilities) {
        this.myFacilities = myFacilities;
    }
}
