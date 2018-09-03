package momsday.app_daughters.CareworkerInformation;

public interface CareworkerInformationContract {
    interface View {
        void setCareworkerInform(String name, String hospitalName, String career, String patientNumber, String introduction, String sincerityScore, String kindnessScore, int overall, String firstReview, String secondReview, String thirdReview);
        void showErrorMessage();
    }

    interface Presenter {
        void setView(View view);
        void getCareworkerInform(String careworkerId);
    }
}
