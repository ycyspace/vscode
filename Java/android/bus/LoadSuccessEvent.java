package android.bus;

public class LoadSuccessEvent extends Event<LoadSuccessEvent>{
    String status;
    int code;
    public LoadSuccessEvent() {
    }
    public LoadSuccessEvent(String status, int code) {
        this.status = status;
        this.code = code;
        t = this;
    }
    
    
}
