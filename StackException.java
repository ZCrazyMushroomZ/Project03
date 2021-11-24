package PackageProject03;
/**
 * An exception that is thrown when stack overflow or stack underflow occurs.
 * @author Yulong Chen
 * @version 1.0
 */
public class StackException extends Exception {
	/**
	 * Constructs an exception with a specified message
	 * @param message The name of Exception
	 */
	public StackException(String message) {
		super(message);
	}

}
