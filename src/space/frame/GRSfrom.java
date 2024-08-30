package space.frame;

import org.joml.AxisAngle4d;
import org.joml.Vector3d;

import static meiKoKwan.MConst.*;

public class GRSfrom implements TransFrome,GRSf{
	Vector3d move,scal;
	AxisAngle4d aa,na;
	int order;//final
	public GRSfrom() {
		move = ZERO;
		scal = TONE;
		aa = IDENTITY;
		na = IDENTITY;
		order = 0;
	}
	public GRSfrom(Vector3d move,Vector3d scal,AxisAngle4d aa,int order) {
		this.order = order;
		this.aa = aa;
		this.move = move;
		this.scal = scal;
		na = new AxisAngle4d(aa);
		na.angle = -na.angle;
	}
	@Override
	public void tSup(Vector3d in, Vector3d out) {
		out.set(in);
		switch(order) {
		case GRS ->scal(rtt(move(out)));
		case GSR ->rtt(scal(move(out)));
		}
	}
	@Override
	public void tThis(Vector3d in, Vector3d out) {
		out.set(in);
		switch(order) {
		case GRS ->nmove(nrtt(nscal(out)));
		case GSR ->nmove(nscal(nrtt(out)));
		}
	}
	private Vector3d move(Vector3d v) {
		if(ZERO != move)v.sub(move);
		return v;
	}
	private Vector3d nmove(Vector3d v) {
		if(ZERO != move)v.add(move);
		return v;
	}
	private Vector3d scal(Vector3d v) {
		if(TONE != scal)v.div(scal);
		return v;
	}
	private Vector3d nscal(Vector3d v) {
		if(TONE != scal)v.mul(scal);
		return v;
	}
	private Vector3d rtt(Vector3d v) {
		if(IDENTITY != aa)aa.transform(v);
		return v;
	}
	private Vector3d nrtt(Vector3d v) {
		if(IDENTITY != aa)na.transform(v);
		return v;
	}
}
interface GRSf{
	byte GRS = 0b011011;
	byte GSR = 0b011110;
	AxisAngle4d IDENTITY = new AxisAngle4d();
	GRSfrom IForm = new GRSfrom();
}
