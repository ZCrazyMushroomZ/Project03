package PackageProject03;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * Representing an Expression with a name.
 * @author Yulong Chen
 * @version 1.0
 */
public class Expression {
	/**
	 * A name of String type, to store input data
	 */
	private String object;
	/**
	 * Basic constructor
	 */
	public Expression() {}
	/**
	 * Calling infixTo() method and infixResult() method
	 * @param object The name of input date
	 */
	public Expression(String object) {
		this.object = object;
		try {
			infixResult(object);
		} catch (StackException e) {
			e.printStackTrace();
		}
	}
    /**
     * Return the object
     * @return Return the object
     */
	public Object getObject() {
		return object;
	}
    /**
     * Change the data
     * @param object The name of insert data
     */
	public void setObject(String object) {
		this.object = object;
	}
	
	
	/**
	 * Making inFix to postFix
	 * @param object The name of insert data
	 * @return The postFix
	 * @throws StackException
	 */
	private String infixTo(String object) throws StackException {
		GenericStack<Object> stack = new GenericStack<Object>();
		String postfix = null;
		//creating a object of ArrayList<String>
		ArrayList<String> postfix1 = new ArrayList<>();
		//using StringTokenizer method to divide every character
		StringTokenizer st = new StringTokenizer(object,"()+-*/ ", true);
		while(st.hasMoreElements()) {//if the object is not null
			String str = st.nextToken();
			if(isNumber(str)) {//object is number
				postfix1.add(str);
			}else if(isOperator(str)) {//object is operator
				//if meeting empty stack or "(" or priority of str is higher than the top of stack. derectly push into stack
				if(stack.isEmpty() || "(".equals(stack.peek()) || priority((String) str) >= priority((String) stack.peek())) {
					stack.push(str);
				}else {
					while(!stack.isEmpty() && !"(".equals(stack.peek())) {
						//determine the priority
					if(priority(str) < priority((String) stack.peek())) {
						postfix1.add((String) stack.pop());
						}
					}
				stack.push(str);
				}
				
			}else if("(".equals(str)) {//the left parenthesis is pushed directly onto the stack
				stack.push(str);
			}else if(")".equals(str)) {//meeting the right parenthesis 
				String n = str;
				while(!stack.isEmpty()) {
					if("(".equals(n)) {//over when meet the left parenthesis
						stack.pop();
						break;
					}else {
						//pop the top element of stack to postfix1
						postfix1.add((String) stack.pop());
						//using n to record the top element of stack
						n = (String) stack.peek();
					}	
				}
			}else if(" ".equals(str)) {//object is null
				
		}else {//if object is illegal
				throw new StackException("This is an illegal character.");
			}
		}
		if(!stack.isEmpty()) {//if stack have element
			postfix1.add((String) stack.pop());
		}
		//the change of ArrayList to String
		postfix = String.join(" ", postfix1);
		return postfix;
	}
	/**
	 * Calculate the result of postFix
	 * @param object The name of insert data
	 * @return The result of postFix
	 * @throws StackException
	 */
	private String infixResult(String object) throws StackException {
		//Calling the infixTo method
		String postfix = infixTo(object);
		String result = null;
		GenericStack<Object> stack = new GenericStack<Object>();
		StringTokenizer st = new StringTokenizer(postfix," ");
		while(st.hasMoreElements()){//if the postFix have element
			String str = st.nextToken();
			if(isNumber(str)) {//postFix is number
				stack.push(str);
			}else if(isOperator(str)) {//postFix is operator
				if(str.equals("+")) {//num1 + num2
					//change the string to int
					float num1 = Float.parseFloat((String) stack.pop());
					float num2 = Float.parseFloat((String) stack.pop());
					String s = String.valueOf(num1 + num2);
					stack.push(s);
				}else if(str.equals("-")) {//num2 - num1
					//change the string to int
					float num1 = Float.parseFloat((String) stack.pop());
					float num2 = Float.parseFloat((String) stack.pop());
					String s = String.valueOf(num2 - num1);
					stack.push(s);
				}else if(str.equals("*")) {//num1 * num2
					//change the string to int
					float num1 = Float.parseFloat((String) stack.pop());
					float num2 = Float.parseFloat((String) stack.pop());
					String s = String.valueOf(num2 * num1);
					stack.push(s);
			    }else if(str.equals("/")) {//num2 / num1
			    	//change the string to int
			    	float num1 = Float.parseFloat((String) stack.pop());
					float num2 = Float.parseFloat((String) stack.pop());
					String s = String.valueOf(num2 / num1);
					stack.push(s);
		        }		       
	       }
		}
		result = (String) stack.pop();
		return result;
	}
		
    /**
     * Return the result
     * @return Return the result
     */
    public String ToString() {
    	String postfix = null;
    	String result = null;
    	String postfix1 = null;
		try {
			postfix = infixTo(this.object);
			postfix1 = postfix.replace(" ", "");
			result = infixResult(this.object);
		} catch (StackException e) {
			e.printStackTrace();
		}
		return this.object + " -> " + postfix1 + " = " +result;
    }
	/**
	 * Determine whether object is a number
	 * @param object The name of object
	 * @return True if object is number, False if object is not number
	 */
	public static boolean isNumber(String object) {
		// Using regular expression to judge whether object is number
		return object.matches("\\d+");
	}
	/**
	 * Determine whether op equal to "+ - * /"
	 * @param op The name of operator
	 * @return True if op is "+ - * /", False if op is not " + - * /"
	 */
	public static boolean isOperator(String op) {
		return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
	}
	/**
	 * Determine the priority of operators
	 * @param op The name of operator
	 * @return the priority of the operator(0,1,-1)
	 */
	public static int priority(String op) {
		if(op.equals("*") || op.equals("/")) {
			return 1;
		}else if(op.equals("+") || op.equals("-")) {
			return 0;
		}
		return -1;
	}

}
