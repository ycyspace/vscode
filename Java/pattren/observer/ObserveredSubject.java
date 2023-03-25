package pattren.observer;
/**
 * 被观察者抽象类
 */

import java.util.Set;

public abstract class ObserveredSubject<T> {
    /*
     * 观察者集合
     */
    Set<Observer<T>> observers;
    /**
     * 观察目标
     */
    T subject;
    abstract void notifyAllObservers();
}
