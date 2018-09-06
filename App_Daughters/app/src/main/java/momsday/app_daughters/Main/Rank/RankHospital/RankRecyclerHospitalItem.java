package momsday.app_daughters.Main.Rank.RankHospital;

import android.media.Image;

public class RankRecyclerHospitalItem {

    String rankMyHospitalImagePath;
    String rankMyHospitalName, rankMyHospitalLocation;
    float rankMyHospitalScore;

    public String getRankMyHospitalImagePath() {
        return rankMyHospitalImagePath;
    }

    public String getRankMyHospitalName() {
        return rankMyHospitalName;
    }

    public String getRankMyHospitalLocation() {
        return rankMyHospitalLocation;
    }

    public float getRankMyHospitalScore() {
        return rankMyHospitalScore;
    }

    public RankRecyclerHospitalItem(String rankMyHospitalName, String rankMyHospitalLocation, float rankMyHospitalScore, String rankMyHospitalImagePath) {
        this.rankMyHospitalName = rankMyHospitalName;
        this.rankMyHospitalLocation = rankMyHospitalLocation;
        this.rankMyHospitalScore = rankMyHospitalScore;
        this.rankMyHospitalImagePath = rankMyHospitalImagePath;
    }
}
