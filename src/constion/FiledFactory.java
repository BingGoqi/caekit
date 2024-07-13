/**  
 * @Title: FiledFactory.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-04 10:11:18 
 */ 

package constion;

/**  
 * @ClassName: FiledFactory
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-04 10:11:18 
*/

public class FiledFactory {
	public static final Object[] list = new Object[10];
	static {
		list[0] = new String("aaa"+ FiledCont.S);
		list[1] = new String("bbb"+ FiledCont.k);
	}
	public static void Init() {
		
	}
	public static void main(String[] args) {
		FiledFactory.Init();
		System.out.println(FiledFactory.list[1]);
		System.out.println(FiledCont.l);
	}
}
