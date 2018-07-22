/**
 * Created by Misha on 23.07.2018.
 */
public class LinkedListQueueImpl implements Queue {

    private TwoWayLinkedList list;

    public LinkedListQueueImpl() {
        this.list = new TwoWayLinkedListImpl();
    }

    @Override
    public void insert(int value) {
        list.insertLast(value);
    }

    @Override
    public int remove() {
        return list.removeFirstItem();
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
