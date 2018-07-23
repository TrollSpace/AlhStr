/*
    1. Реализовать рассмотренные структуры данных в консольных программах.
    2. Создать программу, которая переворачивает вводимые строки (Читает справа налево).
    3. Создать класс для реализации дека.
 */
public class Main {
    public static final int ARR_SIZE = 10;

    public static void main(String[] args) {

        Stack st = new StackImpl(ARR_SIZE);
        Queue qu = new QueueImpl(ARR_SIZE);
        Deque dequ = new DequeImpl(ARR_SIZE);

        initializeStack(st);
        initializeQueue(qu);
        initializeDequeue(dequ);

        while (!dequ.isEmpty()) {
            System.out.println(dequ.removeRight());
            System.out.println(dequ.removeLeft());
        }


    }

    public static void initializeDequeue(Deque deque) {
        for (int i = 0; i < ARR_SIZE/2; i++) {
            deque.insertLeft(i);
            deque.insertRight(i);
        }
    }


    public static void initializeStack(Stack stack) {
        for (int i = 0; i < ARR_SIZE; i++) {
            stack.push(i);
        }

    }

    public static void initializeQueue(Queue queue) {
        for (int i = 0; i < ARR_SIZE; i++) {
            queue.insert(i);
        }
    }
}
