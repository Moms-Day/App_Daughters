package momsday.app_daughters.Main.Rank.RankCareworker;

public interface RankCareworkerContract {
    interface View {
        void setMyCareworker(String rankCareworkerName, String rankCareworkerHospital, int rankCareworkerScore);
        void setCareworker(String ranCareworkerName, String rankCareworkerHospital, int rankCareworkerScore);
        void startCareworkerInform(String careworkerId);
    }
    interface Presenter {
        void setView(View view);
        void getCareworkerRank();
        void getCareworkerId(int position);
    }
}
