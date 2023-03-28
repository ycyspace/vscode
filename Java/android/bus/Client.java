package bus;

public class Client {
    public static void main(String[] args) {
        new MyObserver();
        Observer<LoadSuccessEvent> loadEventObserver = event -> System.out.println("内部类 " + event.status + "  " + event.code);
        Bus.getInstance().register(loadEventObserver, LoadSuccessEvent.class);
        Bus.getInstance().register((Observer<LoginEvent>) event -> {
            System.out.println("匿名内部类 " + event.loString);
        }, LoginEvent.class);
        Bus.getInstance().postEvent(new LoginEvent("login", 0)); 
        Bus.getInstance().postEvent(new LoadSuccessEvent("加载成功", 200));
    }

    public static class MyObserver implements Observer<LoginEvent>{
        public MyObserver() {
            Bus.getInstance().register(this, LoginEvent.class);
        }

        @Override
        public void update(LoginEvent event) {
            // TODO Auto-generated method stub
            System.out.println("MyObserver 收到事件" + event.loString);
        }
    }

}
