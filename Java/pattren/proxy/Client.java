package pattren.proxy;

/**
 * 代理设计模式是一种结构型设计模式，它允许你提供一个代替另一个对象的替代品，
 * 以控制对这个对象的访问。代理对象可以拦截对原始对象的访问，从而允许你在访问对象时添加额外的功能，
 * 例如记录日志、延迟加载、缓存等。
 */
public class Client {
    public static void main(String[] args) {
        Action action = new ProxyService();
        action.run();
        // ProxyFactory proxyFactory = new ProxyFactory(new Service());
        // Action proxy = (Action) proxyFactory.getInstance();
        // proxy.run();
    
    }
}
