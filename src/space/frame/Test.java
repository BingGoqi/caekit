package space.frame;

import org.joml.Vector3d;
import static meiKoKwan.MathExtends.*;

class Test{
	public static void main(String[] args) {
		double a = 6378137;
		var f = new Frame(new Frame(), "TCTP",new TCTPForm(a, 0.00669438002290, Math.PI/4));//CGCS2000坐标系
		Vector3d
		p = new Vector3d(a,a,a);
		var k = new Vector3d(0,toRadians(35.3690332999),4676259.034589138);
		f.tThis(p);
		System.out.println(k.sub(p));
		f.tSup(p);
		System.out.println(p.sub(a,a,a));
		/* (0,0.6155  ,4.669E+6)( 6.378E+6, 6.378E+6, 6.378E+6)结果
		 * (0,1.814E-3,1.112E-3)(-4.312E-6,-4.312E-6,-4.312E-6)相对误差
		 * (0,1.814E-3,7091)    (-27.51   ,-27.51   ,-27.5)    绝对误差
		 */
	}
}