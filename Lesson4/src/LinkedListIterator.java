/**
 * Created by Misha on 23.07.2018.
 */
public class LinkedListIterator {

    private Item currentItem;
    private Item previousItem;


    private LinkedListImpl list;

    public LinkedListIterator(LinkedListImpl list) {
        this.list = list;
        this.reset();
    }

    public void reset() {
        currentItem = list.getFirstItem();
        previousItem = null;
    }

    public boolean endList() {
        return currentItem.getNextItem() == null;
    }

    public void nextItem() {
        previousItem = currentItem;
        currentItem = currentItem.getNextItem();
    }

    public Item getCurrentItem() {
        return currentItem;
    }

    public void insertAfter(int value){
        Item newItem = new Item(value);
        if(list.isEmpty()){
            list.setFirstElement(newItem);
            currentItem = newItem;
        }                         else {
            newItem.setNextItem(currentItem.getNextItem());
            currentItem.setNextItem(newItem);
            nextItem();
        }

    }


    public int       deleteCurrent(){
        int value = currentItem.getValue();
        if(previousItem == null){
            list.setFirstElement(currentItem.getNextItem());
            reset();
        }           else{
            previousItem.setNextItem(currentItem.getNextItem());
            if(endList()){
                reset();
            }           else{
                currentItem = currentItem.getNextItem();
            }
        }
        return value;
    }


//    public LinkedListIterator getIterator(LinkedListImpl list) {
//        return new LinkedListIterator(this);
//    }
//    private boolean firstIterate = true;
//
//    private Item current;
//
//    public LinkedListIterator(LinkedList list) {
//        this.list = list;
//    }
//
//    @Override
//    public boolean hasNext() {
//        if (firstIterate) {
//            return list.getFirstElement() != null;
//        } else {
//            return current.getNextItem() != null;
//        }
//    }
//
//    @Override
//    public Integer next() {
//        if(current == null){
//            current = list.getFirstItem();
//        }
//        return null;
//    }
//
//    @Override
//    public void remove() {
//
//    }
}
