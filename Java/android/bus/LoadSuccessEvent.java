package bus;

public class LoadSuccessEvent extends Event<LoadSuccessEvent>{
    String status;
    int code;
    public LoadSuccessEvent(String status, int code) {
        this.status = status;
        this.code = code;
    }
    @Override
    public LoadSuccessEvent initEvent() {
        // TODO Auto-generated method stub
        return this;
    }
    
    
}
