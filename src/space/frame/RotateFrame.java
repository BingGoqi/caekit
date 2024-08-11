/**  
 * @Title: RotateFrame.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-07 10:05:55 
 */ 

package space.frame;

import org.joml.AxisAngle4d;
import org.joml.Vector3d;

import interpolation.LinePerturb;

/**  
 * @ClassName: RotateFrame
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-07 10:05:55 
*/

public class RotateFrame extends SimpleFrame {
	AxisAngle4d rp;
	LinePerturb lp;
	public RotateFrame(FramePosition fp,AxisAngle4d rp,LinePerturb lp) {
		super(fp);
		this.rp = rp;
		this.lp = lp;
	}
	public RotateFrame(FramePosition fp,Vector3d polt,double ang) {
		super(fp);
		this.rp = new AxisAngle4d().set(0,polt);
		lp = new LinePerturb(0, ang);
	}
	@Override
	public void toTime(double time) {
		super.toTime(time);
		double ang = lp.getVal(time);
		mp.set(rp.rotate(ang));
		mn.set(rp.rotate(-ang));
	}
	@Override
	public void shiftTime(double dt) {
		super.shiftTime(dt);
		double ang = lp.getVal(time);
		mp.set(rp.rotate(ang));
		mn.set(rp.rotate(-ang));
	}
	@Override
	public Vector3d getRoatate() {
		return new Vector3d(rp.x,rp.y,rp.z).mul(lp.getK(0));
	}
}
