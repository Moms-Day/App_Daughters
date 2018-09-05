package momsday.app_daughters.Main.Rank;

import com.google.gson.annotations.SerializedName;

public class RankEvaluateCareworkerModel {
    @SerializedName("dilligence")
    private int sincerity;

    @SerializedName("kindness")
    private int kindness;

    @SerializedName("overall")
    private float overall;

    @SerializedName("lineE")
    private String review;

    public void setSincerity(int sincerity) {
        this.sincerity = sincerity;
    }

    public void setKindness(int kindness) {
        this.kindness = kindness;
    }

    public void setOverall(float overall) {
        this.overall = overall;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
