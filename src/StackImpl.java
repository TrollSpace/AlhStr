/**
 * Created by Misha on 19.07.2018.
 */
public class StackImpl implements Stack {

    private int[] data;
    private int currentSize;

    public StackImpl(int maxSize) {
        this.currentSize = 0;
        this.data = new int[maxSize];
    }

    @Override
    public int pop() {
        return this.data[--currentSize];

    }

    @Override
    public void push(int value) {
        this.data[currentSize++] = value;

    }

    @Override
    public int peek() {
        return this.data[currentSize - 1];
    }

    @Override
    public int getSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize != 0;
    }

    @Override
    public boolean isFull() {
        return currentSize >= data.length;
    }
}
