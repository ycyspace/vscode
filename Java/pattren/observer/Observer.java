package pattren.observer;
/**
 * 观察者抽象类
 */
public interface Observer<T>{
    void subscribe(ObserveredSubject<T> observeredSubject);
    void unsubscribe(ObserveredSubject<T> observeredSubject);
    void update(ObserveredSubject<T> observeredSubject);
}
