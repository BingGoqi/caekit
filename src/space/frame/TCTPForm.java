package space.frame;


import org.joml.Vector3d;

import static meiKoKwan.MathExtends.*;
import meiKoKwan.SinCos;

/**
 * 固定偏移量地面坐标系
 */
public class TCTPForm implements TransForm{
	Vector3d ae2l;
	public TCTPForm(double r,double e,double dl) {
		this.ae2l = new Vector3d(r,e*e,dl);
	}
	public TCTPForm(Vector3d ae2l) {
		this.ae2l = new Vector3d(ae2l);
	}
	static double pvr(double a,double e12,double B) {
		return a/sqrt(1-e12*pow2(sin(B)));
	}
	double pvr(double B) {
		return ae2l.x/sqrt(1-ae2l.y*pow2(sin(B)));
	}
	@Override
	public void tSup(Vector3d v) {
		//in:LBH;out:xyz;
		v.x += ae2l.z;
		double n = pvr(ae2l.y);
		SinCos B = new SinCos(v.y),L = new SinCos(v.x);
		v.x = (n+v.z)*B.cos;
		v.y = v.x*L.sin;
		v.x *= L.cos;
		v.z = (n*(1-ae2l.y)+v.z)*B.sin;
	}
	@Override
	public void tThis(Vector3d v) {
		double zl = sqrt(fma(v.x,v.x,v.y*v.y));
		v.x = atan2(v.y, v.x);
		v.y = XYZ2BLH(v.z/zl, ae2l.x*ae2l.y/zl, 1-ae2l.y);
		v.z = zl/cos(v.y)-pvr(v.y);
		v.x -=ae2l.z;
	}
}
