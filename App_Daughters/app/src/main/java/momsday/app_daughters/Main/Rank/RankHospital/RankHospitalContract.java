package momsday.app_daughters.Main.Rank.RankHospital;

public interface RankHospitalContract {
    interface View {
        void setMyHospital(String myHospitalName, String myHospitalLocation, int myHospitalOverall);
        void setHospital(String hospitalName, String hospitalLocation, int hospitalOverall);
        void startHospitalInform(String hospitalCode);
    }
    interface Presenter {
        void setView(View view);
        void getHospitalRank();
        void getHospitalCode(int position);
    }
}
