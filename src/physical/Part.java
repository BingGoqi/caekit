package physical;

import org.joml.Quaternionf;
import org.joml.Vector3f;

public class Part {
	Vector3f p,v;
	Vector3f rv,ir;
	Quaternionf iq;
	float m;
	Vector3f a,rm;//加速度,外力矩
	Vector3f tmp;
	public Part(float m,Vector3f ir) {
		ir = new Vector3f(ir);
		this.m = m;
	}
	void p2craf(Vector3f v) {
		iq.transformInverse(v);
		v.add(p);
	}
	void c2part(Vector3f v) {
		v.sub(p);
		iq.transform(v);
	}
	void addF(Vector3f f) {//外部坐标
		a.fma(1/m, f);
	}
//	void addCraftMoment(Vector3d m) {
//		rm.add(m);
//	}
	void addTFBForce(Vector3f p,Vector3f f) {
		a.fma(1/m, f);
		rm.add(tmp.set(f).cross(p));
		//ra.x += (ir.y-ir.z)*rv.y*rv.z;
		//ra.y += (ir.z-ir.x)*rv.z*rv.x;
		//ra.z += (ir.x-ir.y)*rv.x*rv.y;
		//ra.div(ir);
	}
	void flush1(float dt) {//计算系统外力
		a.mul(dt*0.5f);
		v.add(a);
		p.fma(dt, v);
		v.add(a);
		a.set(0);
		
		//iq.transformInverse(rm);
		rm.mul(dt*0.5f);
		rv.add(rm);
		iq.integrate(rv.x, rv.y, rv.z, dt);
		rv.add(rm);
		rm.set(0);
	}
	void flush2() {//计算内力
		
	}
}
