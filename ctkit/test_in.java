package space.frame;

import org.joml.Vector3d;

import static meiKoKwan.MathExtends.*;
import meiKoKwan.SinCos;

/** #define 识别注释和注解
 * 固定偏移量地面坐标系
 */
public class TCTPFrame extends Frame{
	Vector3d ae2l;
	#define a ae2l.x
	#define e2 ae2l.y
	#define l ae2l.z
	public TCTPFrame(Frame sup, String name, double r,double e,double dl) {
		super(sup, name, null);
		this.ae2l = new Vector3d(r,e*e,dl);
	}
	public TCTPFrame(Frame sup, String name, Vector3d ae2l) {
		super(sup, name, null);
		this.ae2l = new Vector3d(ae2l);
	}
	static double pvr(double a,double e12,double B) {
		return a/sqrt(1-e12*pow2(sin(B)));
	}
	double pvr(double B) {
		return a/sqrt(1-e2*pow2(sin(B)));
	}
	@Override
	void tSup(Vector3d in, Vector3d out) {
		//in:LBH;out:xyz;
		#bdefine L in.x
		#bdefine B in.y
		#bdefine H in.z
		L += l;
		double n = pvr(e2);
		SinCos b = new SinCos(B),l = new SinCos(L);
		out.x = (n+H)*b.cos;
		out.y = out.x*l.sin;
		out.x *= l.cos;
		out.z = (n*(1-e2)+in.z)*b.sin;
		
	}
	@Override
	void tThis(Vector3d in, Vector3d out) {
		//in:xyz;out:LBH;
		#bdefine L out.x
		#bdefine B out.y
		#bdefine H out.z
		double zl = sqrt(fma(in.x,in.x,in.y*in.y));
		L = atan2(in.y, in.x);
		B = XYZ2BLH(in.z/zl, a*e2/zl, 1-e2);
		H = zl/cos(out.y)-pvr(out.y);
		L -=l;
	}
}
