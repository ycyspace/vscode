Bus.getinstance() 获取总线单例对象  
register(Observer<T>, t.getClass()) 登记观察者， 通过反射获取泛型T类型和对应的Class对象，并放入Map<Class<?>, Event>  
unregister(Observer<T>, t.getClass()) 注销观察者  
postEvent(Event<T>) event 的class 对象获取观察者列表，再将观察者放入event中，调用所有观察者的update方法  
使用方法参考Client.java