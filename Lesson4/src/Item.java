/**
 * Created by Misha on 22.07.2018.
 */
public class Item {

    private final int value;

    private Item nextItem;

    public Item(int value) {
        this.value = value;
    }

    public int getValue() {

        return value;
    }

    public Item getNextItem() {
        return nextItem;
    }

    public void setNextItem(Item nextItem) {
        this.nextItem = nextItem;
    }

    @Override
    public String toString() {
        return "Item{" +
                "value=" + value + "]";
    }
}
