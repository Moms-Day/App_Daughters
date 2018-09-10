package momsday.app_daughters.Main.Rank.RankCareworker;

import android.media.Image;

public class RankRecyclerCareworkerItem {
    String rankCareworkerName, rankCareworkerHospital, rankCareworkerImagePath;
    float rankCareworkerScore;

    public String getRankCareworkerImagePath() {
        return rankCareworkerImagePath;
    }

    public String getRankCareworkerName() {
        return rankCareworkerName;
    }

    public String getRankCareworkerHospital() {
        return rankCareworkerHospital;
    }

    public float getRankCareworkerScore() {
        return rankCareworkerScore;
    }

    public RankRecyclerCareworkerItem(String rankCareworkerName, String rankCareworkerHospital, float rankCareworkerScore, String rankCareworkerImagePath) {
        this.rankCareworkerName = rankCareworkerName;
        this.rankCareworkerHospital = rankCareworkerHospital;
        this.rankCareworkerScore = rankCareworkerScore;
        this.rankCareworkerImagePath = rankCareworkerImagePath;
    }
}
