package momsday.app_daughters.HospitalInformation;

public interface HospitalInformationContract {
    interface View {
        void setHospitalInform(String name, String phoneNumber, String location, String introduction, float facilityScore, float mealScore, float scheduleScore, float costScore, float serviceScore, String firstReview, String secondReview, String thirdReview, float overall, String imagePath);
        void showErrorMessage();

    }
    interface Presenter {
        void setView(View view);
        void getHospitalInform(String hospitalCode);
    }
}
