package momsday.app_daughters.MyPage;

public interface MyPageContract {
    interface View {
        void setMyInform(String myName, int myAge, String parentName, int parentAge, boolean pagrentGender);
        void completeWithdrawal();
        void showErrorMessage(String message);
    }
    interface Presenter {
        void setView(View view);
        void getMyInform();
        void doWithdrawal(String pw);
    }
}
