package rca;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Test {//			 0   1   2  3 4    5    6   7 8 9
	//public static double[] il = {0.2,0.2,50,0,0.05,0.23,200,1,5,0};
	public static final float[] il = {0,0,30,0,0.02f,0,200,1,6,0};
	public static float[] ol;
	public static final ClampVar[] cl = new ClampVar[10];
	static int i = 0,j = 0,k = 1;
	static final ConcurrentLinkedQueue<String> fl = new ConcurrentLinkedQueue<String>();
	static final File f = new File("out.txt");
	static boolean q = true;
	
	static float max ,mbx = 1e3f ;
	public static void main(String[] args) {
		cl[0] = new ClampVar(0, .3, 301, 0);
		cl[1] = new ClampVar(0,1);
		cl[2] = new ClampVar(30,45,4, 2);
		cl[3] = new ClampVar(0,3);
		cl[4] = new ClampVar(0.02,4);
		cl[5] = new ClampVar(.3, 5);//new ClampVar(0, 1, 11, 5);
		cl[6] = new ClampVar(200,6);
		cl[7] = new ClampVar(1,7);
		cl[8] = new ClampVar(6,8);
		cl[9] = new ClampVar(0,1,11,9);//1,20
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				
				try(final var fo = new FileOutputStream(f)){
					String s;
					k = 0;
					while(q || k<j) {
						while(!fl.isEmpty()) {
							s = fl.poll();
							fo.write(s.getBytes());
							k++;
						}
						Thread.sleep(1);
					}
					System.out.println("FQ"+k);
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		try{
			while(q) {
				if(Test1()) {
					//fl.offer(fprint(il));
					fl.offer(fprint(ol));
					j++;
					//j++;
				}
				while(cl[i].next(il)) {i++;}
				i = 0;
		}
		}catch (Exception e) {
			q = false;
			System.out.println("catch to"+j);
		}
		System.out.println(max+"|"+mbx);
	}
	public static String fprint(float[] l) {
		StringBuilder s = new StringBuilder(l.length*10);
		for(var p:l) {
			s.append(String.format("%.2f", p));
			s.append('\t');
		}
		s.append('\n');
		return s.toString();
	}
	public static void print(float[] l) {
		StringBuilder s = new StringBuilder(l.length*10);
		for(var p:l) {
			s.append(String.format("%g", p));
			s.append('\t');
		}
		System.out.println(s);
	}
	public static boolean Test1() {
		boolean r = false;
		float as,af,fk,kw,ks,bk,tl,bw,sg,al;
		as=il[0];af=il[1];fk=il[2];kw=il[3];ks=il[4];
		bk=il[5];tl=il[6];bw=il[7];sg=il[8];al=il[9];
		float fo,fb,wc,mw,mg,mc,mf,ms;
		float kks,kka;
		kka = 1-(0.60856f-0.074f)*al;
		fo = fk+1.645f*sg;
		//fb = 49.4;
		kks = 1.104f-0.614f*as;
		kks = kks>1?1:kks;
		fb =  (1-af)*kks*49.4f;
		wc = 0.53f*kka*fb/(fo+0.106f*fb*kka);//0.2466832f*fb/(fo + 0.04933664f*fb);
		//wc = 0.53f*fb/(fo+0.106f*fb);
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
		float my = 0,mp = 29;
		my += mf*0.1;
		my += ms*0.21;
		my += mc*0.37;
		my += mw * 0.005;
		my += ms0*0.0521;
		my += mg0*(0.056-0.026*al);
		my += bw*0.025*mc;
		mp += Math.floor((fk-30)/5);
		mp += Math.floor((al-.29)/.1);
		//if( mp > 41&&al > .3&&mg > 330 && wc < .5 && as+af<.4) {
		if( al > .3 &&wc > .4&&wc < .5 && as+af<.4&& mp > 30 && my<247.1109 && eq(fk,40)) {
			r = true;
			max = Math.max(max,my);
			mbx = Math.min(mbx, my);
		}
		//float[] l = {mf,ms,mc,ms0,mg0,bw,mw,fk,my};
		float[] l = {as,af,mg,wc,mw,mc,ms0,mg0,fk,fb,fe,al,mp,my};
		ol = l;
		return r;
	}
	public static boolean eq(float a1,float a2) {
		return Math.abs(a1-a2)<1e-5;
	}
}