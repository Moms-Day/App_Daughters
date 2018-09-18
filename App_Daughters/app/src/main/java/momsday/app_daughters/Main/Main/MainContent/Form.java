package momsday.app_daughters.Main.Main.MainContent;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Form {
    @SerializedName("condition")
    private Condition condition;

    protected Form(Parcel in) {
        date = in.readString();
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

        public boolean isActivityReduction() {
            return activityReduction;
        }

        public boolean isBingeEating() {
            return bingeEating;
        }

        public boolean isBloodPressureincrease() {
            return bloodPressureincrease;
        }

        public boolean isBloodPressureReduction() {
            return bloodPressureReduction;
        }

        public boolean isConstipation() {
            return constipation;
        }

        public boolean isCough() {
            return cough;
        }

        public boolean isDiarrhea() {
            return diarrhea;
        }

        public boolean isHighFever() {
            return highFever;
        }

        public boolean isHumanPowerReduction() {
            return humanPowerReduction;
        }

        public boolean isLackOfSleep() {
            return lackOfSleep;
        }

        public boolean isLoseAppetite() {
            return loseAppetite;
        }

        public boolean isLowTemparature() {
            return lowTemparature;
        }

        public boolean isPovertyOfBlood() {
            return povertyOfBlood;
        }

        public boolean isUrinationInconvenient() {
            return urinationInconvenient;
        }

        public boolean isVomiting() {
            return vomiting;
        }
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

        @SerializedName("snack")
        private String snack;

        public String getSnack() {
            return snack;
        }

        public String[] getBreakfast() {
            return breakfast;
        }

        public String[] getDinner() {
            return dinner;
        }

        public String[] getLunch() {
            return lunch;
        }
    }

    @SerializedName("additional")
    private Additional additional;
    class Additional {
        @SerializedName("description")
        private String description;

        public String getDescription() {
            return description;
        }
    }


    @SerializedName("photo")
    private Photo photo;

    class Photo {
        @SerializedName("comment")
        private String comment;

        @SerializedName("photo_path")
        private String photoPath;

        public String getComment() {
            return comment;
        }

        public String getPhotoPath() {
            return photoPath;
        }
    }

    @SerializedName("schedule")
    private ArrayList<Schedule> schedules;

    class Schedule {
        @SerializedName("time")
        private String time;

        @SerializedName("work")
        private String work;

        public String getTime() {
            return time;
        }

        public String getWork() {
            return work;
        }
    }

    public Condition getCondition() {
        return condition;
    }

    public ArrayList<Schedule> getSchedules() {
        return schedules;
    }

    public Meal getMeal() {
        return meal;
    }

    public Photo getPhoto() {
        return photo;
    }

    public String getDate() {
        return date;
    }

    public Additional getAdditional() {
        return additional;
    }
}
