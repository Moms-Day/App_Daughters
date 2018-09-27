package momsday.app_daughters.MyPage;

public interface MyPageContract {
    interface View {
        void setMyInform(String myName, int myAge);
        void setParentInform(String parentName, int parentAge, boolean parentGender);
        void completeWithdrawal();
        void showErrorMessage(String message);
    }
    interface Presenter {
        void setView(View view);
        void getMyInform();
        void doWithdrawal(String pw);
    }
}
