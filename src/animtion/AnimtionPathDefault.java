package animtion;

import java.util.LinkedList;
import java.util.TreeMap;
/**  
 * @ClassName: AnimtionPathDefault
 * 使用三次插值的动画曲线实现
 * @author BingGoqi
 * @date 2024-06-03 09:20:42 
*/  

public class AnimtionPathDefault implements AnimtionPath {
	private SectionCubic[] list;//存储曲线分段
	private int iterator,id;
	private float mOffset,valMutl,min,max;//输出偏移和限制
	private float start,end;//动画曲线起止时间
	private boolean clamp = false;
	private AnimtionPath SubAnim;//嵌套曲线（未完工
	private TreeMap<Float,ControlPointCubic> plist;//编辑模式下存储控制点（需优化为LinkedList
	private LinkedList<TransitionControl> tlist = new LinkedList<TransitionControl>();//存储跳转控制器
	/**  
	 * length<0时为动态模式
	 * @Constructor: AnimtionPathDefault
	 * @Description: AnimtionPathDefault构造函数
	 * @author BingGoqi
	 * @date 2024-06-03 09:27:34 
	 */ 
	public AnimtionPathDefault(int length) {
		if(length<0) {
			plist = new TreeMap<>();
		}else {
			list = new SectionCubic[length];
		}
	}  
	/**  
	 * @MethodName: SetOut
	 * out=clamp(min,max,mult*(val+offset))
	 * @author BingGoqi
	 * @param offset
	 * @param mult
	 * @param min
	 * @param max
	 * @param clamp
	 * @return AnimtionPathDefault
	 * @date 2024-06-03 09:28:25 
	 */  
	public AnimtionPathDefault SetOut(float offset,float mult,float min,float max,boolean clamp) {
		mOffset = offset*mult;
		valMutl = mult;
		this.min = min;
		this.max = max;
		this.clamp = clamp;
		return this;
	}
	/**  
	 * @MethodName: SetData
	 * 调试使用，尽快删除
	 * @author BingGoqi
	 * @param index
	 * @param s
	 * @return AnimtionPathDefault
	 * @date 2024-06-03 09:29:39 
	 */  
	@Deprecated
	public AnimtionPathDefault SetData(int index,SectionCubic s) {
		list[index]=s;
		return this;
	}  
	/**  
	 * @MethodName: SetDataMata
	 * 反序列化使用，尽快删除
	 * @author BingGoqi
	 * @param dlist
	 * @return AnimtionPathDefault
	 * @date 2024-06-03 09:30:29 
	 */  
	@Deprecated
	public AnimtionPathDefault SetDataMata(float[] dlist) {
		if(dlist.length==list.length*7) {
			for(int i =0;i<list.length;i++) {
				list[i]=new SectionCubic().SetCubicMata(dlist[i], dlist[i+1], dlist[i+2], dlist[i+3], dlist[i+4], dlist[i+5], (int)dlist[i+6]);
			}
		}else {
			throw new AnimtionException("DataLengthErr: "+dlist);
		}
		return this;
	}
	public void setid(int id) {
		this.id = id;
	}
	public int getid() {
		return id;
	}
	/**  
	 * @MethodName: flush
	 * 将动态模式转化成静态模式，可选择是否删除控制点数据
	 * @author BingGoqi
	 * @param deleteTree
	 * @return AnimtionPathDefault
	 * @date 2024-06-03 09:31:41 
	 */  
	public AnimtionPathDefault flush(boolean delete) {
		if(plist.size()<2) throw new AnimtionException("PointNumber < 2");
		list = new SectionCubic[plist.size()-1];
		int i = 0;
		var iter=plist.values().iterator();
		ControlPointCubic cpc1,cpc2;
		cpc1 = iter.next();
		while(iter.hasNext()) {
			cpc2 = iter.next();
			list[i++]=cpc1.getScetion(cpc2);
			cpc1 = cpc2;
		}
		start = list[0].getStart();
		end = list[list.length-1].getEnd();
		if(delete)plist = null;
		return this;
	} 
	private int searchSection(float t,int i) {
		int d1,d2;
		d2 = 9;//非0，1，-1
		do {
			d1=list[i].getCompare(t);
			i+=d1;
			if(d1+d2==0) break;
			//if(d1+d2==0) throw new AnimtionException("Notsearch: "+t);
		} while (d1!=0);
		return i;
	}
	@Override
	public float getVal(float t) {
		t = Math.clamp(t,start,end);
		iterator = searchSection(t,iterator);
		float val = list[iterator].getVal(t);
		val = Math.fma(valMutl, val, mOffset);
		return clamp?Math.clamp(val, min, max):val;
	}
	@Override
	public float getValK(float t) {
		t = Math.clamp(t,start,end);
		iterator = searchSection(t,iterator);
		return list[iterator].getValK(t)*valMutl;
	} 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public LinkedList<TransitionControl> getTClist() {
		return (LinkedList)tlist;
	}
	@Override
	public void addTc(TransitionControl tc) {
		tc.setVal();
		tlist.add(tc);
	}
	/**  
	 * @MethodName: addCP
	 * 需要抽取至接口
	 * @author BingGoqi
	 * @param cpc ControlPointCubic
	 * @return AnimtionPathDefault
	 * @date 2024-06-03 09:37:18 
	 */  
	public AnimtionPathDefault addCP(ControlPointCubic cpc) {
		plist.put(cpc.t, cpc);
		return this;
	}
	//TODO set,poll,push...
}