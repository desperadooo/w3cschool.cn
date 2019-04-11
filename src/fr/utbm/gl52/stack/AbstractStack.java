/**
 * 
 */
package fr.utbm.gl52.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Abstract implementation of a stack.
 *
 * <p>No assumption is made on the internal data structure in which the elements are stored.
 * 
 * @param <T> type of the elements that are
 *     stored within the stack.
 * @author sgalland
 */
public abstract class AbstractStack<T> implements Stack<T> {

	@Override
	public final boolean isEmpty() {
		return size() == 0;
	}
	
	private final List<StackListener> observers = new ArrayList<>();

	@Override
	public final void addStackListener(StackListener listener) {
		assert listener != null;
		this.observers.add(listener);
	}
	
	@Override
	public final void removeStackListener(StackListener listener) {
		assert listener != null;
		this.observers.remove(listener);
	}

	/** Notify the observers about the addition of an element into the stack.
	 */
	protected final void fireElementAdded() {
		for (StackListener observer : this.observers) {
			observer.onElementAdded(this);
		}
	}

	/** Notify the observers about the removal of an element from the stack.
	 */
	protected final void fireElementRemoved() {
		for (StackListener observer : this.observers) {
			observer.onElementRemoved(this);
		}
	}
	
}
