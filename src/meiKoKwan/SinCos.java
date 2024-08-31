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

public class SinCos {
	public final double sin,cos;
	/**  
	 * @Constructor: SinCos
	 * @Description: SinCos构造函数
	 * @author BingGoqi
	 * @date 2024-07-30 05:53:55 
	 */
	public static void SinCos(Vector2d sc,double a) {
		sc.x = sin(a);
		sc.y = sqrt(1-sc.x*sc.x);
	}
	public SinCos(double a) {
		sin = sin(a);
		cos = sqrt(1-sin*sin);
	}
}
