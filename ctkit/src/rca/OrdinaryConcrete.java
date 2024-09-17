package rca;

public class OrdinaryConcrete {
	static ClampVar[] cl;
	static float[] il,ol;
	public static boolean Test() {
	boolean r = false;
	float as,af,fk,tl;
	as=il[0];af=il[1];fk=il[2];tl=il[3];
	float fo,fb,wc,mw,mg,mc,mf,ms;
	fo = fk+8.225f;//设计强度
	fb = 49.4f;//水泥强度
	wc = 0.53f*fb/(fo+0.106f*fb);//水胶比
	mw = 215+(tl-90)/4;//水量
	mw *= 0.72;//磷酸减水剂
	mg = mw/wc;//胶量
	mf = mg*af;//粉煤灰
	ms = mg*as;//矿渣粉
	mc = mg-ms-mf;//水泥
	//float[] l = {as,af,mg,wc,mw,mc,ms0,mg0,fk,fb};
	ol[0]=mc;
	return r;
	}
	public static boolean eq(float a1,float a2) {
		return Math.abs(a1-a2)<1e-5;
	}
}
