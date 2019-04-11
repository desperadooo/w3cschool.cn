package fr.utbm.gl52.tests.tp1;

import fr.utbm.gl52.stack.ArrayStack;
import fr.utbm.gl52.stack.Stack;
import fr.utbm.gl52.stack.StackListener;

import java.util.Iterator;

@SuppressWarnings("all")
public class ArrayStackTest {
	
	public static void main(String[] args) {
		final Stack<String> stack = new ArrayStack<>();

		final StackListener observer = new StackListener() {
			@Override
			public void onElementRemoved(Stack<?> stack) {
				System.out.println("element was removed"); //$NON-NLS-1$
			}
			@Override
			public void onElementAdded(Stack<?> stack) {
				System.out.println("element was added"); //$NON-NLS-1$
			}
		};

		stack.addStackListener(observer);
		
		stack.push("1"); //$NON-NLS-1$
		stack.push("2"); //$NON-NLS-1$
		stack.push("3"); //$NON-NLS-1$
		stack.push("4"); //$NON-NLS-1$
		
		System.out.println("with  iterator:"); //$NON-NLS-1$
		Iterator<String> iterator = stack.iterator();
		while (iterator.hasNext()) {
			final String element = iterator.next();
			System.out.println(element);
		}

		stack.push("5"); //$NON-NLS-1$
		stack.push("6"); //$NON-NLS-1$
		stack.push("7"); //$NON-NLS-1$
		stack.push("8"); //$NON-NLS-1$
		
		System.out.println("with foreach loop:"); //$NON-NLS-1$
		for (String element : stack) {
			System.out.println(element);
		}
	}

}
