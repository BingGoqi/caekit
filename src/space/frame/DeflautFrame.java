/**  
 * @Title: DeflautFrame.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-11 10:17:02 
 */ 

package space.frame;

import org.joml.Matrix3d;
import org.joml.Vector3d;
public class DeflautFrame implements Frame{
	double time;
	int rank;
	FramePosition move;
	Matrix3d mp,mn;
	@Override
	public void toTime(double time) {
		this.time = time;
		move.toTime(time);
	}
	@Override
	public void shiftTime(double dt) {
		time+=dt;
		move.shiftTime(dt);
	}
	@Override
	public void toUp(Vector3d in, Vector3d out) {
		out.set(in).mul(mp).sub(move);
	}
	@Override
	public void toThis(Vector3d in, Vector3d out) {
		out.set(in).sub(move).mul(mn);
	}
	@Override
	public Vector3d getRoatate() {
		return new Vector3d(0,0,0);
	}
	@Override
	public int getRank() {
		return rank;
	}
	@Override
	public Frame getSupFrame() {
		return move.frame;
	}
}
