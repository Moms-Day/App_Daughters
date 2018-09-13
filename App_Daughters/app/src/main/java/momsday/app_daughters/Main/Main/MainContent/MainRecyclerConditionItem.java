package momsday.app_daughters.Main.Main.MainContent;

public class MainRecyclerConditionItem {
    String checkbox1Name, checkbox2Name, checkbox3Name;
    boolean checkbox1Checked, checkbox2Checked, checkbox3Checked;

    public String getCheckbox1Name() {
        return checkbox1Name;
    }

    public String getCheckbox2Name() {
        return checkbox2Name;
    }

    public String getCheckbox3Name() {
        return checkbox3Name;
    }

    public boolean isCheckbox1Checked() {
        return checkbox1Checked;
    }

    public boolean isCheckbox2Checked() {
        return checkbox2Checked;
    }

    public boolean isCheckbox3Checked() {
        return checkbox3Checked;
    }

    public MainRecyclerConditionItem(String checkbox1Name, String checkbox2Name, String checkbox3Name, boolean checkbox1Checked, boolean checkbox2Checked, boolean checkbox3Checked) {
        this.checkbox1Name = checkbox1Name;
        this.checkbox2Name = checkbox2Name;
        this.checkbox3Name = checkbox3Name;
        this.checkbox1Checked = checkbox1Checked;
        this.checkbox2Checked = checkbox2Checked;
        this.checkbox3Checked = checkbox3Checked;
    }
}
