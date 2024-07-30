/**  
 * @Title: ResourceTree.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-24 09:33:48 
 */ 

package craft.resource;

import java.util.TreeMap;

/**  
 * @ClassName: ResourceTree
 * @Description: 资源优先级树
 * @author BingGoqi
 * @date 2024-07-24 09:33:48 
*/

public class ResourceTree{
	TreeMap<Integer, ResourceState> tlist;
	int type;
	double stock,size;
	
	public void addContainer(ResourceState rs) {
		if(rs.getType() == type) {
			tlist.put(rs.getPriority(), rs);
			stock += rs.getStock();
			size += rs.getSize();
		}
	}
	public double useResource(double rv) {
		return Math.max(rv-stock,0);
	}
	public double addResource(double rv) {
		return Math.max(rv-size+stock,0);
	}
	public void clean() {
		stock = 0;
		tlist.forEach((k,v)-> v.clean());
	}
	public void full() {
		stock=size;
		tlist.forEach((k,v)-> v.full());
	}
}
