/**  
 * @Title: InterpIntarval.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-03 08:49:03 
 */ 

package interpolation;

/**  
 * @ClassName: InterpIntarval
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-03 08:49:03 
*/

public class InterpIntarvalDouble {
	final double[] plist;
	double t0,t1;
	public InterpIntarvalDouble(double t0,double t1,boolean b,double...ds) {
		this.t0 = t0;
		this.t1 = t1;
		plist = ds;
	}
	public InterpIntarvalDouble(double t0,boolean b,double...ds) {
		this.t0 = t0;
		plist = ds;
	}
	double getStart() {
		return t0;
	}
	double getEnd() {
		return t1;
	}
	int getCompare(double t) {
		return t<t0?-1:t>t1?1:0;
	}
	double getVal(double t) {
		double a;
		a = plist[0];
		for(int i = 1,j = plist.length;i < j;i++) {
			a = Math.fma(a, t, plist[i]);
		}
		return a;
	}
}