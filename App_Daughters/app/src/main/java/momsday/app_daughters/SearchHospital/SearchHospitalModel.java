package momsday.app_daughters.SearchHospital;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class SearchHospitalModel {

        @SerializedName("address")
        private String address;

        @SerializedName("careWorkers")
        private ArrayList<Careworker> careworekrs;

        @SerializedName("facilityCode")
        private String facilityCode;

        @SerializedName("name")
        private String facilityName;



        public String getAddress() {
            return address;
        }

        public ArrayList<Careworker> getCareworekrs() {
            return careworekrs;
        }



    public String getFacilityCode() {
            return facilityCode;
        }

        public String getFacilityName() {
            return facilityName;
        }
}
