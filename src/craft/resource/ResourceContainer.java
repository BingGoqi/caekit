/**  
 * @Title: ResourceContainer.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-23 09:09:12 
 */ 

package craft.resource;

/**  
 * @ClassName: ResourceContainer
 * @Description: 单一种类的资源容器
 * @author BingGoqi
 * @date 2024-07-23 09:09:12 
*/

public class ResourceContainer {
	int type,id,priority;//资源种类，容器编号，优先级
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
	public void useResource(double k) {
		stock *=(1-k);//比例使用
	}
	public void clean() {
		stock = 0;
	}
	public void addResource(double k) {
		stock +=(size-stock)*k;//比例增加
	}
	public void full() {
		stock = size;
	}
}
