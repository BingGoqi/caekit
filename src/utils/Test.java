/**  
 * @Title: Test.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-11 09:57:42 
 */ 

package utils;

//import java.math.BigDecimal;
import jdk.incubator.vector.*;
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
		float[] l1 = {0,1,2,3,4,5,6,7};
		float[] l2 = {9,8,7,6,5,4,3,2};
		VectorSpecies<Float> sf = FloatVector.SPECIES_PREFERRED;
		var va = FloatVector.fromArray(sf, l1, 0);
		var vb = FloatVector.fromArray(sf, l2, 0);
		var vc = va.add(vb);
		vc.intoArray(l1, 0);
		for(var i:l1) {
			System.out.print(i);
			System.out.print(" ");
		}
	}
}
