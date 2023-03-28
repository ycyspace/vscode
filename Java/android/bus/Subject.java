package bus;


public interface Subject<T> {
    void notifyAllObservers();
}
