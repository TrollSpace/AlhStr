import java.util.List;

/**
 * Created by Misha on 01.08.2018.
 */
public interface Graph {

    boolean addVertex(String label);

    boolean addAdj(String fromLabel, String toLabel);

    boolean remove(String label);

    Vertex find(String label);

    int indexOf(String label);

    boolean isEmpty();

    int getSize();

    void display();

    void bfs(String startLabel);

    List<String> findShortCutBetweenTwoDot(String moscow, String voronezh);
}
