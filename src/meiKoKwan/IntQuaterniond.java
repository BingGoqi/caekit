package meiKoKwan;

import org.joml.Quaterniond;
import org.joml.Vector3d;

import static meiKoKwan.MathExtends.*;

public class IntQuaterniond extends Quaterniond {
	void addRotate(Vector3d rv,double dt) {
		addRotate(rv.x, rv.y, rv.z, dt);
	}
	void addRotate(double rx,double ry,double rz,double dt) {
		//https://www.cnblogs.com/QiQi-Robotics/p/14562475.html
		dt *= .5;
		double
		q4 = fma(-rx,x,fma(-ry,y,-rz*z)),
		q1 = fma(rx,w,fma(-ry,z,rz*y)),
		q2 = fma(rx,z,fma(ry,w,-rz*x)),
		q3 = fma(-rx,y,fma(ry,x,rz*w));
		x = fma(dt,q1,x);
		y = fma(dt,q2,y);
		z = fma(dt,q3,z);
		w = fma(dt,q4,w);
		//normalize();//TODO 需验证 Quaterniond.integrate
	}
}
