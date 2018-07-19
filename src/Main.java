
/*
    1. Реализовать рассмотренные структуры данных в консольных программах.
    2. Создать программу, которая переворачивает вводимые строки (Читает справа налево).
    3. Создать класс для реализации дека.
 */
public class Main {
    public static void main(String[] args) {
        int size = 3;
        Stack st = new StackImpl(size);
        for (int i = 0; i < size; i++) {
            int x = (int) (Math.random() * 100);
            System.out.println(x);
            st.push(x);
        }

        while (st.isEmpty()) {
            System.out.println(st.pop());
        }


    }
}
