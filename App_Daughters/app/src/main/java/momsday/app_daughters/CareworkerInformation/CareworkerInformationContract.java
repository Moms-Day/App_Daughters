package momsday.app_daughters.CareworkerInformation;

public interface CareworkerInformationContract {
    interface View {
        void setCareworkerInform(String name, String hospitalName, int career, int patientNumber, String introduction, float sincerityScore, float kindnessScore, float overall, String firstReview, String secondReview, String thirdReview, String imagePath);
        void showErrorMessage();
    }

    interface Presenter {
        void setView(View view);
        void getCareworkerInform(String careworkerId);
    }
}
