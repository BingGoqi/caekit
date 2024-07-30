/**  
 * @Title: InterpLagrange.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-19 08:52:03 
 */ 

package interpolation;

/**  
 * @ClassName: InterpLagrange
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-19 08:52:03 
*/

public class InterpLagrange {
	double[] pl,kl;//未展开的Lagrange参数
	/**  
	 * @Constructor: InterpLagrange
	 * @Description: InterpLagrange构造函数
	 * @author BingGoqi
	 * @date 2024-07-19 08:52:27 
	 */
	public InterpLagrange(double[] px,double[] py) {
		pl = px;
		double ki;
		for(int i = 0,j = px.length;i < j;i++) {
			ki = 1;
			for(int k = 0,l = pl.length;k < l;k++) {
				if(i == k)break;
				ki *= (px[i]-px[k]);
			}
			kl[i] = py[i]/ki;
		}
	}
	double getVal(double x) {
		double a = 1;
		for(double b:pl) {
			a *= (x-b);
		}
		double c = 0;
		for(int i = 0,j = pl.length;i < j;i++) {
			c += a*kl[i]/(x-pl[i]);
		}
		return c;
	}
}
