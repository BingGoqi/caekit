package physical;

import org.joml.Quaterniond;
import org.joml.Vector3d;


public class Part {
	Vector3d p,v;
	Vector3d rv,ir;
	Quaterniond iq;
	double m;
	Vector3d a,ra;
	Vector3d tmp;
	public Part(double m,Vector3d ir) {
		ir = new Vector3d(ir);
		this.m = m;
	}
	void addF(Vector3d p,Vector3d f) {
		a.fma(1/m, f);
		ra.add(tmp.set(f).cross(p));
		ra.x += (ir.y-ir.z)*rv.y*rv.z;
		ra.y += (ir.z-ir.x)*rv.z*rv.x;
		ra.z += (ir.x-ir.y)*rv.x*rv.y;
		ra.div(ir);
	}
	void flush1(double dt) {//计算系统外力
		iq.transformInverse(ra);
		a.mul(dt*0.5);
		v.add(a);
		p.fma(dt, v);
		v.add(a);
		a.set(0);
		
		ra.mul(dt*0.5);
		rv.add(ra);
		iq.integrate(rv.x, rv.y, rv.z, dt);
		rv.add(ra);
		ra.set(0);
	}
	void flush2() {//计算内力
		
	}
}
