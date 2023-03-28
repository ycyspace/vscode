package android.bus;

import java.util.ArrayList;
import java.util.List;

public abstract class Event<T> implements Subject<T> {
    List<Observer<T>> observers = new ArrayList<>();
    T t;
    public Event() {
        Bus.getInstance().addEvent(getClass(), this);
    }


    @Override
    public void notifyAllObservers() {
        // TODO Auto-generated method stub
        for (Observer<T> observer : observers) {
            observer.update(t);
        }
    }

}
