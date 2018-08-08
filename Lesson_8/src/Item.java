/**
 * Created by Misha on 08.08.2018.
 */
public class Item {
    private final int id;
    private final int price;
    private final String label;
    private Item nextItem;

    public Item getNextItem() {
        return nextItem;
    }

    public void setNextItem(Item nextItem) {
        this.nextItem = nextItem;
    }

    public Item(int id, String label, int price) {
        this.id = id;
        this.label = label;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (price != item.price) return false;
        return label != null ? label.equals(item.label) : item.label == null;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", price=" + price +
                ", label='" + label + '\'' +
                '}';
    }
}
