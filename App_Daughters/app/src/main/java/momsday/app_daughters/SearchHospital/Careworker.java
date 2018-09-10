package momsday.app_daughters.SearchHospital;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Careworker implements Parcelable{

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    Careworker() {
    }

    protected Careworker(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public static final Creator<Careworker> CREATOR = new Creator<Careworker>() {
        @Override
        public Careworker createFromParcel(Parcel in) {
            return new Careworker(in);
        }

        @Override
        public Careworker[] newArray(int size) {
            return new Careworker[size];
        }
    };

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
        parcel.writeString(id);
        parcel.writeString(name);
    }
}
