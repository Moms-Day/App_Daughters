package momsday.app_daughters.Main.Rank;

import momsday.app_daughters.Api;
import momsday.app_daughters.ApiClient;

public class RankPresenter implements RankContract.Presenter {
    private RankContract.View view;
    private Api api = ApiClient.getClient().create(Api.class);

    @Override
    public void setView(RankContract.View view) {
        this.view = view;
    }

    @Override
    public void evaluateCareworker() {

    }

    @Override
    public void evaluateHospital(int equipment, int meal, int schedule, int cost, int service, int overall, String lineE) {
        final RankEvaluateHospitalModel rankEvaluateHospitalModel  = new RankEvaluateHospitalModel();
        rankEvaluateHospitalModel.setEquipment(equipment);
        rankEvaluateHospitalModel.setMeal(meal);
        rankEvaluateHospitalModel.setSchedule(schedule);
        rankEvaluateHospitalModel.setCost(cost);
        rankEvaluateHospitalModel.setService(service);
        rankEvaluateHospitalModel.setOverall(overall);
        rankEvaluateHospitalModel.setLineE(lineE);


    }

    @Override
    public void setCareworekrRank() {

    }

    @Override
    public void setHospitalRank() {

    }
}
