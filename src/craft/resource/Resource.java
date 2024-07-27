/**  
 * @Title: Resource.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-24 09:43:41 
 */ 

package craft.resource;

/**  
 * @ClassName: Resource
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-24 09:43:41 
*/

public interface Resource {

	/**  
	 * @MethodName: useResource
	 * @Description: TODO
	 * @author BingGoqi
	 * @param k
	 * @return Object
	 * @date 2024-07-24 09:44:38 
	 */  
	
	double useResource(double k);

	/**  
	 * @MethodName: clean
	 * @Description: TODO
	 * @author BingGoqi
	 * @return Object
	 * @date 2024-07-24 09:44:42 
	 */  
	
	double clean();

	/**  
	 * @MethodName: full
	 * @Description: TODO
	 * @author BingGoqi
	 * @return Object
	 * @date 2024-07-24 09:44:54 
	 */  
	
	double full();

	/**  
	 * @MethodName: gettype
	 * @Description: TODO
	 * @author BingGoqi
	 * @return int
	 * @date 2024-07-24 09:45:34 
	 */  
	
	int getType();

	/**  
	 * @MethodName: getpriority
	 * @Description: TODO
	 * @author BingGoqi
	 * @return int
	 * @date 2024-07-24 09:45:40 
	 */  
	
	int getPriority();

	/**  
	 * @MethodName: getstock
	 * @Description: TODO
	 * @author BingGoqi
	 * @return double
	 * @date 2024-07-24 09:45:43 
	 */  
	
	double getStock();

	/**  
	 * @MethodName: getsize
	 * @Description: TODO
	 * @author BingGoqi
	 * @return double
	 * @date 2024-07-24 09:45:50 
	 */  
	
	double getSize();

}
