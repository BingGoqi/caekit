/**  
 * @Title: CubePlotData.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-19 03:37:28 
 */ 

package meiKoKwan;

/**
 * @ClassName : CubePlotData
 * @Description : TODO
 * @author  BingGoqi
 * @date  2024-07-19 03:37:28 
 */
public final class CubePlot{
	//f(x) = a*(x3+b*x2+c*x+d)
	//f(x) = t3+p*t+q, t = x+dx
	private double a,p,q,dat,dx;
	public CubePlot(double b,double c,double d) {
		dx = b/3;
		p = Math.fma(-3*dx, dx, c);
		q = Math.fma(Math.fma(2*dx, dx, -c), dx, d);
	}
	public CubePlot(double na,double b,double c,double d) {
		this(b*na,c*na,d*na);
		this.a = 1/na;
	}
	public CubePlot(double p,double q) {
		this.p = p;
		this.q = q;
		a = 1;
		dx = 0;
		dat = Math.sqrt(Math.abs(p)/3);
		dat = (dat*dat-p)*dat;
	}
	Vector3d getPn() {
		double b = 3*dat;
		double c = Math.fma(b, dat, p);
		return new Vector3d(a*b,a*c,a*Math.fma(Math.fma(2*dat, dat, -c),-dat,q));
	}
	private final double getA() {
		return a;
	}
	public final double getVal(double t) {
		if(a == 0)return 0;
		t += dx;
		return a*Math.fma(Math.fma(t, t, p), t,q);
	}
	//x3+px+q==0
	private final double getR1(double q) {
		double n = Math.sqrt(p*p*p/27+q*q/4);
		return Math.cbrt(-q/2+n)+Math.cbrt(-q/2-n);
	}
	private final double getR21(double q) {
		return Math.cbrt(q)*Math.cbrt(-4);
	}
	private final double getR22(double q) {
		return dat*Math.signum(q);
	}
	private final Vector3d getR3(double q) {
		var l = getPn();
		double b = l.x,c = l.y,d = l.z;
		double 
		A = b*b - 3*a*c,
		B = b*c - 9*a*d,
		C = c*c - 3*b*d,
		x1,x2,x3;
		double sqA = Math.sqrt(A);
		double theta = Math.acos(A*b - 1.5*a*B)/(A*sqA);
		double csth = Math.cos(theta/3);
		double sn3th = Math.sqrt(3)*Math.sin(theta/3);
		x2 = (-1*b + sqA*(csth + sn3th))/(3*a);
		x3 = (-1*b + sqA*(csth - sn3th))/(3*a);
		x1 = -b/a-x2-x3;
		return new Vector3d(x1,x2,x3);
	}
	private final int getType(double q) {
		if(p > 0) return 1;
		if(p == 0)return 0;
		q = Math.abs(q);
		if(q > dat)return 1;
		if(q < dat)return 3;
		return 2;
	}
	public int getRootType(double v) {
		if(p > 0) return 1;
		if(p == 0)return 0;
		double q = Math.abs(this.q-v/a);
		if(q > dat)return 1;
		if(q < dat)return 3;
		return 2;
	}
	public Vector3d getRoot(double val) {
		val = q-val/a;
		double x1,x2,x3;
		x1=x2=x3=1/0;
		Vector3d l = null;
		switch(getType(val)) {
		case 1 -> x1=x2=x3=getR1(val);
		case 2 -> {x1=getR21(val);x2=x3=getR22(val);}
		case 3 -> l = getR3(val);
		}
		return l == null? new Vector3d(x1,x2,x3):l;
	}
}