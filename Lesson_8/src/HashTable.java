/**
 * Created by Misha on 08.08.2018.
 */
public interface HashTable {

    boolean insert(Item item);

    Item remove(int id);

    Item find(int id);

    int getSize();

    int isEmpty();


}
