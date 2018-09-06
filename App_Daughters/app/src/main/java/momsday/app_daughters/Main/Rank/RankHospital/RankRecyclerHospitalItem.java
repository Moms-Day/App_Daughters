package momsday.app_daughters.Main.Rank.RankHospital;

import android.media.Image;

public class RankRecyclerHospitalItem {

    Image rankMyHospitalImage;
    String rankMyHospitalName, rankMyHospitalLocation;
    float rankMyHospitalScore;

    public Image getRankMyHospitalImage() {
        return rankMyHospitalImage;
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

    public RankRecyclerHospitalItem(String rankMyHospitalName, String rankMyHospitalLocation, float rankMyHospitalScore) {
        this.rankMyHospitalName = rankMyHospitalName;
        this.rankMyHospitalLocation = rankMyHospitalLocation;
        this.rankMyHospitalScore = rankMyHospitalScore;
    }
}
