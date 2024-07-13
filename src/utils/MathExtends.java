/**  
 * @Title: MathExtends.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-04 03:30:04 
 */ 

package utils;

import static java.lang.Math.*;
/**  
 * @ClassName: MathExtends
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-04 03:30:04 
*/

public class MathExtends {
	public static double asinh(double x) {
		return Math.log(x+sqrt(1+x*x));
	}
	private static double KSart3(double e,double M) {
		double t33,t34,t35;
		t33 = cos(M);
		t34 = e*e;
		t35 = t34*e;
		return M+(-.5*t35+e+(t34+1.5*t33*t35)*t33*sin(M));
	}
	private static double Keps3(double e,double M,double x) {
		double t1,t2,t3,t4,t5,t6;
		t1 = cos(x);
		t2 = e*t1-1;
		t3 = sin(x);
		t4 = e*t3;
		t5 = -x+t4+M;
		t6 = t5/(.5*t5*t4/t2+t2);
		return t5/((.5*t3-t1*t6/6)*e*t6+t2);
	}
	public static double KeplerSolve(double e,double M) {
		M = M%TAU;
		e = abs(e);
		if(1 < e) {
			return 0;
		}else if(1 == e) {
			return 2*atan(2*sinh(asinh(1.5*M)/3));
		} else if(0 < e) {
			double
			E = KSart3(e, M);
			E -= Keps3(e, M, E);
			E -= Keps3(e, M, E);
			E -= Keps3(e, M, E);
			return E;
		}
		return Double.NaN;
	}
}
