package momsday.app_daughters.SearchHospital;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.util.List;

public class SearchHospitalModel {

    @SerializedName("data")
    private List<Data> data;

    class Data {
        @SerializedName("address")
        private String address;

        @SerializedName("careworkers")
        private List<Careworkers> careworekrs;

        @SerializedName("facilityCode")
        private String facilityCode;

        @SerializedName("name")
        private String facilityName;

        class Careworkers {
            @SerializedName("id")
            private String id;

            @SerializedName("pw")
            private String pw;

            public String getId() {
                return id;
            }

            public String getPw() {
                return pw;
            }
        }

        public String getAddress() {
            return address;
        }

        public List<Careworkers> getCareworekrs() {
            return careworekrs;
        }

        public String getFacilityCode() {
            return facilityCode;
        }

        public String getFacilityName() {
            return facilityName;
        }
    }

    public List<Data> getData() {
        return data;
    }
}
