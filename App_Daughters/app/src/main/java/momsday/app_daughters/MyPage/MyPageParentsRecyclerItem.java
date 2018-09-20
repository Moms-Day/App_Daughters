package momsday.app_daughters.MyPage;

public class MyPageParentsRecyclerItem {
    String parentName, parentAge;
    boolean parentGender;

    public String getParentName() {
        return parentName;
    }

    public String getParentAge() {
        return parentAge;
    }

    public boolean isParentGender() {
        return parentGender;
    }

    public MyPageParentsRecyclerItem(String parentName, String parentAge, boolean parentGender) {
        this.parentName = parentName;
        this.parentAge = parentAge;
        this.parentGender = parentGender;
    }
}
