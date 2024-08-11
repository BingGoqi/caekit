/**  
 * @Title: Rotation4dl.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-07 10:22:01 
 */ 

package meiKoKwan;

import org.joml.AxisAngle4d;
import org.joml.Vector3d;

import interpolation.LinePerturb;
import utils.TimeFunction;
import utils.TimeShiftable;

/**  
 * @ClassName: Rotation4dl
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-07 10:22:01 
*/

public class Rotation4dl implements TimeShiftable,TimeFunction<AxisAngle4d>{
	AxisAngle4d rp;
	LinePerturb lp;
	double time;
	public Rotation4dl(double ra,double r0,Vector3d polt) {
		lp = new LinePerturb(ra, r0);
		rp = new AxisAngle4d(r0, polt);
	}
	@Override
	public AxisAngle4d getTime(double time) {
		return rp.rotate(lp.getVal(time));
	}
	@Override
	public void toTime(double time) {
		this.time = time;
	}
	@Override
	public void shiftTime(double dt) {
		time += dt;
	}
}
