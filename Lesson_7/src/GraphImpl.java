import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
    public boolean addVertex(String label) {
        if (size < vertexes.length) {
            Vertex newVertex = new Vertex(label);
            for (int i = 0; i < vertexes.length; i++) {
                if (vertexes[i] == null) {
                    vertexes[i] = newVertex;
                    size++;
                    return true;
                }

            }
        }
        return false;
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
        if (vertexIndex == -1) {
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
            if (vertexes[i] == null) {
                continue;
            }
            if (vertexes[i].getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public List<String> findShortCutBetweenTwoDot(String labelStart, String labelFinish) {
        Vertex vertexS = find(labelStart);
        Vertex vertexF = find(labelFinish);
        List<String> list = new ArrayList<>();
        if (vertexS == null) {
            return list;
        }
        Queue<Vertex> queue = new ArrayDeque();
        visit(vertexS, queue);

        while (!queue.isEmpty()) {
            vertexS = getAnyUnvisitedVertex(queue.element());
            if (vertexS == null) {
                vertexS = queue.remove();
                if (vertexS.equals(vertexF)) {
                    while (vertexS != null) {
                        list.add(vertexS.getLabel());
                        vertexS = vertexS.getPreLabel();
                    }

                }
            } else {
                vertexS.setPreLabel(queue.element());
                visit(vertexS, queue);
            }
        }

        return list;

    }

    @Override
    public void bfs(String startVertexLabel) {
        Vertex vertex = find(startVertexLabel);
        if (vertex == null) {
            return;
        }

        Queue<Vertex> queue = new ArrayDeque();
        visit(vertex, queue);

        while (!queue.isEmpty()) {
            vertex = queue.remove();
            Vertex currentVertex = null;
            while ((currentVertex = getAnyUnvisitedVertex(vertex)) != null) {
                visit(currentVertex, queue);
            }
        }

        resetVertexStates();
    }


    public Vertex getAnyUnvisitedVertex(Vertex vertex) {
        for (int i = 0; i < vertexes.length; i++) {
            Vertex currentVertex = vertexes[i];
            if (hasEdge(vertex, currentVertex) && !currentVertex.isWasVisited()) {
                return currentVertex;
            }
        }

        return null;
    }

    private boolean hasEdge(Vertex from, Vertex to) {
        return hasEdge(from.getLabel(), to.getLabel());
    }

    private boolean hasEdge(String fromLabel, String toLabel) {
        int from = indexOf(fromLabel);
        int to = indexOf(toLabel);
        if (from == -1 || to == -1)
            return false;

        return matrixAdj[from][to] == 1;
    }

    private void resetVertexStates() {
        for (int i = 0; i < vertexes.length; i++) {
            vertexes[i].setWasVisited(false);
        }
    }

    private void visit(Vertex vertex, Queue<Vertex> queue) {
        vertex.setWasVisited(true);
        queue.add(vertex);
    }

    private void visit(Vertex vertex, ArrayList<Vertex> list) {
        vertex.setWasVisited(true);
        list.add(vertex);
    }

    @Override
    public void display() {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == null) {
                continue;
            }
            String out = vertexes[i].toString();
            for (int j = 0; j < vertexes.length; j++) {
                if (matrixAdj[i][j] == 1) {
                    out += " -> " + vertexes[j];
                }
            }
            System.out.println(out);
        }
    }
}
