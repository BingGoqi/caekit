/**  
 * @Title: ResourceTree.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-23 09:09:23 
 */ 

package craft.resource;

import utils.Linkedlist;

/**  
 * @ClassName: ResourceTree
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-23 09:09:23 
 */

public class ResourceState{
	Linkedlist<ResourceContainer> clist;//相同优先级集合
	int type,priority;
	public int getType() {
		return type;
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
	double stock,size;
	public ResourceState(int type, int priority) {
		this.priority = priority;
		this.type = type;
		size = 0;
		stock = 0;
		clist = new Linkedlist<ResourceContainer>();
	}
	public void addContainer(ResourceContainer rc) {
		if(rc.getType() == type && rc.getPriority() == priority) {
			clist.add(rc);
			stock += rc.getStock();
			size += rc.getSize();
		}
	}
	public double useResource(double rv) {
		double k;
		if(stock > rv) {
			k = rv/stock;
			stock -= rv;
			clist.forEach(s -> s.useResource(k));
			return 0;
		}else {
			k = rv-stock;
			stock = 0;
			clist.forEach(s -> s.clean());
			return k;
		}
	}
	public double addResource(double rv) {
		double k;
		if(size-stock > rv) {
			k = rv/(size-stock);
			stock += rv;
			clist.forEach(s -> s.useResource(k));
			return 0;
		}else {
			k = rv-size;
			stock = size;
			clist.forEach(s -> s.full());
			return k;
		}
	} 
	public double clean() {
		stock = 0;
		clist.forEach(c-> c.clean());
		return 0;
	}
	public double full() {
		stock = size;
		clist.forEach(c-> c.clean());
		return 0;
	}
}