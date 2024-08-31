package space.frame;

import org.joml.AxisAngle4d;
import org.joml.Vector3d;

import static meiKoKwan.MConst.*;

public class GRSfrom implements TransForm,GRSf{
	Vector3d move,scal;
	double scald = 0;
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
	public GRSfrom(Vector3d move,double scald,AxisAngle4d aa,int order) {
		this.order = order;
		this.aa = aa;
		this.move = move;
		this.scald = scald;
		if(1 == scald) scal = TONE;
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
		if(ZERO != move)v.add(move);
		return v;
	}
	private Vector3d nmove(Vector3d v) {
		if(ZERO != move)v.sub(move);
		return v;
	}
	private Vector3d scal(Vector3d v) {
		if(TONE != scal) {
			if(0 == scald) {
				v.mul(scal);
			}else v.mul(scald);
		}
		return v;
	}
	private Vector3d nscal(Vector3d v) {
		if(TONE != scal) {
			if(0 == scald) {
				v.div(scal);
			}else v.div(scald);
		}
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
	//byte GR  = 0b011000;
	//byte RG  = 0b100100;//TOOD 待补全
	AxisAngle4d IDENTITY = new AxisAngle4d();
	GRSfrom IForm = new GRSfrom();
}
