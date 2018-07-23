/**
 * Created by Misha on 19.07.2018.
 */
public interface Stack {

    int pop();

    void push(int value);

    int peek();

    int getSize();

    boolean isEmpty();

    boolean isFull();

}
