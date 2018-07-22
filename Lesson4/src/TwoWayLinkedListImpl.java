/**
 * Created by Misha on 23.07.2018.
 */
public class TwoWayLinkedListImpl extends LinkedListImpl implements TwoWayLinkedList {

    protected Item lastELement;

    public TwoWayLinkedListImpl() {
        super();
    }

    @Override
    public void insertLast(int value) {
        Item currentItem = new Item(value);
        if (isEmpty()) {
            firstElement = currentItem;
        } else {

            lastELement.setNextItem(currentItem);
        }
        lastELement = currentItem;
        size++;
    }

    @Override
    public void insert(int value) {
        Item newElement = new Item(value);
        if (isEmpty()) {
            lastELement = newElement;
        }
        firstElement = newElement;
        newElement.setNextItem(firstElement);
        size++;
    }

    @Override
    public int removeFirstItem() {
        int value = super.removeFirstItem();
        if(isEmpty()){
            lastELement = null;
        }
        return value;
    }

    @Override
    public Integer getLastElement() {
        return lastELement != null ? lastELement.getValue() : null;
    }
}
