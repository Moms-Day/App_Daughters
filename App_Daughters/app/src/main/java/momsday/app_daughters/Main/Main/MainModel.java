package momsday.app_daughters.Main.Main;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MainModel {
    @SerializedName("2days_ago")
    private ArrayList<form> twoDaysAgoForm;

    @SerializedName("today")
    private ArrayList<form> today;

    @SerializedName("yesterday")
    private ArrayList<form> yesterday;

    class form {
        @SerializedName("condition")
        private ArrayList<Condition> conditions;

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

}
