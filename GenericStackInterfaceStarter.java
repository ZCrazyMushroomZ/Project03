package PackageProject03;
/**
 * Representing a GenericStackInterfaceStarter<E> with a name.
 * @author Yulong Chen
 * @version 1.0
 */
public interface GenericStackInterfaceStarter<E> {
	/**
	 * Adds an item to the top of a stack
	 * @param item The name of input item
	 */
	 public void push(E item);
	 /**
	  * Removes the top of a stack
	  * @return The item that was most recently added to this stack
	  * @throws StackException Whether the stack is empty
	  */
	 public E pop() throws StackException;
	 /**
	  * Removes all items from stack
	  * @throws StackException Whether the stack is empty
	  */
	 public void popAll() throws StackException;
	 /**
	  * Show the top of stack
	  * @return The item that was most recently added to this stack
	  */
	 public E peek();
	 /**
	  * Judge whether the stack is null
	  * @return 1 or 0
	  */
	 public boolean isEmpty();
	 /**
	  * Return the length of stack
	  * @return The length of stack
	  */
	 public int size();

}
