/**  
 * @Title: AirBox.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-26 03:54:03 
 */ 

package physical.air;

import org.joml.Vector3d;

/**  
 * @ClassName: AirBox
 * @Description: 阻力方盒模型
 * @author BingGoqi
 * @date 2024-07-26 03:54:03 
*/

public class AirBox {
	float xp,xn,yp,yn,zp,zn;
	void getDref(Vector3d dv,Vector3d pf) {
		pf.x = dv.x* dv.x>0?xp:-xn;
		pf.y = dv.y* dv.y>0?yp:-yn;
		pf.z = dv.z* dv.z>0?zp:-zn;
	}
}
