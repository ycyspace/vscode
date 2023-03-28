package android.bus;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Bus {
    private volatile static Bus instance;
    private Map<Class<?>, Event> eventMap = new HashMap<>();
    public static Bus getInstance(){
        if(instance == null){
            synchronized (Bus.class){
                if(instance == null){
                    instance = new Bus();
                }
            }
        }
        return instance;
    }

    private Bus() {
    }

    public <T> void register(Observer<T> observer){
        Type[] t = observer.getClass().getGenericInterfaces();
        for(Type type : t){
            ParameterizedType pt = (ParameterizedType) type;
            Class<T> trueType = (Class<T>) pt.getActualTypeArguments()[0];
            System.out.println("添加订阅 " + trueType.getSimpleName());
            if(eventMap.containsKey(trueType)){
                eventMap.get(trueType).observers.add(observer);
            }else{
                try {
                    Event<T> event = (Event<T>) trueType.newInstance();
                    if(event != null){
                        event.observers.add(observer);
                        eventMap.put(trueType, event);
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public <T> void unregister(Observer<T> observer){
        Type[] t = observer.getClass().getGenericInterfaces();
        for(Type type : t){
            ParameterizedType pt = (ParameterizedType) type;
            Class<T> trueType = (Class<T>) pt.getActualTypeArguments()[0];
            System.out.println( "取消订阅 " + trueType.getSimpleName());
            if(eventMap.containsKey(trueType)){
                eventMap.get(trueType).observers.remove(observer);
            }
        }
    }

    public <T> void addEvent(Class<?> clzClass, Event<T> event) {
        if(!eventMap.containsKey(clzClass)){
            eventMap.put(clzClass, event);
        }
    }

    public <T> void postEvent(Event<T> event){
        event.observers.addAll(eventMap.get(event.getClass()).observers);
        event.notifyAllObservers();
    }
    
}
