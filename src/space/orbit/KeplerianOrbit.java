/**  
 * @Title: KeplerianOrbit.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 08:04:18 
 */ 

package space.orbit;

import static meiKoKwan.MathExtends.*;
import meiKoKwan.SinCos;

/**  
 * @ClassName: KeplerianOrbit
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 08:04:18 
*/

public class KeplerianOrbit {
	double a,e,i,pa,raan,v;
	double n;
	void getvval(double dt) {
		double E = KeplerSolve(e, n*dt);
		SinCos cE = new SinCos(E);
		//E = 1/(1-e*cE.cos);
		//SinCos F = new SinCos(sqrt(1-e*e)*cE.sin*E,(cE.cos-e)*E);
	}
}
