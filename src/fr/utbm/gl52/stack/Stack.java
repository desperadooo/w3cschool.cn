package fr.utbm.gl52.stack;

/** Interface that represents the public API
 * of a stack of object.
 *
 * <p>A stack is a data structure in which elements are
 * stored with a LIFO (last-in first-out) policy.
 * 
 * @param <T> type of the elements that are
 *     stored within the stack.
 * @author sgalland
 */
public interface Stack<T> extends Iterable<T> {

	/** Remove the element at the top of the stack and replies it.
	 *
	 * <p>If the stack is empty, a {@link IllegalStateException}
	 * is thrown.
	 *
	 * @return the element that was at the top of the stack.
	 */
	T pop();

	/** Push the given element at the top of the
	 * other elements within the stack.
	 *
	 * <p>If the element is already stored within the stack, the
	 * element e is still added.
	 *
	 * @param newElement the element to add.
	 */
	void push(T newElement);
	
	/** Replies if the stack contains a least one element.
	 *
	 * @return {@code true} if the stack contains no element.
	 *     {@code false} if the stack contains at least
	 *     one element.
	 */
	boolean isEmpty();
	
	/** Replies the number of elements that
	 * are stored into the stack.
	 *
	 * @return a positive or zero integer number.
	 */
	int size();
	
	/** Add an observer on the changes within the stack.
	 *
	 * @param listener the observer.
	 */
	void addStackListener(StackListener listener);
	
	/** Remove an observer on the changes within the stack.
	 *
	 * @param listener the observer.
	 */
	void removeStackListener(StackListener listener);

}
