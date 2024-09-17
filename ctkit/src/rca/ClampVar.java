package rca;

public class ClampVar {
	float v,dv;
	int p,i = 0;
	ClampVar next;
	public ClampVar(float a) {
		v = a;
		p = 1;
	}
	public ClampVar(float a,float b) {
		v = a;
		dv = b-a;
		p = 2;
	}
	public ClampVar(float a,float b,int p) {
		v = a;
		dv = b-a;
		dv /= (p-1);
		this.p = p;
	}
	float getVal() {
		return Math.fma(dv, i, v);
	}
	boolean next() {
		var c = this;
		while(c != null) {
			c.i++;
			if(c.i < c.p) return true;
			if(c.next != null) c.i = 0;
			c = c.next;
		}
		return false;
	}
	public ClampVar add(float a) {
		next = new ClampVar(a);
		return next;
	}
	public ClampVar add(float a,float b) {
		next = new ClampVar(a,b);
		return next;
	}
	public ClampVar add(float a,float b,int p) {
		next = new ClampVar(a,b,p);
		return next;
	}
	void getlist(float[] l) {
		var c = this;
		int i = 0;
		while(c != null) {
			l[i++] = c.getVal();
			c = c.next;
		}
	}
}