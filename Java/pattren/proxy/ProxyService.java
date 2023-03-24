package pattren.proxy;

public class ProxyService implements Action{
    private Action action;
    public ProxyService(Action action) {
        this.action = action;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        action.run();
        System.out.println("this is a proxyService");
    
    }
    
}
