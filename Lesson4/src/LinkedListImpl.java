/**
 * Created by Misha on 22.07.2018.
 */
public class LinkedListImpl implements LinkedList {

    private Item firstElement;
    private int size;

    @Override
    public int removeFirstItem() {
        if(firstElement == null){
            throw new IllegalAccessError("Пустой список");
        }
        int value = firstElement.getValue();

        Item nextItem = firstElement.getNextItem();
        firstElement.setNextItem(null);
        firstElement = nextItem;
        return value;
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
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public void display() {
        Item currentItem = firstElement;  // Подумал можно обойтись без current, но понял свою ошибку быстро. =)
        while (currentItem != null) {
            System.out.println(currentItem.getValue());
            currentItem = currentItem.getNextItem();
        }
    }
}
