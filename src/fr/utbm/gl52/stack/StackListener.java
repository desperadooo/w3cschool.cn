package fr.utbm.gl52.stack;

import java.util.EventListener;

/** Observer on the changes of the content of a stack.
 * 
 * @author sgalland
 */
public interface StackListener extends EventListener {

	/** Invoked when an element was added into the given stack.
	 *
	 * @param stack the changed stack.
	 */
	void onElementAdded(Stack<?> stack);
	
	/** Invoked when an element was removed from the given stack.
	 *
	 * @param stack the changed stack.
	 */
	void onElementRemoved(Stack<?> stack);

}
