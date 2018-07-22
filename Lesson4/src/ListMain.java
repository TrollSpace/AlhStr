/**
 * Created by Misha on 22.07.2018.
 */
public class ListMain {
    public static void main(String[] args) {
        LinkedList list = new LinkedListImpl();
        list.insert(1);
        list.insert(5);
        list.insert(143);
        list.insert(12);

        list.display();
    }
}
