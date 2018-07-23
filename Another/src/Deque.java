/**
 * Created by Misha on 19.07.2018.
 */
public interface Deque {

    void insertLeft(int value);
    void insertRight(int value);

    int removeLeft();
    int removeRight();

    int getSize();

    boolean isEmpty();

    boolean isFull();

}
