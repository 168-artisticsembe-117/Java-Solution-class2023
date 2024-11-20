import java.util.Arrays;
import java.util.function.Consumer;

public class CustomStack {
    private static final int INITIAL_CAPACITY = 4;
    private int[] items;
    private int size;
    private int capacity;

    public CustomStack() {
        items = new int[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
    }

    public int getSize() {
        return this.size;
    }

    public void push(int element) {
        if (this.capacity == this.size)
            resize();
        items[size++] = element;
    }

    private void resize() {
        capacity *= 2;
        int[] copyArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            copyArray[i] = items[i];
        }
        items = copyArray;
    }

    public int pop() {
        return remove(size - 1);
    }

    private int remove(int index) {
        checkIndex(index);
        int item = items[index];
        shiftLeft(index);
        size--;
        if (size <= capacity / 4)
            shrink();
        return item;
    }

    public int peek() {
        return get(size - 1);
    }

    private int get(int index) {
        checkIndex(index);
        return items[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size)
            throw new ArrayIndexOutOfBoundsException(index + " index value is not compatible");
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++)
            consumer.accept(items[i]);
    }

    private void shrink() {
        capacity /= 2;
        int[] copyArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            copyArray[i] = items[i];
        }
        items = copyArray;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++)
            items[i] = items[i + 1];
        items[size - 1] = 0;
    }

    @Override
    public String toString() {
        return "CustomStack{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
