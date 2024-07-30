/**  
 * @Title: LinePerturb.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-17 03:05:45 
 */ 

package interpolation;

/**  
 * @ClassName: LinePerturb
 * @Description: 线性函数
 * @author BingGoqi
 * @date 2024-07-17 03:05:45 
*/

public class LinePerturb {
	private final double A0,K;
	/**  
	 * @Constructor: LinePerturb
	 * @Description: LinePerturb构造函数
	 * @author BingGoqi
	 * @date 2024-06-19 09:33:41 
	 */

	public LinePerturb(double k,double a0) {
		K = k;
		A0 = a0;
	}
	public double grtVal(double t) {
		return Math.fma(K, t, A0);
	}
}
