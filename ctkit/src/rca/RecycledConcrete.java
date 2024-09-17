package rca;

public class RecycledConcrete {
	private RecycledConcrete() {};
	static int i = 0;
	public static boolean Test(float[] il) {
	boolean r = false;
	//矿渣，煤灰，设计强度，坍落，再生比例
	float as,af,fk,tl,al;
	as=il[0];af=il[1];fk=il[2];tl=il[3];al=il[4];
	float fo,fb,wc,mw,mg,mc,mf,ms;
	float kks,kka;
	if(as+af > 0.5) return false;
	kka = 1-(0.60856f-0.074f)*al;
	
	fo = fk>30.1?fk+9.87f:fk+8.225f;
	
	kks = 1.104f-0.614f*as;
	kks = kks>1?1:kks;
	
	fb =  (1-af)*kks*49.4f;
	
	wc = 0.53f*kka*fb/(fo+0.106f*fb*kka);
	if(wc < 0.38) return false;
	if(wc > 0.5) return false;
	mw = 215+(tl-90)/4;
	mw *= 0.72;
	
	mg = mw/wc;
	mf = mg*af;
	ms = mg*as;
	mc = mg-ms-mf;
	float G,bs,ms0,mg0;
	G = 2400-mw-mg;
	bs = 0.03f*wc+0.278f+tl/2000+0.03f;
	ms0 = G*bs;
	mg0 = G*(1-bs);
	
	il[5] = fb;
	il[6] = mc*0.4125f+mf*0.1f+ms*0.21f+ms0*0.0521f+mg0*(0.056f-0.026f*al);
	il[7] = floor(fk/5) - 6 + floor(al*10 - 3) + 33;
	if(il[7] > 35) {
		r = true;
		//System.out.println(i++);
	}
	//r = true;
	return r;
	}
	private static int floor(float f) {
		return (int)f;
	}
	public static boolean eq(float a1,float a2) {
		return Math.abs(a1-a2)<1e-5;
	}
}
