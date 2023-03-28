package pattren.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // TODO Auto-generated method stub
                System.out.println("代理开始");
                Object result = method.invoke(target,args);
                System.out.println("代理结束");
                return result;
            }
            
        });
    }
    
    
}
