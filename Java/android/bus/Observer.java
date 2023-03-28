package bus;

public interface Observer<T> {
    void update(T event);
}
