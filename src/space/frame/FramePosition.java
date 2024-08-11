/**  
 * @Title: FramePosition.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-07 09:46:08 
 */ 

package space.frame;

import org.joml.Vector3d;

import Time.AboutTime;

/**  
 * @ClassName: FramePosition
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-07 09:46:08 
*/

public class FramePosition extends Vector3d implements AboutTime{
	Frame frame;
	int getRank() {
		return frame.getRank();
	}
	double time;
	@Override
	public void toTime(double time) {
		this.time = time;
		frame.toTime(time);
	}
	@Override
	public void shiftTime(double dt) {
		time += dt;
		frame.shiftTime(dt);
	}
}
