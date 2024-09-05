/**  
 * @Title: MathExtends.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-04 03:30:04 
 */ 

package meiKoKwan;

import static java.lang.Math.*;

import org.joml.Math;
import org.joml.Vector2d;
import org.joml.Vector3d;
/**  
 * @ClassName: MathExtends
 * @Description: 扩展数学函数
 * @author BingGoqi
 * @date 2024-07-04 03:30:04 
*/

public class MathExtends extends Math implements MConst{
	public static double asinh(double x) {
		return log(x+sqrt(1+x*x));
	}
	public static boolean round(double a,double b) {
		return (abs(a-b)<1e-8);
	}
	public static double pow2(double a) {return a*a;}
	public static double pow3(double a) {return a*a*a;}
	public static double mod1d(double a) {return a-((long)a);}
	public static double atan(double x) {return java.lang.Math.atan(x);}
	public static double pow(double x,double a) {return pow(x, a);}
	public static double ksmd(int p,int n) {
		int a = p;
		while(n > 1) {
			a *= (n&1)==1?p:a;
			n=n>>1;
		}
		return a;
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
		double da = Kheps3(c, b, a);//需优化
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

	public static double XYZ2BLH(double t,double p,double k) {
		double tb,dtb;
		dtb = p*t/sqrt(k+t*t);
		tb = t+dtb;
		while(abs(dtb) > 4.5e-16) {
			dtb = tb;
			tb = t+p*tb/sqrt(k+tb*tb);
			dtb = tb-dtb;
		}
		return atan(tb);
	}
}
