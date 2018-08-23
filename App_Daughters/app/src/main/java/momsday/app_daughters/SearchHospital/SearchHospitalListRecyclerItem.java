package momsday.app_daughters.SearchHospital;

public class SearchHospitalListRecyclerItem {
    String hospitalName, hospitalLocation;

    public String getHospitalName() {
        return hospitalName;
    }

    public String getHospitalLocation() {
        return hospitalLocation;
    }

    public SearchHospitalListRecyclerItem(String hospitalName, String hospitalLocation) {
        this.hospitalName = hospitalName;
        this.hospitalLocation = hospitalLocation;
    }
}
