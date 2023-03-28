package android.bus;


public interface Subject<T> {
    void notifyAllObservers();
}
