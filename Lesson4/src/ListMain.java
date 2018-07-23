/**
 * Created by Misha on 22.07.2018.
 */
public class ListMain {
    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        LinkedListIterator itr = new LinkedListIterator(list);
        System.out.println(list.isEmpty());
        itr.insertAfter(1);
        itr.insertAfter(2);
        itr.insertAfter(13);
        itr.insertAfter(11);
        itr.insertAfter(111);

        list.display();
        itr.reset();
        itr.nextItem();
        itr.deleteCurrent();
        itr.nextItem();
        System.out.println(itr.getCurrentItem());
        list.display();

    }
}
