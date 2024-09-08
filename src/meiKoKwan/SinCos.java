/**  
 * @Title: SinCos.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-30 05:53:44 
 */ 

package meiKoKwan;

import org.joml.Vector2d;
import static meiKoKwan.MathExtends.*;

/**  
 * @ClassName: SinCos
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-30 05:53:44 
*/

public class SinCos implements MConst{
	public final double sin,cos;
	/**  
	 * @Constructor: SinCos
	 * @Description: SinCos构造函数
	 * @author BingGoqi
	 * @date 2024-07-30 05:53:55 
	 */
	public static void getSinCos(Vector2d sc,double a) {
		sc.y = cos(a);
		sc.x = sqrt(-fma(sc.y,sc.y,-1));
		if(mod1d(a*iTAU) > .5)sc.x = -sc.x;
	}
	public SinCos(double s,double c) {
		sin = s;
		cos = c;
	}
	public SinCos(double a) {
		cos = cos(a);
		if(mod1d(a*iTAU) > .5) {
			sin = -sqrt(-fma(cos,cos,-1));
		}else {
			sin = sqrt(-fma(cos,cos,-1));
		}
		
	}
}
