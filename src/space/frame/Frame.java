/**  
 * @Title: Frame.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-07 09:23:47 
 */ 

package space.frame;

import org.joml.Vector3d;

import Time.AboutTime;

/**  
 * @ClassName: Frame
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-07 09:23:47 
*/

public interface Frame extends AboutTime {
	Frame getSupFrame();
	int getRank();
	void toUp(Vector3d in,Vector3d out);
	void toThis(Vector3d in,Vector3d out);
	Vector3d getRoatate();
}
