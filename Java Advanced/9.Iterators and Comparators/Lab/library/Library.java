

import java.util.Iterator;

public class Library<T> implements Iterable<T>{

    private T[] books;

    public Library(T... books) {
        this.books = books;
    }

    @Override
    public Iterator<T> iterator() {
        return new LibIterator();
    }

    private class LibIterator implements Iterator<T> {
        int counter = 0;

        @Override
        public boolean hasNext() {
            return books.length > counter;
        }

        @Override
        public T next() {
            return books[counter++];
        }
    }
}
