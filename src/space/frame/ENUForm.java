package space.frame;

public class ENUForm extends Matrix4dForm{
	public ENUForm(double s,double a,double e) {
		m.rotateLocalZ(a).rotateLocalX(e);
		m.translate(s*m.m00(), s*m.m10(),s*m.m20());
		m.scale(s);
		//SinCos A = new SinCos(a),E = new SinCos(e);
		m.invert(invm);
	}
}
