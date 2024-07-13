/**  
 * @Title: AnimitionFollowDefault.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-03 03:23:52 
 */ 

package animtion;

/**  
 * @ClassName: AnimitionFollowDefault
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-03 03:23:52 
*/

public class AnimitionFollowDefault {
	public float getdt(float k,float h0,float h1) {
		return (h1-h0)/k;
	}
}
