package momsday.app_daughters.SearchHospital;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

import java.util.List;

public class SearchHospitalModel {

        @SerializedName("address")
        private String address;

        @SerializedName("careworkers")
        private List<Careworkers> careworekrs;

        @SerializedName("facilityCode")
        private String facilityCode;

        @SerializedName("name")
        private String facilityName;

        class Careworkers implements Parcelable {
            @SerializedName("id")
            private String id;

            @SerializedName("name")
            private String name;

            public String getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int i) {

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
