package android.bus;

public class LoginEvent extends Event<LoginEvent>{
    String loString;
    int loginCode;
    public LoginEvent(String loString, int loginCode) {
        this.loString = loString;
        this.loginCode = loginCode;
    }
    @Override
    public LoginEvent initEvent() {
        // TODO Auto-generated method stub
        return this;
    }
    
}
