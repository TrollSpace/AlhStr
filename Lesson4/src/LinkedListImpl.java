/**
 * Created by Misha on 22.07.2018.
 */
public class LinkedListImpl implements LinkedList {

    public void setFirstElement(Item firstElement) {
        this.firstElement = firstElement;
    }

    protected Item firstElement;
    protected int size;

    public LinkedListImpl() {
        this.size = 0;
    }

    @Override
    public int removeFirstItem() {
        if (firstElement == null) {
            throw new IllegalAccessError("Пустой список");
        }
        int value = firstElement.getValue();

        Item nextItem = firstElement.getNextItem();
        firstElement.setNextItem(null);
        firstElement = nextItem;
        size--;
        return value;
    }

    @Override
    public boolean removeSomewhere(int value) {
        Item currentItem = firstElement;
        Item previousItem = null;

        while (currentItem != null) {
            if (currentItem.getValue() == value) {
                break;
            }
            previousItem = currentItem;
            currentItem = currentItem.getNextItem();
        }

        if (currentItem == null) {
            return false;
        }
        if (currentItem == firstElement) {
            removeFirstItem();                  // А так можно? Или надо явно?
        } else {
            Item nextItem = currentItem.getNextItem();
            previousItem.setNextItem(nextItem);
        }

        size--; //Забыли этот дикримент
        return true;
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

    @Override
    public Integer getFirstElement() {
        return firstElement != null ? firstElement.getValue() : null;
    }

    @Override
    public Item getFirstItem() {
        return firstElement;
    }

    @Override
    public boolean find(int value) {
        Item currentItem = firstElement;
        while (currentItem != null) {
            if (currentItem.getValue() == value) {
                return true;
            } else {
                currentItem = currentItem.getNextItem();
            }
        }
        return false;
    }
}
