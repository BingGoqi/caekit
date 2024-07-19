/**  
 * @Title: MathExtends.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-04 03:30:04 
 */ 

package meiKoKwan;

import static java.lang.Math.*;
/**  
 * @ClassName: MathExtends
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-04 03:30:04 
*/

public class MathExtends {
	public static final double asinh(double x) {
		return Math.log(x+sqrt(1+x*x));
	}
	public static final boolean round(double a,double b) {
		return (Math.abs(a-b)<1e-8);
	}
}
