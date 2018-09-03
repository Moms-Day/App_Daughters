package momsday.app_daughters.Main.Rank.RankCareworker;

import android.media.Image;

public class RankRecyclerCareworkerItem {
    Image rankCareworkerImage;
    String rankCareworkerName, rankCareworkerHospital;
    int rankCareworkerScore;

    public Image getRankCareworkerImage() {
        return rankCareworkerImage;
    }

    public String getRankCareworkerName() {
        return rankCareworkerName;
    }

    public String getRankCareworkerHospital() {
        return rankCareworkerHospital;
    }

    public int getRankCareworkerScore() {
        return rankCareworkerScore;
    }

    public RankRecyclerCareworkerItem(String rankCareworkerName, String rankCareworkerHospital, int rankCareworkerScore) {
        this.rankCareworkerName = rankCareworkerName;
        this.rankCareworkerHospital = rankCareworkerHospital;
        this.rankCareworkerScore = rankCareworkerScore;
    }
}
