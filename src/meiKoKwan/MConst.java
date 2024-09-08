/**  
 * @Title: MConst.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-29 10:16:07 
 */ 

package meiKoKwan;

import org.joml.Vector3d;

/**  
 * @ClassName: MConst
 * @Description: 常量接口
 * @author BingGoqi
 * @date 2024-08-29 10:16:07 
*/

public interface MConst {
	Vector3d ZERO = new Vector3d();
	Vector3d X = new Vector3d(1,0,0);
	Vector3d Y = new Vector3d(0,1,0);
	Vector3d Z = new Vector3d(0,0,1);
	Vector3d TONE = new Vector3d(1,1,1);
	double PI = Math.PI;
	double TAU = 2*PI;
	double iTAU = 1/TAU;
	float NONE = (float)(Math.log(2.117)/0.75);
}
