package rca;

public class OrdinaryConcrete {
	static ClampVar[] cl;
	static float[] il,ol;
	public static boolean Test() {
	boolean r = false;
	float as,af,fk,kw,ks,bk,tl,bw,sg;
	as=il[0];af=il[1];fk=il[2];kw=il[3];ks=il[4];
	bk=il[5];tl=il[6];bw=il[7];sg=il[8];
	float fo,fb,wc,mw,mg,mc,mf,ms;
	fo = fk+1.645f*sg;//设计强度
	fb = 49.4f;//水泥强度
	wc = 0.53f*fb/(fo+0.106f*fb);//水胶比
	mw = 215+(tl-90)/4+kw;//水量
	if(eq(bw,1)) mw *= 0.72;//磷酸减水剂
	mg = mw/wc;//胶量
	mf = mg*af;//粉煤灰
	ms = mg*as;//矿渣粉
	mc = mg-ms-mf;//水泥
	float G,bs,ms0,mg0;
	G = 2400-mw-mg;//骨料量
	bs = 0.03f*wc+0.278f+tl/2000+ks+0.03f;//砂率
	ms0 = G*bs;//细骨料
	mg0 = G*(1-bs);//粗骨料
	float[] l = {as,af,mg,wc,mw,mc,ms0,mg0,fk,fb};
	ol = l;
	return r;
	}
	public static boolean eq(float a1,float a2) {
		return Math.abs(a1-a2)<1e-5;
	}
}
