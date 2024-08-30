package space.frame;

import org.joml.Vector3d;

public class Frame {
	private final Frame sup;
	private final byte rank;
	final String name;
	private final TransFrome tf;
	public Frame tsub;//TOOD 临时
	private UnInertial ui;
	public Frame(Frame sup,String name,TransFrome tf) {
		this.name = name;
		this.sup = sup;
		this.rank = (byte) (sup.rank+1);
		this.tf = tf;
	}
	void tSup(Vector3d v) {
		tf.tSup(v, v);
	}
	void tSup(Vector3d in,Vector3d out) {
		tf.tSup(in, out);
	}
	void tThis(Vector3d v) {
		tf.tThis(v, v);
	}
	void tThis(Vector3d in,Vector3d out) {
		tf.tThis(in, out);
	}
	void tFrame(Vector3d in,Vector3d out,Frame fSup) {
		Frame tp = this;
		byte t = fSup.rank;
		out.set(in);
		while(tp.rank > t) {
			tp.tSup(out);
			tp = tp.sup;
			}
	}
	void tFrame(Vector3d in,Vector3d out,Frame fSup,int a) {
		Frame tp = Frame.getSup(this, fSup, a);
		tFrame(in, out,tp);
		
	}
	void tFrame(int a,Vector3d in,Vector3d out,Frame fSub) {
		Frame tp = tsub;
		byte t = fSub.rank;
		out.set(in);
		while(tp.rank <= t) {
			tp.tThis(out);
			tp = tp.tsub;
			}
	}
	static Frame getSup(Frame f1,Frame f2) {
		Frame tp;
		if(f2.rank>f1.rank) {
			tp = f1;
			f1 = f2;
			f2 = tp;
		}
		while(f1.rank > f2.rank) {
			f1 = f1.sup;
		}
		while(f1.sup != f2.sup) {
			f1 = f1.sup;
			f2 = f2.sup;
		}
		return f1;
	}
	static Frame getSup(Frame f1,Frame f2,int a) {
		Frame tp;
		boolean b = false;
		if(f2.rank>f1.rank) {
			tp = f1;
			f1 = f2;
			f2 = tp;
			b = true;
		}
		while(f1.rank > f2.rank) {
			if(b)f1.sup.tsub = f1;
			f1 = f1.sup;
		}
		while(f1.sup != f2.sup) {
			if(b) {
				f1.sup.tsub = f1;
				f1 = f1.sup;
			}else {
				f2.sup.tsub = f2;
				f2 = f2.sup;
			}
		}
		return f1;
	}
}
