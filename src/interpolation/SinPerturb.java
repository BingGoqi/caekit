/**  
 * @Title: SinPerturb.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-17 05:57:29 
 */ 

package interpolation;

/**  
 * @ClassName: SinPerturb
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-17 05:57:29 
*/

public class SinPerturb {
	private final double A,Av,A0,T0;
	/**  
	 * @Constructor: SinPerturb
	 * @Description: SinPerturb构造函数
	 * @author BingGoqi
	 * @date 2024-06-19 09:26:36 
	 */

	public SinPerturb(double a,double av,double a0,double t0) {
		A=a;Av=av;A0=a0;T0=t0;
	}
	public double getVal(double t) {
		return Math.fma(A,Math.sin(Av*(t-T0)),A0);
	}
}
