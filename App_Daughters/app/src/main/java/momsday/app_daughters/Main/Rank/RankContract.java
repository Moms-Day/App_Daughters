package momsday.app_daughters.Main.Rank;

public interface RankContract {
    interface View {
        void showEvaluateCareworekrDialog();
        void showEvaluateHospitalDialog();
        void showHospitalInform();
        void showCareworkerInform();

    }
    interface Presenter {
        void setView(View view);
        void evaluateCareworker();
        void evaluateHospital(int equipment, int meal, int schedule, int cost, int service, int overall, String lineE);
        void setCareworekrRank();
        void setHospitalRank();
    }
}
