import java.util.ArrayList;

/**
 * Created by Misha on 25.07.2018.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(exponentiation(13, -2));



        ArrayList<Item> pack = new ArrayList<>();
        initArrList(pack);

        MaxPriceInBackPack maxPrice = new MaxPriceInBackPack();
        maxPrice.checkAllSet(pack);

        System.out.println(maxPrice.rBestSet());


    }

    private static void initArrList(ArrayList<Item> items){
        Item book = new Item("книга",1, 600);
        Item notebook = new Item("ноутбук",2, 40000);
        Item binocular = new Item("бинокль",2, 5000);
        Item pot = new Item("котелок",1, 500);
        Item firstAidKit = new Item("аптечка",4, 1500);

        items.add(book);
        items.add(notebook);
        items.add(binocular);
        items.add(pot);
        items.add(firstAidKit);

    }


    private static double exponentiation(double value, double exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent > 0) {
            return value * exponentiation(value, exponent - 1);
        } else {
            return 1 / value * (exponentiation(value, exponent + 1));
        }
    }


}
