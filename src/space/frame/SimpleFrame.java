/**  
 * @Title: SimpleFrame.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-08-07 09:43:58 
 */ 

package space.frame;

import meiKoKwan.OrthogonalMatrix3d;

public class SimpleFrame extends DeflautFrame {
	public SimpleFrame(FramePosition fp) {
		rank = fp.getRank()+1;
		move = fp;
		mp = new OrthogonalMatrix3d();
		mp.invert(mn);
	}
	public SimpleFrame(FramePosition fp,double ux,double uy,double uz) {
		move = fp;
		this.mp = new OrthogonalMatrix3d(ux,uy,uz);
		mp.invert(mn);
	}
	public SimpleFrame(FramePosition fp,OrthogonalMatrix3d mp) {
		move = fp;
		this.mp = mp;
		mp.invert(mn);
	}
}
