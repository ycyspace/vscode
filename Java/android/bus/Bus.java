package bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bus {
    private volatile static Bus instance;
    private Map<Class<?>, ArrayList<Observer>> eventMap = new HashMap<>();
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
    //todo 应该可以优化
    public <T> void register(Observer<T> observer, Class<?> clazz){
                if(eventMap.containsKey(clazz)){
                    eventMap.get(clazz).add(observer);
                }else{
                    ArrayList<Observer> observers = new ArrayList<>();
                    observers.add(observer);
                    eventMap.put(clazz, observers); 
                }
    }

    public <T> void unregister(Observer<T> observer, Class<T> clazz){
            if(eventMap.containsKey(clazz)){
                eventMap.get(clazz).remove(observer);
            }
    }

    public <T> void addEvent(Class<?> clzClass, Event<T> event) {
        if(!eventMap.containsKey(clzClass)){
            eventMap.put(clzClass, event.observers);
        }
    }

    public <T> void postEvent(Event<T> event){
        event.observers.clear();
        event.observers.addAll(eventMap.get(event.getClass()));
        event.notifyAllObservers();
    }
    
}
