package mash;

import static meiKoKwan.MathExtends.*;

import org.joml.Vector2d;

public class PhiMash {
	public static final double sq5 = sqrt(5.);
	public static final double phi = (sq5-1)/2;
	public static final double Thi = phi+1;
	public static double fbd(int i) {
		if(i < 2)return 1;
		return round((pow(Thi,i) - pow(phi,i))/sq5);
	}
	public static void getPoint(int n,int max,Vector2d dest) {
		dest.x = mod1d(phi*n);
		dest.y = n;
		dest.y /= max;
	}
	public static double rad(double a,double b,double n) {
		double
		fa = mod1d(phi*a),
		fb = mod1d(phi*b),
		c = 1/n;
		a *=c;
		b *=c;
		c = fa*(fb+b);
		return atan((c-fb*(fa+a))/(c+b*(a-fa)));
	}
	public static double rad(double a,double n) {
		double
		fa = mod1d(phi*a),
		fb = mod1d(Thi*a);
		a /= n;
		double b = Thi*Thi*a;
		double c = fa*(fb+b);
		return atan((c-fb*(fa+a))/(c+b*(a-fa)));//误差大
	}
	
	public static void main(String[] args) {
		System.out.println(rad(89,233,100000));
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
