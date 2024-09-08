package rca;

public class RecycledConcrete {
	static ClampVar[] cl;
	static float[] il,ol;
	public static boolean Test() {
	boolean r = false;
	float as,af,fk,kw,ks,bk,tl,bw,sg,al;
	as=il[0];af=il[1];fk=il[2];kw=il[3];ks=il[4];
	bk=il[5];tl=il[6];bw=il[7];sg=il[8];al=il[9];
	float fo,fb,wc,mw,mg,mc,mf,ms;
	float kks,kka;
	kka = 1-(0.60856f-0.074f)*al;
	fo = fk+1.645f*sg;
	kks = 1.104f-0.614f*as;
	kks = kks>1?1:kks;
	fb =  (1-af)*kks*49.4f;
	wc = 0.53f*kka*fb/(fo+0.106f*fb*kka);
	mw = 215+(tl-90)/4+kw;
	if(eq(bw,1)) mw *= 0.72;
	mg = mw/wc;
	mf = mg*af;
	ms = mg*as;
	mc = mg-ms-mf;
	float G,bs,ms0,mg0;
	G = 2400-mw-mg;
	bs = 0.03f*wc+0.278f+tl/2000+ks+0.03f;
	ms0 = G*bs;
	mg0 = G*(1-bs);
	float fe = 1.221438f*fb*(1-0.32f*al);
	float[] l = {as,af,mg,wc,mw,mc,ms0,mg0,fk,fb,fe,al};
	ol = l;
	return r;
	}
	public static boolean eq(float a1,float a2) {
		return Math.abs(a1-a2)<1e-5;
	}
}
