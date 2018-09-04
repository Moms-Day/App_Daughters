package momsday.app_daughters.HospitalInformation;

public interface HospitalInformationContract {
    interface View {
        void setHospitalInform(String name, String phoneNumber, String location, String introduction, String facilityScore, String mealScore, String scheduleScore, String costScore, String serviceScore, String firstReview, String secondReview, String thirdReview, float overall);
        void showErrorMessage();

    }
    interface Presenter {
        void setView(View view);
        void getHospitalInform(String hospitalCode);
    }
}
