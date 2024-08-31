package space.frame;

import static meiKoKwan.MConst.X;

import org.joml.Math;
import org.joml.Vector3d;

import meiKoKwan.SinCos;

public class TCISFrame extends Frame {
	Vector3d rae = X;
	//y轴指向平天球和真天球左侧交点
	public TCISFrame(Frame sup, String name, Vector3d rae) {
		super(sup, name, null);
	}
	@Override
	void tSup(Vector3d in, Vector3d out) {
		in.add(0,rae.y,rae.z);
		SinCos A = new SinCos(in.y),E = new SinCos(in.z);
		out.x = in.x * E.cos;
		out.y = out.x * A.sin;
		out.x *= A.cos;
		out.z = in.x * E.sin;
		out.mul(rae.x);
	}
	@Override
	void tSup(Vector3d v) {
		tSup(v,v);
	}
	@Override
	void tThis(Vector3d in, Vector3d out) {
		out.x = in.length();
		out.y = Math.atan2(in.y, in.x);
		out.z = Math.atan2(in.z, out.x);
		out.x /= rae.z;
		out.sub(0,rae.y,rae.z);
	}
	@Override
	void tThis(Vector3d v) {
		tThis(v,v);
	}
}