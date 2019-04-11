package fr.utbm.gl52.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Stack implementation in which an array list is used for storing the elements.
 *
 * @param <T> type of the elements that are
 *     stored within the internalList.
 * @author alombard
 */
public class ArrayStack<T> extends AbstractStack<T> {

    private final List<T> internalList = new ArrayList<>();

    @Override
    public T pop() {
        final T element = this.internalList.remove(this.internalList.size() - 1);
        fireElementRemoved();
        return element;
    }

    @Override
    public void push(T newElement) {
        this.internalList.add(newElement);
        fireElementAdded();
    }

    @Override
    public int size() {
        return this.internalList.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator(this);
    }

    private class ArrayStackIterator implements Iterator<T> {

        private ArrayStack<T> stack;

        private int currentIndex;

        /**
         * Construct the iterator on the given internalList.
         *
         * @param stack the internalList to iterate on.
         */
        public ArrayStackIterator(ArrayStack<T> stack) {
            this.stack = stack;
            this.currentIndex = this.stack.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public T next() {
            return stack.internalList.get(currentIndex--);
        }
    }
}
