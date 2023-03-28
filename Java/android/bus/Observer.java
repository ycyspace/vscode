package android.bus;

public interface Observer<T> {
    void update(T event);
}
