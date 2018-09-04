package momsday.app_daughters.Main.Rank;

public interface RankContract {
    interface View {
        void showSuccessMessage();
        void showErrorMEssage(String message);

    }
    interface Presenter {
        void setView(View view);
        void evaluateCareworker();
        void evaluateHospital(int equipment, int meal, int schedule, int cost, int service, float overall, String lineE);
    }
}
