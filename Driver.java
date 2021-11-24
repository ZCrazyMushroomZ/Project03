package PackageProject03;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Representing a Driver with a name.
 * @author Yulong Chen
 * @version 1.0
 */
public class Driver {
	public static void main(String[] args) throws Exception {
		creat();
	}	
  /**
   * Adding the file into the object, and calling infixTo() method and infixRuslt() method
   * @throws FileNotFoundException
   */
  static void creat() throws FileNotFoundException {
		String object;
		Scanner sc = new Scanner(new File("infix_text.txt"));
		//hasNext() read one line
		while(sc.hasNext()){
			//Read line one by one
			object = sc.nextLine();
			Expression myExpression = new Expression(object);
			//myExpression.ToString();
			System.out.println(myExpression.ToString());
		}		
	}
}
