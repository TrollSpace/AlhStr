/**
 * Created by Misha on 22.07.2018.
 */
public interface LinkedList {

    int removeFirstItem();

    boolean removeSomewhere(int value);

    void insert(int value);

    int getSize();

    boolean isEmpty();

    void display();
}
