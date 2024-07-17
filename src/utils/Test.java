/**  
 * @Title: Test.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-11 09:57:42 
 */ 

package utils;

//import java.math.BigDecimal;
//import jdk.incubator.vector.*;
import meiKoKwan.MathExtends;
/**  
 * @ClassName: Test
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-11 09:57:42 
*/

public class Test {

	/**  
	 * @MethodName: main
	 * @Description: TODO
	 * @author BingGoqi
	 * @param args void
	 * @date 2024-06-11 09:57:42 
	 */

	public static void main(String[] args) {
		double e,m,f;
		e = 0.999999999;
		m = 3.1;
		f = MathExtends.KeplerSolve(e, m);
		System.out.println(f);
	}
}
