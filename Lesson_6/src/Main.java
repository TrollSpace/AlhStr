import java.util.Random;

/**
 * Created by Misha on 30.07.2018.
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {

            Tree tree = new TreeImpl();
            initialTree(tree);
            System.out.println(tree.checkBalance());
        }
    }

    private static void initialTree(Tree tree) {
        while (tree.getLevel() < 5) {
            int x = (new Random().nextInt(201) - 100);
            System.out.print(x + " ");
            tree.insert(x);
        }
        System.out.println();
    }
}
