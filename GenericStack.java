package PackageProject03;
import java.util.ArrayList;
/**
 * Representing a GenericStack<E> with a name.
 * @author Yulong Chen
 * @version 1.0
 */
public class GenericStack<E> implements GenericStackInterfaceStarter{
	/**
	 * The arrayList containing the items of this stack
	 */
	private ArrayList<E> list = new ArrayList<E>();
	/**
	 * Adds an item to the top of a stack
	 * @param item The name of input item
	 */
	@Override
	public void push(Object item) {
			list.add((E) item);
	}
	/**
	  * Removes the top of a stack
	  * @return The item that was most recently added to this stack
	  * @throws StackException Whether the stack is empty
	  */
	@Override
	public E pop() throws StackException {
		if (!isEmpty()) {
		     return list.remove(list.size() - 1);
		    }else {
		    	throw new StackException("The stack is empty.");
		    }
	}
	 /**
	  * Removes all items from stack
	  * @throws StackException Whether the stack is empty
	  */
	@Override
	public void popAll() throws StackException {
		if (!isEmpty()) {
			list.clear();
		    }else {
		    	throw new StackException("The stack is empty.");
		    }
	}
	/**
	  * Show the top of stack
	  * @return The item that was most recently added to this stack
	  */
	@Override
	public E peek() {
		return this.list.get(list.size() - 1);
	}
	/**
	  * Judge whether the stack is null
	  * @return 1 or 0
	  */
	@Override
	public boolean isEmpty() {
		return (list.size() == 0);
	}
	 /**
	  * Return the length of stack
	  * @return The length of stack
	  */
	@Override
	public int size() {	
		return list.size();
	}

}
