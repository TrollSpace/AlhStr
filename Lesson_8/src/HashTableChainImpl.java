/**
 * Created by Misha on 08.08.2018.
 */
public class HashTableChainImpl implements HashTable {

    private Item[] data;
    private int size = 0;

    public HashTableChainImpl() {
        this.data = new Item[10];
    }

    @Override
    public void insert(Item item) {
        int hashValue = hashFunc(item);
        if (data[hashValue] != null) {
            Item currentItem = data[hashValue].getNextItem();
            if (currentItem == null) {
                data[hashValue].setNextItem(item);
            } else {
                while (currentItem.getNextItem() != null) {
                    currentItem = currentItem.getNextItem();
                }
                currentItem.setNextItem(item);
            }
        } else {
            data[hashValue] = item;
        }
        size++;
    }

    @Override
    public Item remove(int id) {
        Item returnedItem;
        int hashValue = id % data.length;
        if(data[hashValue].getId() == id){
            returnedItem = data[hashValue];
            data[hashValue] = data[hashValue].getNextItem();
            size--;
            return returnedItem;

        }
        Item previousDeletedItem = data[hashValue];
        if(previousDeletedItem!=null){
            if(previousDeletedItem.getNextItem().getId() == id){
                returnedItem = previousDeletedItem.getNextItem();
                previousDeletedItem.setNextItem(previousDeletedItem.getNextItem().getNextItem());
                size--;
                return returnedItem;
            }
        }
        return null;
    }

    @Override
    public Item find(int id) {
        int hashValue = id % data.length;

        Item currentItem = data[hashValue];
        if (currentItem != null) {
            if (currentItem.getId() != id) {
                currentItem = currentItem.getNextItem();
            } else {
                return currentItem;
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void display() {
        for (Item item : data) {
            System.out.println(item);
            if (item != null) {

                while (item.getNextItem() != null) {
                    item = item.getNextItem();
                    System.out.println(item);

                }
            }
        }

    }

    public int hashFunc(Item item) {
        return item.hashCode() % data.length;
    }
}
