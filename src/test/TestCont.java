/**  
 * @Title: TestCont.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-11 07:36:45 
 */ 

package test;

import org.joml.Vector3d;

/**  
 * @ClassName: TestCont
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-11 07:36:45 
*/

public class TestCont {
	Vector3d v;
	public TestCont() {
		v = new Posi();
	}
	@Override
	public String toString() {
		return v.toString();
	}
	public static void main(String[] args) {
		var c = new TestCont();
		Vector3d k = c.v;
		Posi p = (Posi) k;
		System.out.println(c);
	}
}
class Posi extends Vector3d{
	int t = 0;
	@Override
	public String toString() {
		return "Posi_obj";
	}
}