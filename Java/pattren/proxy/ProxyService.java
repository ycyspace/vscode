package pattren.proxy;

public class ProxyService implements Action{
    private Service service;
    public ProxyService() {
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        if(service == null){
            service = new Service();
        }
        service.run();
        System.out.println("this is a proxyService");
    
    }
    
}
