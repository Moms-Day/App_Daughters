package momsday.app_daughters.Main.Rank.RankHospital;

public interface RankHospitalContract {
    interface View {
        void setMyHospital(String myHospitalName, String myHospitalLocation, float myHospitalOverall, String myHospitalImagePath);
        void setHospital(String hospitalName, String hospitalLocation, float hospitalOverall, String hospitalImagePath);
        void startHospitalInform(String hospitalCode);
        void setMyHospitalNoneText();
    }
    interface Presenter {
        void setView(View view);
        void getHospitalRank();
        void getHospitalCode(int position);
    }
}
