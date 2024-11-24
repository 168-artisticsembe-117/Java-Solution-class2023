import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList<E extends Comparable<E>> implements Iterable<E> {
    private List<E> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(E element) {
        this.data.add(element);
    }

    public E remove(int index) {
        if (index < 0 || index > this.data.size()) {
            throw new IndexOutOfBoundsException("Index was out of bounds.");
        }

        return this.data.remove(index);
    }

    public boolean contains(E element) {
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        if (firstIndex < 0 || firstIndex > this.data.size()) {
            throw new IndexOutOfBoundsException("Index was out of bounds.");
        }

        if (secondIndex < 0 || secondIndex > this.data.size()) {
            throw new IndexOutOfBoundsException("Index was out of bounds.");
        }

        E firstElement = this.data.get(firstIndex);
        E secondElement = this.data.get(secondIndex);
        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
    }

    public int getCountOfElementsGreaterThan(E element) {
        int count = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public int size() {
        return this.data.size();
    }

    public E get(int index) {
        return this.data.get(index);
    }

    public E getMax() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }

        E max = this.data.get(0);
        for (int i = 1; i < data.size(); i++) {
            E current = this.data.get(i);
            if (current.compareTo(max) > 0) {
                max = current;
            }
        }

        return max;
    }

    public E getMin() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }

        E min = this.data.get(0);
        for (int i = 1; i < data.size(); i++) {
            E current = this.data.get(i);
            if (current.compareTo(min) < 0) {
                min = current;
            }
        }

        return min;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public E next() {
                return data.get(index++);
            }
        };
    }
}
