/**
 * Created by Misha on 22.07.2018.
 */
public class ListMain {
    public static void main(String[] args) {
        LinkedList list = new LinkedListImpl();
        System.out.println(list.isEmpty());
        list.insert(1);
        list.insert(5);
        list.insert(143);
        list.insert(12);
        list.insert(32);
        list.insert(14444);

        list.display();
        System.out.println(list.removeSomewhere(14444));
        list.display();
        System.out.println(list.isEmpty());
        System.out.println(list.getSize());
    }
}
