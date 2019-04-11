/**
 * 
 */
package fr.utbm.gl52.stack;

import java.util.Iterator;

/** Stack implementation in which a linked list is used for storing the elements.
 *
 * @param <T> type of the elements that are
 *     stored within the stack.
 * @author alombard
 */
public class LinkedStack<T> extends AbstractStack<T> {

	private LinkedStackElement head;

	private int currentSize = 0;
	
	/** Construct an empty stack.
	 */
	public LinkedStack() {
		this.head = null;
	}

	@Override
	public T pop() {
		// Get the element at the head and remove the head
		final T element = this.head.getData();
		this.head = this.head.nextElement;
		this.currentSize--;
		fireElementRemoved();
		return element;
	}

	@Override
	public void push(T newElement) {
		// Create the new element and insert it at the head of the list
		this.head = new LinkedStackElement(newElement, this.head);
		this.currentSize++;
		fireElementAdded();
	}

	@Override
	public int size() {
		return this.currentSize;
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedStackIterator(this);
	}

	/**
	 * Internal class representing a linked stack element
	 */
	private class LinkedStackElement {
		private T data;
		private LinkedStackElement nextElement;

		public LinkedStackElement(T data, LinkedStackElement nextElement) {
			this.data = data;
			this.nextElement = nextElement;
		}

		public LinkedStackElement getNextElement() {
			return this.nextElement;
		}

		public T getData() {
			return this.data;
		}
	}

	/**
	 * Internal class representing an iterator
	 */
	private class LinkedStackIterator implements Iterator<T> {

		private LinkedStack<T> stack;

		private LinkedStackElement currentElement;

		/**
		 * Construct the iterator on the given internalList.
		 *
		 * @param stack the internalList to iterate on.
		 */
		public LinkedStackIterator(LinkedStack<T> stack) {
			this.stack = stack;
			this.currentElement = this.stack.head;
		}

		@Override
		public boolean hasNext() {
			return this.currentElement != null;
		}

		@Override
		public T next() {
			final T element = this.currentElement.getData();
			this.currentElement = this.currentElement.getNextElement();
			return element;
		}
	}
}
