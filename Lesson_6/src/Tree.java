/**
 * Created by Misha on 30.07.2018.
 */
public interface Tree {

    enum TraverseMode{
        PRE_ORDER,
        POST_ORDER,
        IN_ORDER,
    }

    void insert(int id);

    boolean remove(int id);

    boolean find(int id);

    int getSize();

    boolean isEmpty();

    int getRoot();

    int getLevel();

    void traverse (TraverseMode traverseMode);

    boolean checkBalance();
}
