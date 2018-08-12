/**
 * Created by Misha on 08.08.2018.
 */
public class Main {
    public static void main(String[] args) {
        HashTableChainImpl hashList = new HashTableChainImpl();
        hashList.insert(new Item(10, "Morkva", 100));
        hashList.insert(new Item(20, "Moskva", 200));
        hashList.insert(new Item(31, "Mosova", 300));
        hashList.insert(new Item(11, "Mosova", 300));
        hashList.insert(new Item(25, "Mosova", 300));
        hashList.insert(new Item(27, "Mosova", 300));
        hashList.insert(new Item(24, "Mosova", 300));
        hashList.insert(new Item(21, "Mosova", 300));

        hashList.display();
        System.out.println(hashList.find(24));
        System.out.println(hashList.find(12));
        System.out.println(hashList.remove(10));
        System.out.println("-------");
        hashList.display();


    }
}
