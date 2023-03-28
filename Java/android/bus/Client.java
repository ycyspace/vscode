package android.bus;

public class Client {
    public static void main(String[] args) {
        new MyObserver().onDestory();
        new TestObserver();
        Bus.getInstance().register(new Observer<LoginEvent>() {
            @Override
            public void update(LoginEvent event) {
                // TODO Auto-generated method stub
                System.out.println("匿名内部类 " + event.loString);
            }
            
        });
        Bus.getInstance().register(new Observer<LoadSuccessEvent>() {
            @Override
            public void update(LoadSuccessEvent event) {
                // TODO Auto-generated method stub
                System.out.println("匿名内部类 LoadSuccessEvent " + event.status);
            }
            
        });
        Observer<LoadSuccessEvent> loadEvent = new Observer<LoadSuccessEvent>() {

            @Override
            public void update(LoadSuccessEvent event) {
                // TODO Auto-generated method stub
                System.out.println("内部类 " + event.status + "  " + event.code);
            }
            
        };
        Bus.getInstance().register(loadEvent);
        Bus.getInstance().postEvent(new LoginEvent("login", 0)); 
        Bus.getInstance().postEvent(new LoadSuccessEvent("加载成功", 200));
    }

    public static class MyObserver implements Observer<LoginEvent>{
        public MyObserver() {
            Bus.getInstance().register(this);
        }

        @Override
        public void update(LoginEvent event) {
            // TODO Auto-generated method stub
            System.out.println("MyObserver 收到事件" + event.loString);
        }
        public void onDestory(){
            Bus.getInstance().unregister(this);
        }

    }

    public static class TestObserver implements Observer<LoginEvent> {
        
        public TestObserver() {
            Bus.getInstance().register(this);
        }

        @Override
        public void update(LoginEvent event) {
            // TODO Auto-generated method stub
            System.out.println("TestObserver 收到事件" + event.loString);

        }
    }
}
