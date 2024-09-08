package space.frame;

import org.joml.Vector3d;

import meiKoKwan.SinCos;
import static meiKoKwan.MathExtends.*;

public class TCISForm implements TransForm {
	private Vector3d rae;
	//y轴指向平天球和真天球左侧交点
	public TCISForm(Vector3d rae) {
		this.rae = rae;
	}
	public TCISForm(double r, double dA,double dE) {
		rae = new Vector3d(r,dA,dE);
	}
	
	public void tSup(Vector3d in, Vector3d out) {//rae-.
		in.add(0,rae.y,rae.z);
		SinCos A = new SinCos(in.y),E = new SinCos(in.z);
		out.x = in.x * E.cos;
		out.y = out.x * A.sin;
		out.x *= A.cos;
		out.z = in.x * E.sin;
		out.mul(rae.x);
	}
	@Override
	public void tSup(Vector3d v) {
		v.add(0,rae.y,rae.z);
		SinCos A = new SinCos(v.y),E = new SinCos(v.z);
		double a = v.x;
		v.x *= E.cos;
		v.y = v.x*A.sin;
		v.x *= A.cos;
		v.z = a * E.sin;
		v.mul(rae.x);
	}
	public void tThis(Vector3d in, Vector3d out) {
		out.x = in.length();
		out.y = atan2(in.y, in.x);
		out.z = atan2(in.z, out.x);
		out.x /= rae.z;
		out.sub(0,rae.y,rae.z);
	}
	@Override
	public void tThis(Vector3d v) {
		double a = v.length();
		v.y = atan2(v.y,v.x);
		v.z = atan2(v.z,a);
		v.x = a/rae.z;
		v.sub(0,rae.y,rae.z);
	}
}