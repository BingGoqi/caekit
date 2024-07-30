/**  
 * @Title: TimeShiftable.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-30 10:00:23 
 */ 

package utils;

/**  
 * @ClassName: TimeShiftable
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-30 10:00:23 
*/

public interface TimeShiftable {
	void toTime(double time);
	void shiftTime(double dt);
}
