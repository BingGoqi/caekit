/**  
 * @Title: RealFloat.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 07:11:11 
 */ 

package meiKoKwan;

/**  
 * @ClassName: RealFloat
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 07:11:11 
*/

public class RealFloat implements NumField<RealFloat> {
	private float val;
	public final Float getval() {
		return val;
	}
	public final RealFloat add(RealFloat v) {
		val+=v.val;
		return this;
	}
	public final RealFloat sub(RealFloat v) {
		val-=v.val;
		return this;
	}
	public final RealFloat mul(RealFloat v) {
		val*=v.val;
		return this;
	}
	public final RealFloat div(RealFloat v) {
		val/=v.val;
		return this;
	}
	public final RealFloat neg() {
		val = -val;
		return this;
	}
	public final RealFloat rec() {
		val = 1/val;
		return this;
	}
}
