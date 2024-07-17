/**  
 * @Title: KeplerianOrbit.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 08:04:18 
 */ 

package space.orbit;

import static java.lang.Math.*;

/**  
 * @ClassName: KeplerianOrbit
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 08:04:18 
*/

public class KeplerianOrbit {
	public static final double asinh(double x) {
		return Math.log(x+sqrt(1+x*x));
	}
	public static final double KeSart3(double e,double M) {
		double t33,t34,t35;
		t33 = cos(M);
		t34 = e*e;
		t35 = t34*e;
		return M+(-.5*t35+e+(t34+1.5*t33*t35)*t33*sin(M));
	}
	public static final double KhSart3(double e,double M) {
		if(abs(M) < .01)
			return M/(e-1.0);
		return asinh(M/e);
	}
	public static final double Keeps3(double e,double M,double x) {
		double t1,t2,t3,t4,t5,t6;
		t1 = cos(x);
		t2 = e*t1-1;
		t3 = sin(x);
		t4 = e*t3;
		t5 = -x+t4+M;
		t6 = t5/(.5*t5*t4/t2+t2);
		return t5/((.5*t3-t1*t6/6)*e*t6+t2);
	}
	public static final double Kheps3(double e,double M,double x) {
		double t1,t2,t3,t4;
		t1 = cosh(x);
		t2 = 1-e*t1;
		t3 = sinh(x);
		t4 = e*t3;
		return (x+M-t4)/t2;
	}
	public static final double ellipticKeplerSolve(double b,double c) {
		double //https://spacefan.github.io/2019/02/20/KeplerianSolver/
		a = KeSart3(c, b);
		a -= Keeps3(c, b, a);
		a -= Keeps3(c, b, a);
		a -= Keeps3(c, b, a);
		return a;
	}
	public static final double hyperbolicKeplerSolve(double b,double c) {
		double//a = -b+c*sinh(a)
		a = KhSart3(c, b);
		double da = Kheps3(c, b, a);
		do {
			a -= da;
			System.out.println(da);
		}while(abs(da)>4e-15);
		return a;
	}
	public static final double KeplerSolve(double e,double M) {
		M = M%TAU;
		e = abs(e);
		if(1 < e) {
			return hyperbolicKeplerSolve(M, e);
		}else if(1 == e) {
			return 2*atan(2*sinh(asinh(1.5*M)/3));
		} else if(0 < e) {
			double
			E = KeSart3(e, M);
			E -= Keeps3(e, M, E);
			E -= Keeps3(e, M, E);
			E -= Keeps3(e, M, E);
			return E;
		}
		return 1/0;
	}
}
