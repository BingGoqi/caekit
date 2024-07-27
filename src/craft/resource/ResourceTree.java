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
 * @Description: TODO
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
	}
	public double addResource(double rv) {
	}
	public double clean() {
	}
	public double full() {
	}
}
