/**  
 * @Title: CustomFrame.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-11 09:45:16 
 */ 

package space.frame;

import static utils.mmath.*;

public class CustomFrame extends DeflautFrame {
	
	int trank;
	FramePosition x,y,z;
	public CustomFrame(FramePosition O,FramePosition X,FramePosition Y,FramePosition Z,int type) {
		trank = (int) min(O.getRank(),min(X.getRank(),min(Y.getRank(),Z.getRank())));
		Frame f = O.frame;
		rank = trank+1;
		while(f.getRank() > trank) {
			f.toUp(O, move);
			O.set(move);
			f = f.getSupFrame();
			//TODO 需测试
		}
		move.frame = f;
	}
}