import java.util.List;

/**
 * Created by Misha on 02.08.2018.
 */
public class Main {
    public static void main(String[] args) {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Moscow");
        graph.addVertex("Tula");
        graph.addVertex("Lipetsk");
        graph.addVertex("Voronezh");
        graph.addVertex("Ryazan");
        graph.addVertex("Tambov");
        graph.addVertex("Saratov");
        graph.addVertex("Kaluga");
        graph.addVertex("Orel");
        graph.addVertex("Kursk");

        graph.addAdj("Moscow", "Tula");
        graph.addAdj("Moscow", "Ryazan");
        graph.addAdj("Moscow", "Kaluga");

        graph.addAdj("Tula", "Lipetsk");
        graph.addAdj("Lipetsk", "Voronezh");
        graph.addAdj("Voronezh", "Saratov");
        graph.addAdj("Voronezh", "Kursk");

        graph.addAdj("Tambov", "Ryazan");
        graph.addAdj("Tambov", "Saratov");
        graph.addAdj("Orel", "Kaluga");
        graph.addAdj("Orel", "Kursk");

        graph.display();

        graph.bfs("Moscow");
        List<String> list = graph.findShortCutBetweenTwoDot("Moscow", "Voronezh");
        for (String s : list) {
            System.out.print(s + "->");

        }
        System.out.println();

    }
}
