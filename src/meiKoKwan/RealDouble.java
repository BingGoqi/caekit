/**  
 * @Title: RealDouble.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 07:00:05 
 */ 

package meiKoKwan;

/**  
 * @ClassName: RealDouble
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 07:00:05 
*/

public class RealDouble implements NumField<RealDouble>{
	private double val;
	public RealDouble(double v) {
		val = v;
	}
	public final double getval() {
		return val;
	}
	public final RealDouble add(RealDouble v) {
		val+=v.val;
		return this;
	}
	public final RealDouble sub(RealDouble v) {
		val-=v.val;
		return this;
	}
	public final RealDouble mul(RealDouble v) {
		val*=v.val;
		return this;
	}
	public final RealDouble div(RealDouble v) {
		val/=v.val;
		return this;
	}
	public final RealDouble neg() {
		val = -val;
		return this;
	}
	public final RealDouble rec() {
		val = 1/val;
		return this;
	}
}
