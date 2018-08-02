/**
 * Created by Misha on 02.08.2018.
 */
public class Main {
    public static void main(String[] args) {
        Graph graph = new GraphImpl(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addAdj("A", "B");
        graph.addAdj("A", "C");
        graph.addAdj("A", "D");

        graph.addAdj("B", "E");
        graph.addAdj("C", "F");
        graph.addAdj("D", "G");
        graph.addAdj("E", "H");

        graph.addAdj("C", "G");
        graph.addAdj("D", "H");

        graph.remove("A");
        System.out.println(graph.find("B"));


    }
}
