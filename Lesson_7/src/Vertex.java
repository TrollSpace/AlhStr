/**
 * Created by Misha on 01.08.2018.
 */
public class Vertex {
    private String label;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
