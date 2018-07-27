import java.util.ArrayList;

/**
 * Created by Misha on 26.07.2018.
 */
public class MaxPriceInBackPack {

    private ArrayList<Item> bestSetItems;

    private int maxPriceItems;

    private final int MAX_WEIGHT_ITEMS = 6;

    public MaxPriceInBackPack() {
        this.maxPriceItems = 0;
        this.bestSetItems = null;
    }

    private int sumWeight(ArrayList<Item> currentItems) {
        int sum = 0;
        for (Item item : currentItems) {
            sum += item.getWeight();
        }
        return sum;
    }

    private int sumPrice(ArrayList<Item> currentItems) {
        int sum = 0;
        for (Item item : currentItems) {
            sum += item.getPrice();
        }
        return sum;
    }

    private void balance(ArrayList<Item> currentItems) {
        if (bestSetItems == null) {
            if (sumWeight(currentItems) <= MAX_WEIGHT_ITEMS) {
                bestSetItems = currentItems;
                maxPriceItems = sumPrice(currentItems);
            }
        } else{
            if(sumWeight(currentItems)<=MAX_WEIGHT_ITEMS && sumPrice(currentItems)> maxPriceItems){
                bestSetItems = currentItems;
                maxPriceItems = sumPrice(currentItems);
            }
        }

    }

    public void checkAllSet(ArrayList<Item> currentItems){
        if(currentItems.size() > 0){
            balance(currentItems);
        }
        for(int i = 0; i < currentItems.size(); i++){
            ArrayList<Item> tempArr = new ArrayList<>(currentItems);
            tempArr.remove(i);
            checkAllSet(tempArr);
        }
    }

    public ArrayList<Item> rBestSet(){
        return bestSetItems;
    }
}
