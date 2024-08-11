/**  
 * @Title: OrthogonalMatrix3d.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-01 02:21:15 
 */ 

package meiKoKwan;

import org.joml.Matrix3d;

/**  
 * @ClassName: OrthogonalMatrix3d
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-01 02:21:15 
*/

public class OrthogonalMatrix3d extends Matrix3d {
	public OrthogonalMatrix3d() {
		m00 = 1;
		m11 = 1;
		m22 = 1;
	}
	
	/**  
	 * @Constructor: OrthogonalMatrix3d
	 * @Description: OrthogonalMatrix3d构造函数
	 * @author BingGoqi
	 * @date 2024-08-07 10:07:14 
	 */ 
	
	public OrthogonalMatrix3d(double ux, double uy, double uz) {
		m00 = ux;
		m11 = uy;
		m22 = uz;
	}

	@Override
	public Matrix3d invert() {
		return invert(this);
	}
	@Override
	public Matrix3d invert(Matrix3d dest) {
		double s = 1/determinant();
		dest.set(s*m00,s*m10,s*m20,s*m01,s*m11,s*m21,s*m02,s*m12,s*m22);
        return dest;
	}
}
