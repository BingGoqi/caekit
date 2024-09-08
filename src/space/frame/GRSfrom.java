package space.frame;

import org.joml.AxisAngle4d;
import org.joml.Vector3d;

import static meiKoKwan.MConst.*;

public class GRSfrom implements TransForm,GRSf{
	Vector3d move,scal;
	/**			scald
	 * 			1	v
	 * 	scal   不缩放	同向缩放
	 * 		  异向缩放	XXXXX
	 */
	private final double scald;
	private final AxisAngle4d aa,na;
	private final int order;//final
	public GRSfrom() {
		this.scald = 1;
		move = ZERO;
		scal = TONE;
		aa = IDENTITY;
		na = IDENTITY;
		order = 0;
	}
	public GRSfrom(Vector3d move,Vector3d scal,AxisAngle4d aa,int order) {
		this.scald = 1;//
		this.order = order;
		//this.aa = aa;
		this.move = move == ZERO?ZERO:new Vector3d(move);
		this.scal = scal == TONE?TONE:new Vector3d(scal);
		this.aa = aa == IDENTITY?IDENTITY:new AxisAngle4d(aa);
		na = aa == IDENTITY?IDENTITY:new AxisAngle4d(aa);;
		na.angle = -na.angle;
	}
	public GRSfrom(Vector3d move,double scald,AxisAngle4d aa,int order) {
		this.order = order;
		this.move = move == ZERO?ZERO:new Vector3d(move);
		this.scald = scald;
		if(1 == scald) scal = TONE;
		this.aa = aa == IDENTITY?IDENTITY:new AxisAngle4d(aa);
		na = aa == IDENTITY?IDENTITY:new AxisAngle4d(aa);;
		na.angle = -na.angle;
	}
	@Override
	public void tSup(Vector3d v) {
		switch(order) {
		case GRS ->scal(rtt(move(v)));
		case GSR ->rtt(scal(move(v)));
		}
	}
	@Override
	public void tThis(Vector3d v) {
		switch(order) {
		case GRS ->nmove(nrtt(nscal(v)));
		case GSR ->nmove(nscal(nrtt(v)));
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
			v.mul(scal);
		}else if(1 != scald){
			v.mul(scald);
		}
		return v;
	}
	private Vector3d nscal(Vector3d v) {
		if(TONE != scal) {
			v.div(scal);
		}else if(1 != scald){
			v.div(scald);
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
