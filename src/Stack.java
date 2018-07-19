/**
 * Created by Misha on 19.07.2018.
 */
public interface Stack {

    char pop();

    void push(char value);

    char peek();

    int getSize();

    boolean isEmpty();

    boolean isFull();

}
