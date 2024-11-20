import java.util.Arrays;
import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        data = new int[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
    }

    public void add(int element) {
        if (this.capacity == this.size) {
            resize();
        }
        data[size++] = element;
    }

    private void resize() {
        capacity *= 2;
        int[] copyArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            copyArray[i] = data[i];
        }
        data = copyArray;
    }

    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size)
            throw new ArrayIndexOutOfBoundsException(index + " index value is not compatible");
    }

    public int remove(int index) {
        checkIndex(index);
        int element = data[index];
        shiftLeft(index);
        size--;
        if (size <= capacity / 4)
            shrink();
        return element;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++)
            data[i] = data[i + 1];
        data[size - 1] = 0;
    }

    private void shrink() {
        capacity /= 2;
        int[] copyArray = new int[capacity];
        for (int i = 0; i < size; i++) {
            copyArray[i] = data[i];
        }
        data = copyArray;
    }

    public void add(int index, int element) {
        if (size == 0)
            add(element);
        else {
            checkIndex(index);
            if (index == size - 1) {
                add(data[size - 1]);
                data[size - 2] = element;
            } else {
                if (this.capacity == this.size)
                    resize();
                size++;
                shiftRight(index);
                data[index] = element;
            }
        }
    }

    private void shiftRight(int index) {
        for (int i = size - 1; i > index; i--)
            data[i] = data[i - 1];
        data[index] = 0;
    }

    public boolean contains(int element) {
        for (int i = 0; i < size; i++)
            if (data[i] == element)
                return true;
        return false;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++)
            consumer.accept(data[i]);
    }

    @Override
    public String toString() {
        return "SmartArray{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }
}
