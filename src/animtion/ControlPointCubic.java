package animtion;

/**  
 * @ClassName ControlPointCubic
 * @Description 
 * 曲线控制点
 * 是否抽取接口？
 * @author BingGoqi
 * @date 2024-06-03 10:17:40 
*/  

public class ControlPointCubic {
	public static final int  CPC_R = 2;//左侧斜率控制
	public static final int  CPC_L = 1;//右侧斜率控制
	public static final int  CPC_RL = 3;//两侧斜率控制
	public static final int  CPC_N = 0;//无斜率控制
	public float t,h,kr,kl;
	public int type;
	/**  
	 * @Constructor: ControlPointCubic
	 * @Description: ControlPointCubic构造函数
	 * @author BingGoqi
	 * @date 2024-06-03 10:19:27 
	 */ 
	public ControlPointCubic(float t,float h,float kr,float kl,int type) {
		this.type = type;
		this.t = t;
		this.h = h;
		this.kr = kr;
		this.kl = kl;
	}
	/**  
	 * @MethodName: getScetion
	 * 生成三次曲线段
	 * @author BingGoqi
	 * @param cpc next ControlPointCubic
	 * @return SectionCubic
	 * @date 2024-06-03 10:19:36 
	 */  
	public SectionCubic getScetion(ControlPointCubic cpc) {
		return new SectionCubic().setCubicIter(h, cpc.h, kl, cpc.kr, t, cpc.t,((type<<2|cpc.type)>>1)&CPC_RL);
	}
}