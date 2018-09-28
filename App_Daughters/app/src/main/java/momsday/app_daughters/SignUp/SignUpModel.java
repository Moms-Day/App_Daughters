package momsday.app_daughters.SignUp;

import com.google.gson.annotations.SerializedName;

public class SignUpModel {
    @SerializedName("id")
    private String id;
    @SerializedName("pw")
    private String pw;
    @SerializedName("phoneNumber")
    private String phoneNumber;
    @SerializedName("certifyCode")
    private String certifyCode;
    @SerializedName("name")
    private String name;
    @SerializedName("age")
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCertifyCode() {
        return certifyCode;
    }

    public void setCertifyCode(String certifyCode) {
        this.certifyCode = certifyCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}