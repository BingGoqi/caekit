/**  
 * @Title: NumField.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 07:37:36 
 */ 

package meiKoKwan;

/**  
 * @ClassName: NumField
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-15 07:37:36 
 */

public interface NumField<T> {
	T add(T a);
	T sub(T a);
	T neg();
	T mul(T a);
	T div(T a);
	T rec();
}
