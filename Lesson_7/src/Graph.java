/**
 * Created by Misha on 01.08.2018.
 */
public interface Graph {

    void add(Vertex vertex);

    boolean remove(String label);

    Vertex find(String label);
}
