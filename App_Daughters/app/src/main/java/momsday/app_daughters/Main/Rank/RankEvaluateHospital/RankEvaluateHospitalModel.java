package momsday.app_daughters.Main.Rank.RankEvaluateHospital;

import com.google.gson.annotations.SerializedName;

public class RankEvaluateHospitalModel {
    @SerializedName("equipment")
    private int equipment;
    @SerializedName("meal")
    private int meal;
    @SerializedName("schedule")
    private int schedule;
    @SerializedName("cost")
    private int cost;
    @SerializedName("service")
    private int service;
    @SerializedName("overall")
    private float overall;
    @SerializedName("lineE")
    private String lineE;

    public void setEquipment(int equipment) {
        this.equipment = equipment;
    }

    public void setMeal(int meal) {
        this.meal = meal;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setService(int service) {
        this.service = service;
    }

    public void setOverall(float overall) {
        this.overall = overall;
    }

    public void setLineE(String lineE) {
        this.lineE = lineE;
    }
}
