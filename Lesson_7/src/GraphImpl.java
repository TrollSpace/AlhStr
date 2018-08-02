/**
 * Created by Misha on 02.08.2018.
 */
public class GraphImpl implements Graph {

    private Vertex[] vertexes;
    private int[][] matrixAdj;
    private int size;

    public GraphImpl(int maxSize) {
        this.vertexes = new Vertex[maxSize];
        this.size = 0;
        initMatrixAdj(maxSize);

    }

    private void initMatrixAdj(int maxSize) {
        this.matrixAdj = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                matrixAdj[i][j] = 0;
            }

        }
    }

    @Override
    public void addVertex(String label) {
        Vertex newVertex = new Vertex(label);
        vertexes[size++] = newVertex;

    }

    @Override
    public boolean addAdj(String fromLabel, String toLabel) {
        int indexFrom = indexOf(fromLabel);
        int indexTo = indexOf(toLabel);
        if (indexFrom == -1 || indexTo == -1) {
            return false;
        }
        matrixAdj[indexFrom][indexTo] = 1;
        matrixAdj[indexTo][indexFrom] = 1;
        return true;
    }

    @Override
    public boolean remove(String label) {
        int vertexIndex = indexOf(label);
        if(vertexIndex == -1){
            return false;
        }
        for (int i = 0; i < size; i++) {
            matrixAdj[vertexIndex][i] = 0;
            matrixAdj[i][vertexIndex] = 0;
        }
        vertexes[vertexIndex] = null;
        size--;
        return true;
    }

    @Override
    public Vertex find(String label) {
        int i = indexOf(label);
        if (i == -1) {
            return null;
        }
        return vertexes[i];
    }

    @Override
    public int indexOf(String label) {
        for (int i = 0; i < size; i++) {
            if(vertexes[i] == null){
                continue;
            }
            if (vertexes[i].getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }
}