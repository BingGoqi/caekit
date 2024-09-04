package space.frame;

import org.joml.Vector3d;


public class ENUForm extends  Matrix4dForm{
	public ENUForm(double s,double a,double e) {
		m.rotateLocalZ(a).rotateLocalX(e);
		m.translate(s*m.m00(), s*m.m10(),s*m.m20());
		m.scale(s);
		//SinCos A = new SinCos(a),E = new SinCos(e);
		m.invert(invm);
	}
	@Override
	public void tSup(Vector3d in, Vector3d out) {
		super.tSup(in, out);
	}
	@Override
	public void tThis(Vector3d in, Vector3d out) {
		super.tThis(in, out);
	}
}
