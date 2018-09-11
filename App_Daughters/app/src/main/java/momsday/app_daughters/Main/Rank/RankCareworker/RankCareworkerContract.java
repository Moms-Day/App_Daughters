package momsday.app_daughters.Main.Rank.RankCareworker;

public interface RankCareworkerContract {
    interface View {
        void setMyCareworker(String rankMyCareworkerName, String rankMyCareworkerHospital, float rankMyCareworkerScore, String rankMyCareworkerImagePath);
        void setCareworker(String ranCareworkerName, String rankCareworkerHospital, float rankCareworkerScore, String rankCareworkerImagePath);
        void startCareworkerInform(String careworkerId);
        void setMyCareworkerNoneText();
    }
    interface Presenter {
        void setView(View view);
        void getCareworkerRank();
        void getCareworkerId(int position);
        void getMyCareworkerId(int position);
    }
}
