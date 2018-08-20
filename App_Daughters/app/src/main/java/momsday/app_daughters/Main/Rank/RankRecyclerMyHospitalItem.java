package momsday.app_daughters.Main.Rank;

import android.media.Image;

public class RankRecyclerMyHospitalItem {

    Image rankMyHospitalImage;
    String rankMyHospitalName, rankMyHospitalLocation;
    int rankMyHospitalScore;

    public Image getRankMyHospitalImage() {
        return rankMyHospitalImage;
    }

    public String getRankMyHospitalName() {
        return rankMyHospitalName;
    }

    public String getRankMyHospitalLocation() {
        return rankMyHospitalLocation;
    }

    public int getRankMyHospitalScore() {
        return rankMyHospitalScore;
    }

    public RankRecyclerMyHospitalItem(String rankMyHospitalName, String rankMyHospitalLocation, int rankMyHospitalScore) {
        this.rankMyHospitalName = rankMyHospitalName;
        this.rankMyHospitalLocation = rankMyHospitalLocation;
        this.rankMyHospitalScore = rankMyHospitalScore;
    }
}
