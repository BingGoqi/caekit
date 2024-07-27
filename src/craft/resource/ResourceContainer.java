/**  
 * @Title: ResourceContainer.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-23 09:09:12 
 */ 

package craft.resource;

/**  
 * @ClassName: ResourceContainer
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-23 09:09:12 
*/

public class ResourceContainer {
	int type,id,priority;
	double stock,size;
	public int getType() {
		return type;
	}
	public int getId() {
		return id;
	}
	public int getPriority() {
		return priority;
	}
	public double getStock() {
		return stock;
	}
	public double getSize() {
		return size;
	}
	/**  
	 * @MethodName: useResource
	 * @Description: TODO
	 * @author BingGoqi
	 * @return Object
	 * @date 2024-07-24 02:08:06 
	 */  
	
	public void useResource(double k) {
		stock *=(1-k);
	}
	public void clean() {
		stock = 0;
	}
	public void addResource(double k) {
		stock +=(size-stock)*k;
	}
	public void full() {
		stock = size;
	}
}
