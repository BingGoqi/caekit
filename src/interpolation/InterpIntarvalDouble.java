/**  
 * @Title: InterpIntarval.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-03 08:49:03 
 */ 

package interpolation;

/**  
 * @ClassName: InterpIntarval
 * @Description: 广义多项式|废弃
 * @author BingGoqi
 * @date 2024-07-03 08:49:03 
*/

public class InterpIntarvalDouble {
	final double[] plist;
	double ts,T,p0;
	public InterpIntarvalDouble(double ts,double te,boolean b,double...ds) {
		this.ts = ts;
		this.T = te-ts;
		plist = ds;
	}
	public InterpIntarvalDouble(double t0,boolean b,double...ds) {
		this.ts = t0;
		plist = ds;
	}
	double getStart() {
		return ts;
	}
	double getEnd() {
		return ts+T;
	}
	int getCompare(double t) {
		return t<ts?-1:t>ts+T?1:0;
	}
	double getVal(double t) {
		t = (t-ts)/T;
		double a;
		a = plist[0];
		for(int i = 1,j = plist.length;i < j;i++) {
			a = Math.fma(a, t, plist[i]);
		}
		return a;
	}
}