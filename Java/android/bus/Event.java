package bus;

import java.util.ArrayList;

public abstract class Event<T> implements Subject<T> {
    ArrayList<Observer> observers = new ArrayList<>();
    public Event() {
        Bus.getInstance().addEvent(getClass(), this);
    }

    public abstract T initEvent();


    @Override
    public void notifyAllObservers() {
        // TODO Auto-generated method stub
        for (Observer<T> observer : observers) {
            if(observer != null){
                observer.update(initEvent());
            }
        }
    }

}
