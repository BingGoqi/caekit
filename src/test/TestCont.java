/**  
 * @Title: TestCont.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-11 07:36:45 
 */ 

package test;

/**  
 * @ClassName: TestCont
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-11 07:36:45 
*/

public class TestCont {

	/**  
	 * @MethodName: main
	 * @Description: TODO
	 * @author BingGoqi
	 * @param args void
	 * @date 2024-07-11 07:36:45 
	 */

	public static void main(String[] args) {
		test1();

	}
	static void test1() {
		byte a = 100;
		a+= 100;
		a+= 100;
		int b = Byte.toUnsignedInt(a);
		System.out.println(b);
	}
}
