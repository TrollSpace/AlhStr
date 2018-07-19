/**
 * Created by Misha on 19.07.2018.
 */
public interface Queue {

    void insert(int value);

    int remove();

    int peekFront();

    int getSize();

    boolean isEmpty();

    boolean isFull();
}
