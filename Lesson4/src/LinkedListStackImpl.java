/**
 * Created by Misha on 23.07.2018.
 */
public class LinkedListStackImpl implements Stack {

    private LinkedList list;

    public LinkedListStackImpl() {
        this.list = new LinkedListImpl();
    }

    @Override
    public int pop() {
        return list.removeFirstItem();
    }

    @Override
    public void push(int value) {
        list.insert(value);

    }

    @Override
    public int peek() {
        return list.getFirstElement();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
