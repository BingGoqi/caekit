/**  
 * @Title: BattinOrbit.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 10:49:00 
 */ 

package space.orbit;

import meiKoKwan.MathExtends;

/**  
 * @ClassName: BattinOrbit
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 10:49:00 
*/

public class BattinOrbit {
	double tp,al,rp,i;//近点时间，半长轴倒数，近点，倾角
	public final double U0(double x) {
		return Math.cos(x);
	}
	public final double U1(double x) {
		double k = Math.sqrt(al);
		return Math.sin(x*k)/k;
	}
	public final double U2(double x) {
		return (1-U0(x))/al;
	}
	public final double U3(double x) {
		return (x-U1(x))/al;
	}
	public final double sg(double x) {
		return (1-al*rp)*U2(x);
	}
	public final double X(double sg,double dt) {
		return al*dt+sg;
	}
	public final double XStar(double dt,double r) {
		double 
		t3 = dt*dt*dt,
		r4 = r*r;
		r4 *= r4;
		return dt/r-(1-al*r)*t3/6/r4;
	}
	public final double dX(double x,double dt) {
		double 
		u0 = U0(x),
		u1 = U1(x),
		u2 = (1-u1)/al,
		u3 = (x-u1)/al;
		return (rp*u1+u3-dt)/(rp*u0+u2);
	}
	public double X(double dt) {
		double k = Math.sqrt(Math.abs(al));
			//x = KeplerianOrbit.ellipticKeplerSolve(k*al*dt, 1-al*rp);
			//KeplerianOrbit.hyperbolicKeplerSolve(k*al*dt, 1-al*rp);
		return 1/0;
	}
	public final double BarkerSolve(double dt) {
		double 
		t2 = dt*dt,
		r3 = rp*rp*rp,
		k = Math.sqrt(9*t2+8*r3)+3*dt;
		k = Math.pow(k, 1.0/3.0);
		return k-2*rp/k;
	}
	public final double BattionSolve(double dt) {
		//TODO 未完工
		return MathExtends.KeplerSolve(dt, dt);
	}
}
