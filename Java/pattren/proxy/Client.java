package pattren.proxy;

public class Client {
    public static void main(String[] args) {
        Action action = new ProxyService(new Service());
        action.run();
    }
}
