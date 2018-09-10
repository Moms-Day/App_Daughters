package momsday.app_daughters.Main.Rank.RankHospital;

import android.media.Image;

public class RankRecyclerHospitalItem {

    String rankHospitalImagePath;
    String rankHospitalName, rankHospitalLocation;
    float rankHospitalScore;

    public String getRankHospitalImagePath() {
        return rankHospitalImagePath;
    }

    public String getRankHospitalName() {
        return rankHospitalName;
    }

    public String getRankHospitalLocation() {
        return rankHospitalLocation;
    }

    public float getRankHospitalScore() {
        return rankHospitalScore;
    }

    public RankRecyclerHospitalItem(String rankHospitalName, String rankHospitalLocation, float rankHospitalScore, String rankHospitalImagePath) {
        this.rankHospitalName = rankHospitalName;
        this.rankHospitalLocation = rankHospitalLocation;
        this.rankHospitalScore = rankHospitalScore;
        this.rankHospitalImagePath = rankHospitalImagePath;
    }
}
