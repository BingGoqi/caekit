package mash;

import static meiKoKwan.MathExtends.*;

import org.joml.Vector2d;

public class PhiMash {
	public static final double sq5 = sqrt(5.);
	public static final double phi = (sq5-1)/2;
	public static final double Thi = phi+1;
	static double round(double x) {
		return (long)(x+0.5);
	} 
	static double fbd(int i) {
		if(i < 2)return 1;
		return round((pow(Thi,i) - pow(phi,i))/sq5);
	}
	static void getPoint(int n,int max,Vector2d dest) {
		dest.x = mod1d(phi*n);
		dest.y = n;
		dest.y /= max;
	}
	static double tanrad(double a,double b,double n) {
		double
		fa = mod1d(phi*a),
		fb = mod1d(phi*b),
		c = 1/n;
		a *=c;
		b *=c;
		c = fa*(fb+b);
		return (c-fb*(fa+a))/(c+b*(a-fa));
	}
	static double rad(double a,double b,double n) {
		return atan(tanrad(a,b,n));
	}
	static double tanrad(double a,double n) {
		double
		fa = mod1d(phi*a),
		fb = mod1d(Thi*a);
		a /= n;
		n = Thi*Thi*a;
		double c = fa*(fb+n);
		return (c-fb*(fa+a))/(c+n*(a-fa));//误差大
	}
	
	public static void main(String[] args) {
		var pit = new PhiIteator();
		double N = 75025;
		double pa,na;
		pa = pit.a;
		pit.next();
		while(pit.a <= N) {
			na = pit.a;
			System.out.println(pa+"-"+na+":\t"+(tanrad(pa,na,N)));
			pa = na;
			pit.next();
		}
	}
}
class PhiIteator{
	long a,b,i;
	public PhiIteator() {
		a=b=1;
		i = 0;
	}
	void next() {
		i+=2;
		a += b;
		b += a;
	}
}