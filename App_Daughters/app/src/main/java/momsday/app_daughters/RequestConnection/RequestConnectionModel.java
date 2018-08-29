package momsday.app_daughters.RequestConnection;

import com.google.gson.annotations.SerializedName;

public class RequestConnectionModel {
    @SerializedName("careId")
    private String careId;
    @SerializedName("requesterId")
    private String requesterId;
    @SerializedName("requesterName")
    private String requesterName;
    @SerializedName("patientName")
    private String patientName;
    @SerializedName("patientAge")
    private int patientAge;
    @SerializedName("patientGender")
    private boolean patientGender;

    public void setCareId(String careId) {
        this.careId = careId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public void setPatientGender(boolean patientGender) {
        this.patientGender = patientGender;
    }
}
