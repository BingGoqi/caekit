/**  
 * @Title: OutTree.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-29 04:22:40 
 */ 

package tree;

import java.util.HashMap;

/**  
 * @ClassName: OutTree
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-29 04:22:40 
*/

public class OutTree{
	public static final HashMap<String, Tp> TMap = new HashMap<String, OutTree.Tp>();
	public static void main(String[] args) {
		System.out.println(orbit);
	}
	class Tp{
		String name;
		String txt;
		public Tp(String name,String txt) {
			this.name = name;
			this.txt = txt;
		}
	}
public static final String orbit = """
- HermitePV 三阶星历（math.interpolation中）*
- HermitePVA 五阶星历(同上*
- Kepler*
    - Battin 普适方程
    - 拼接圆锥曲线
    - 多圆锥曲线法
- H-W 轨道
- Encke 轨道
- SST 轨道
- 笛卡尔轨道
    - RK45（在math.integrate中)
    - RK78 (同上
    - RKF853 (同上
- T-H轨道
- C-W轨道
- KPrecession 进动椭圆
- KLDrift 长周期飘移*
""";
}
