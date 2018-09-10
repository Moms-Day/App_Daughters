package momsday.app_daughters.MyPage;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MyPageModel {
    @SerializedName("age")
    private int age;

    @SerializedName("name")
    private String name;

    @SerializedName("patients")
    private ArrayList<patients> patients;

    class patients {
        @SerializedName("age")
        private int age;

        @SerializedName("gender")
        private boolean gender;

        @SerializedName("name")
        private String name;

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public boolean isGender() {
            return gender;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<MyPageModel.patients> getPatients() {
        return patients;
    }
}
