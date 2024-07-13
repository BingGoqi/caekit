/**  
 * @Title: DDouble.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-15 09:46:04 
 */ 

package utils;

import java.math.BigDecimal;
import java.math.MathContext;

/**  
 * @ClassName: DDouble
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-15 09:46:04 
*/

public class DDouble {
	public static final DDouble D_DOUBLE_MAX = new DDouble(10E24);
	double d1,d2;
	double size;
	//光年:1E13
	//宇宙半径:4.6E24 直径:9.2E24 最大误差:10um
	public DDouble(double d) {
		size = d1 = d;
		d2 = 0;
	}
	public DDouble(BigDecimal bd) {
		d1 = bd.doubleValue();
		d2 = bd.subtract(new BigDecimal(d1)).doubleValue();
		size = d1+d2;
	}
	public void range() {
		d2 -= (size-d1);
		d1=size;
	}
	public DDouble(char[] clist) {
		
	}
	public DDouble add(DDouble dd) {
		double a,b,c,d,e,f;
		a = d1;
		b = d2;
		c = dd.d1;
		d = dd.d2;
		;return this;
	}
	
	public BigDecimal getval() {
		return new BigDecimal(d1).add(new BigDecimal(d2));
	}
}
