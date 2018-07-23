/**
 * Created by Misha on 22.07.2018.
 */
public class LinkedListImpl implements LinkedList {

    private Item firstElement;
    private int size;

    @Override
    public int removeFirstItem() {
        return 0;
    }

    @Override
    public boolean removeSomewhere(int value) {
        return false;
    }

    @Override
    public void insert(int value) {
        Item newElement = new Item(value);
        if (isEmpty()) {
            firstElement = newElement;
        } else {
            newElement.setNextItem(firstElement);
            firstElement = newElement;
        }
         size++;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void display() {
        while(firstElement != null){
            System.out.println(firstElement.getValue());
            firstElement = firstElement.getNextItem();
        }
    }
}
