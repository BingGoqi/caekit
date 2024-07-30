/**  
 * @Title: OneAxisEllipsoid.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-30 05:10:54 
 */ 

package meiKoKwan;

import static java.lang.Math.*;

import org.joml.Vector3d;
/**  
 * @ClassName: OneAxisEllipsoid
 * @Description: 单轴椭球
 * @author BingGoqi
 * @date 2024-07-30 05:10:54 
*/

public class OneAxisEllipsoid {
	private double A,B;
	private final double e1() {
		return sqrt((A+B)*(A-B))/A;
	}
	private final double e12() {
		return (A+B)*(A-B)/(A*A);
	}
	private final double e2() {
		return sqrt((A+B)*(A-B))/B;
	}
	private final double e22() {
		return (A+B)*(A-B)/(B*B);
	}
	private final double pvr() {
		//Prime Vertical R
		return A/sqrt(1-e12()*MathExtends.pow2(sin(B)));
	}
	private final double normal_pvr() {
		//Prime Vertical R/A
		return 1/sqrt(1-e12()*MathExtends.pow2(sin(B)));
	}
	public void BLH_XYZ(Vector3d blh,Vector3d xyz) {
		double n = pvr(),e = e12();
		SinCos b = new SinCos(blh.x),l = new SinCos(blh.y);
		xyz.x = (n+blh.z)*b.cos;
		xyz.y = xyz.x*l.sin;
		xyz.x *= l.cos;
		xyz.z = (n*(1-e)+blh.z)*b.sin;
	}
	public void XYZ_BLH(Vector3d blh,Vector3d xyz) {
		//TODO https://blog.csdn.net/qq_42022528/article/details/107791476
	}
}
