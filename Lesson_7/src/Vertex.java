/**
 * Created by Misha on 01.08.2018.
 */
public class Vertex {
    private String label;

    private Vertex preLabel;

    private boolean wasVisited = false;

    public Vertex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public Vertex getPreLabel() {
        return preLabel;
    }

    public void setPreLabel(Vertex preLabel) {
        this.preLabel = preLabel;
    }


    @Override
    public String toString() {
        return label;
    }

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }
}
