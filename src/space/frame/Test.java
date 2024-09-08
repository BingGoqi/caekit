package space.frame;

import org.joml.Vector3d;
import static meiKoKwan.MathExtends.*;

class Test{
	public static void main(String[] args) {
		double a = 1;//6378137;
		var f = new Frame(new Frame(), "TCTP",new TCTPForm(a, 0.00669438002290, Math.PI/4));//CGCS2000坐标系
		Vector3d
		p = new Vector3d(a,a,a),
		k = new Vector3d(0,toRadians(35.3690332999),4676259.034589138/6378137);
		f.tThis(p);
		System.out.println(p.sub(k));
		f.tSup(k);
		System.out.println(k.sub(1,1,1));
	}
}