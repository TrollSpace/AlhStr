import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 1. Создать массив большого размера (миллион элементов).
 * 2. Написать методы удаления, добавления, поиска элемента массива.
 * 3. Заполнить массив случайными числами.
 * 4. Написать методы, реализующие рассмотренные виды сортировок и проверить скорость выполнения каждой.
 */
public class Main {
    public static void main(String[] args) {
        int size = 1000000; // на этом размере компьютер начинает заикаться =)
        ArrayImpl numbers1 = new ArrayImpl(size);
        ArrayImpl numbers2 = new ArrayImpl(size);
        ArrayImpl numbers3 = new ArrayImpl(size);
        for (int i = 0; i < size; i++) {
            int x = new Random().nextInt(size);
            numbers1.addElement(x);
            numbers2.addElement(x);
            numbers3.addElement(x);
        }
        long start = System.currentTimeMillis();
        numbers2.bubbleSort();
        long finish = System.currentTimeMillis();
        System.out.println(finish-start);
        start = System.currentTimeMillis();
        numbers1.selectSort();
        finish = System.currentTimeMillis();
        System.out.println(finish-start);
        start = System.currentTimeMillis();
        numbers3.insertSort();
        finish = System.currentTimeMillis();
        System.out.println(finish-start);

    }
}
