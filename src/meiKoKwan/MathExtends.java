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
 * @Description: 扩展数学函数
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
	public static final double pow2(double a) {return a*a;}
	public static final double pow3(double a) {return a*a*a;}
	public static double ksmd(double p,int n) {
		double a = p;
		while(n > 1) {
			a *= (n&1)==1?p:a;
			n=n>>1;
		}
		return a;
	}
}
