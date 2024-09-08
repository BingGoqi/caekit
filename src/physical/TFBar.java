package physical;

import org.joml.Vector3f;

public class TFBar {
	Part pa,pb;
	int ida,idb;
	float l,dl,ddl;
	float k,vk;
	void flush() {
		Vector3f t1,t2,t; 
		t1 = pa.get(ida);//craft坐标下
		t2 = pb.get(idb);
		t = new Vector3f(t1).sub(t2);
		float nl = t.length();
		ddl = nl-l-dl;
		dl = nl-l;
		t.normalize();
		float f = dl*k-ddl*vk;
		pa.addTFBForce(t1.sub(pa.p),new Vector3f(t).mul(f));//part坐标下
		pb.addTFBForce(t2.sub(pb.p),new Vector3f(t).mul(-f));
	}
}
