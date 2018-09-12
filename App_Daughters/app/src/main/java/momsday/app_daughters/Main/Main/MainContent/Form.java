package momsday.app_daughters.Main.Main.MainContent;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Form implements Parcelable{
    @SerializedName("condition")
    private ArrayList<Condition> conditions;

    protected Form(Parcel in) {
        date = in.readString();
    }

    public static final Creator<Form> CREATOR = new Creator<Form>() {
        @Override
        public Form createFromParcel(Parcel in) {
            return new Form(in);
        }

        @Override
        public Form[] newArray(int size) {
            return new Form[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(date);
    }

    class Condition {
        @SerializedName("activity_reduction")
        private boolean activityReduction;

        @SerializedName("low_temperature")
        private boolean lowTemparature;

        @SerializedName("high_fever")
        private boolean highFever;

        @SerializedName("blood_pressure_increase")
        private boolean bloodPressureincrease;

        @SerializedName("blood_pressure_reduction")
        private boolean bloodPressureReduction;

        @SerializedName("lack_of_sleep")
        private boolean lackOfSleep;

        @SerializedName("lose_Appetite")
        private boolean loseAppetite;

        @SerializedName("binge_eating")
        private boolean bingeEating;

        @SerializedName("diarrhea")
        private boolean diarrhea;

        @SerializedName("constipation")
        private boolean constipation;

        @SerializedName("vomiting")
        private boolean vomiting;

        @SerializedName("urination_inconvenient")
        private boolean urinationInconvenient;

        @SerializedName("human_power_reduction")
        private boolean humanPowerReduction;

        @SerializedName("poverty_of_blood")
        private boolean povertyOfBlood;

        @SerializedName("cough")
        private boolean cough;
    }

    @SerializedName("date")
    private String date;

    @SerializedName("meal")
    private Meal meal;

    class Meal {
        @SerializedName("breakfast")
        private String[] breakfast;

        @SerializedName("dinner")
        private String[] dinner;

        @SerializedName("lunch")
        private String[] lunch;
    }

    @SerializedName("photo")
    private Photo photo;

    class Photo {
        @SerializedName("comment")
        private String comment;

        @SerializedName("photo_path")
        private String photoPath;
    }

    @SerializedName("schedule")
    private ArrayList<Schedule> schedules;

    class Schedule {
        @SerializedName("time")
        private String time;

        @SerializedName("work")
        private String work;
    }
}
