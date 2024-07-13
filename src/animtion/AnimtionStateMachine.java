package animtion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**  
 * @ClassName: AnimtionStateMachine
 * 动画曲线状态机
 * @author BingGoqi
 * @date 2024-06-03 09:38:49 
*/  

public class AnimtionStateMachine implements AnimtionPath {
	private HashMap<Integer, AnimtionPath> APmap = new HashMap<Integer, AnimtionPath>();//存储曲线，需优化为ArrayList
	private ArrayList<Object> ts = new ArrayList<Object>();//跳转条件，参考unity
	private float PathOffset = 0;
	private AnimtionPath ap;//当前工作曲线
	private Section sc;//当前工作过渡曲线，需要抽象化
	private boolean transition = false;//过渡中
	private int StartID;//起始位置
	private int id,nid;
	//
	private LinkedList<TransitionControl> llist;
	//
	public AnimtionStateMachine() {}
	/**  
	 * @MethodName: setStart
	 * @Description: TODO
	 * @author BingGoqi
	 * @param start StartAnimtionPath_ID
	 * @return AnimtionStateMachine
	 * @date 2024-06-03 09:40:16 
	 */  
	public AnimtionStateMachine setStart(int start) {
		StartID = start;
		ap = APmap.get(start);
		return this;
	}
	
	/**  
	 * @MethodName: addAP
	 * 添加函数曲线，分配ID
	 * @author BingGoqi
	 * @param ap AnimtionPath
	 * @return AnimtionStateMachine
	 * @date 2024-06-03 09:45:28 
	 */  
	public AnimtionStateMachine addAP (AnimtionPath ap) {
		ap.setid(nid);
		APmap.put(nid++, ap);
		return this;
	}
	/**  
	 * @MethodName: addTC
	 * 没有状态机的跳转毫无意义！
	 * @author BingGoqi
	 * @param tc TransitionControl
	 * @param from
	 * @return AnimtionStateMachine
	 * @date 2024-06-03 09:54:17 
	 */  
	@Deprecated
	public AnimtionStateMachine addTC(TransitionControl tc,int from) {
		APmap.get(from).addTc(tc);
		return this;
	}
	/**  
	 * @MethodName: flush
	 * 检测是否归零，是否跳转，生成跳转过渡
	 * @author BingGoqi
	 * @param t void
	 * @date 2024-06-03 09:58:27 
	 */  
	private void flush(float t) {
		if(t < PathOffset) {//如果时间非单调增则清零
			transition = false;
			PathOffset = 0;
			ap = APmap.get(StartID);
		}
		if(transition) {
			if(t-PathOffset>sc.getEnd()) {
				transition = false;
				//PathOffset = t;
				PathOffset += sc.getEnd();
			}
			return;
		}
		for(var tt:ap.getTClist()) {
			if(tt.copm(t-PathOffset) && tt.getTransSection(ts)) {
				var apl = APmap.get(tt.getTo());
				var t1 = tt.getToTime();
				sc = new SectionCubic().setCubicIter(ap.getVal(t), apl.getVal(tt.getToTime()), ap.getValK(t), apl.getValK(t1), 0, tt.getTransTime(), 3);
				ap = apl;
				transition = true;
				PathOffset = t;
			}
		}
	}
	@Override
	public float getVal(float t) {
		flush(t);
		if(transition) {
			return sc.getVal(t-PathOffset);
		}else {
			return ap.getVal(t-PathOffset);
		}
	}
	@Override
	public float getValK(float t) {
		flush(t);
		if(transition) {
			return sc.getValK(t-PathOffset);
		}else {
			return ap.getValK(t-PathOffset);
		}
	}
	@Override
	public LinkedList<TransitionControl> getTClist() {
		return llist;
	}
	@Override
	public void addTc(TransitionControl tc) {
		llist.add(tc);
	}@Override
	public void setid(int id) {
		this.id = id;
	}
	@Override
	public int getid() {
		return id;
	}
}