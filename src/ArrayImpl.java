/**
 * Created by Misha on 13.07.2018.
 */
public class ArrayImpl implements Array {

    protected int sizeX;
    protected int[] arrData;

    public ArrayImpl(int size) {
        this.sizeX = 0;
        this.arrData = new int[size];
    }

    public int getSizeX() {
        return sizeX;
    }

    public void printArr() {
        for (int i = 0; i < sizeX; i++) {
            System.out.println(arrData[i]);
        }
    }

    @Override
    public void addElement(int value) {
        arrData[sizeX] = value;
        sizeX++;

    }

    @Override
    public boolean deleteElement(int value) {
        int indexDelElement = findElement(value);

        if (indexDelElement < 0) {
            return false;
        } else {
            for (int i = indexDelElement; i < sizeX - 1; i++) {
                arrData[i] = arrData[i + 1];
            }
        }
        sizeX--;
        return true;
    }

    @Override
    public int getElement(int index) {
        return arrData[index];
    }

    @Override
    public int findElement(int value) {
        for (int i = 0; i < sizeX; i++) {
            if (arrData[i] == value) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public void bubbleSort() {
        for (int i = 0; i < sizeX - 1; i++) {
            for (int j = 0; j < sizeX - 1 - i; j++) {
                if (arrData[j] > arrData[j + 1]) {
                    exchange(j, j + 1);
                }

            }

        }

    }

    @Override
    public void selectSort() {
        for (int i = 0; i < sizeX-1; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (arrData[i] < arrData[j]) {
                    exchange(i, j);
                }
            }

        }

    }

    @Override
    public void insertSort() {
        for (int i = 1; i < sizeX; i++) {
            for (int j = i; j > 0; j--) {
                if(arrData[j] < arrData[j-1]){
                    exchange(j, j-1);
                }

            }
        }

    }

    private void exchange(int one, int two) {
        int temp = arrData[one];
        arrData[one] = arrData[two];
        arrData[two] = temp;
    }
}
