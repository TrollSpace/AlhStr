/**
 * Created by Misha on 30.07.2018.
 */
public interface Tree {

    void insert(int id);

    boolean remove(int id);

    boolean find(int id);

    int getSize();

    boolean isEmpty();

    int getRoot();
}
