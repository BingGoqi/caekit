package animtion;

/**  
 * @ClassName: SectionCubic
 * 三次插值曲线，需优化，是否加入二次曲线支持
 * @author BingGoqi
 * @date 2024-06-03 10:11:51 
*/  

public class SectionCubic implements Section {
	private float A,B,C,D;//存储计算使用而非设置使用
	private float speed=1;
	private float nstart=0;
	private int type=1;
	public SectionCubic() {
		A=B=C=D=0;
	} 
	private SectionCubic setSpeed(float start,float end) {
		speed=1/(end-start);
		nstart=-start*speed;
		return this;
	}
	/**  
	 * @MethodName: SetCubic
	 * type == 3->a*x^3+b*x^2+c*x+d
	 * not ->  c*x+d
	 * t0->x=0
	 * t1->x=1
	 * @author BingGoqi
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param t0
	 * @param t1
	 * @param type
	 * @return SectionCubic
	 * @date 2024-06-03 10:07:46 
	 */  
	public SectionCubic SetCubic(float a,float b,float c,float d,float t0,float t1,int type) {
		A=a;
		B=b;
		C=c;
		D=d;
		this.type = type==3?3:1;
		setSpeed(t0,t1);
		return this;
	}
	/**  
	 * @MethodName: SetCubicMata
	 * 反序列化使用
	 * @author BingGoqi
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param speed
	 * @param nstart
	 * @param type
	 * @return SectionCubic
	 * @date 2024-06-03 10:13:33 
	 */  
	public SectionCubic SetCubicMata(float a,float b,float c,float d,float speed,float nstart,int type) {
		A=a;
		B=b;
		C=c;
		D=d;
		this.speed = speed;
		this.nstart = nstart;
		this.type = type;
		return this;
	}
	/**  
	 * @MethodName: setCubicIter
	 * 控制点转三次曲线
	 * @author BingGoqi
	 * @param h0
	 * @param h1
	 * @param k0
	 * @param k1
	 * @param t0
	 * @param t1
	 * @param type
	 * @return SectionCubic
	 * @date 2024-06-03 10:14:00 
	 */  
	public SectionCubic setCubicIter(float h0,float h1,float k0,float k1,float t0,float t1,int type) {
		setSpeed(t0,t1);
		if(Math.abs(t1-t0)<1e-5) {//防止 "1/0"
			C = 0;
			D = (h1-h0)/2;
			this.type = 1;
		}
		this.type = type==3?3:1;
		switch(type) {
		case 3->{
			D=h0;
			C=k0;
			h0=h1-h0;
			A=-2*h0+k0+k1;
			B=h0-k0-A;
		}
		case 2 ->{
			C=k0;
			D=h0;
		}case 1->{
			C=k1;
			D=h1-k1;
		}
		case 0->{
			D=h0;
			C=h1-h0;
		}
		default -> throw new IllegalArgumentException("Unexpected value: " + type);
		}
		return this;
	}
	@Override
	public float getStart() {
		return -nstart/speed;
	}
	@Override
	public float getEnd() {
		return 1/speed+getStart();
	}
	@Override
	public float getVal(float t) {
		t = Math.fma(speed, t, nstart);
		return switch(type) {//由此加入二次函数支持
		case 3 -> Math.fma(Math.fma(Math.fma(A, t, B), t, C), t, D);
		case 1 -> Math.fma(C, t, D);
		default -> throw new IllegalArgumentException("Unexpected value: " + type);
		};
	}
	@Override
	public float getValK(float t) {
		t = Math.fma(speed, t, nstart);
		return switch(type) {//由此加入二次函数支持
		case 3 -> Math.fma(Math.fma(3*A, t, 2*B), t, C);
		case 1 -> C;
		default -> throw new IllegalArgumentException("Unexpected value: " + type);
		};
	}
	@Override
	public int getCompare(float t) {
		return t<getStart()?-1:t>getEnd()?1:0;
	}
}
