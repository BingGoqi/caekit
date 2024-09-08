package rca;

public class ClampVar {
	private double min,max,dp;
	private int dn,pn,index;
	public ClampVar(double val,int i) {
		index = i;
		dp = 0;
		min = val;
		dn = 1;
	}
	public ClampVar(double a1,double a2,int i) {
		index = i;
		min = a1;
		dp = a2-a1;
		dn = 2;
	}
	public ClampVar(double min,double max,int n,int index) {
		this.max = max;
		this.min = min;
		this.index = index;
		dn = n;
		dp = (max-min)/(n-1);
	}
	public double getVal(int n) {
		if(n > dn)n=dn;
		if(n < 0)n = 0;
		return min+dp*n;
	}
	public boolean next(float[] il) {
		pn++;
		var b = pn==dn;
		if(b) pn = 0;
		il[index] = (float) getVal(pn);
		return b;
	}
}
