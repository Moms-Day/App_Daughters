package momsday.app_daughters.Main;

public class MainRecyclerScheduleItem {
    String startTime, endTime, work;
    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public String getWork() {
        return work;
    }
    public MainRecyclerScheduleItem(String startTime, String endTime, String work) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.work = work;
    }
}
