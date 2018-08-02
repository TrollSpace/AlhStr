/**
 * Created by Misha on 01.08.2018.
 */
public interface Graph {

    void addVertex(String label);

    boolean addAdj(String fromLabel, String toLabel);

    boolean remove(String label);

    Vertex find(String label);

    int indexOf(String label);
}
