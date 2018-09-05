package momsday.app_daughters.Main.Rank;

public interface RankContract {
    interface View {
        void showEvaluateHospitalSuccessMessage();
        void showEvaluateCareworkerSuccessMessage();
        void showErrorMEssage(String message);

    }
    interface Presenter {
        void setView(View view);
        void evaluateCareworker(int sincerity, int kindness, float overall, String review);
        void evaluateHospital(int equipment, int meal, int schedule, int cost, int service, float overall, String lineE);
    }
}
