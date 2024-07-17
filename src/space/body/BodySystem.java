/**  
 * @Title: BodyTree.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-17 05:59:03 
 */ 

package space.body;


/**  
 * @ClassName: BodyTree
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-07-17 05:59:03 
*/

public class BodySystem {
	TreeNode root;
	
	class TreeNode{
		TreeNode p,s,b;
		Body val;
		public TreeNode getBorther() {
			return b;
		}
		public TreeNode getPrant() {
			return p;
		}
		public TreeNode getSon() {
			return s;
		}
		public Body getBody() {
			return val;
		}
	}
	
}
