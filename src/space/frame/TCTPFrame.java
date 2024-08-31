package space.frame;


import org.joml.Vector3d;

import static meiKoKwan.MathExtends.*;
import meiKoKwan.SinCos;

/**
 * 固定偏移量地面坐标系
 */
public class TCTPFrame extends Frame{
	Vector3d ae2l;
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
		return ae2l.x/sqrt(1-ae2l.y*pow2(sin(B)));
	}
	@Override
	void tSup(Vector3d in, Vector3d out) {
		//in:LBH;out:xyz;
		in.x += ae2l.z;
		double n = pvr(ae2l.y);
		SinCos b = new SinCos(in.y),l = new SinCos(in.x);
		out.x = (n+in.z)*b.cos;
		out.y = out.x*l.sin;
		out.x *= l.cos;
		out.z = (n*(1-ae2l.y)+in.z)*b.sin;
		
	}
	@Override
	void tThis(Vector3d in, Vector3d out) {
		//in:xyz;out:LBH;
		double zl = sqrt(fma(in.x,in.x,in.y*in.y));
		out.x = atan2(in.y, in.x);
		out.y = XYZ2BLH(in.z/zl, ae2l.x*ae2l.y/zl, 1-ae2l.y);
		out.z = zl/cos(out.y)-pvr(out.y);
		out.x -=ae2l.z;
	}
}
