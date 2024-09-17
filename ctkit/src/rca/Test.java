package rca;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Test {
	static float[] list = new float[8];
	static final ConcurrentLinkedQueue<String> fl = new ConcurrentLinkedQueue<String>();
	static final File f = new File("out.txt");
	static boolean q = false;
//------------------------------------------------------
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				String s;
				try(final var fo = new FileOutputStream(f)){
					while(!q) {
						while(!fl.isEmpty()) {
							s = fl.poll();
							fo.write(s.getBytes());
						}
						Thread.sleep(1);
					}
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		ClampVar c = new ClampVar(0, 0.25f, 21);
				c.add(0,0.4f,21).add(36f,36.8f,9)
				.add(200).add(0.5f);
		
		while(!q) {
			c.getlist(list);
			if(RecycledConcrete.Test(list)) {
				fl.offer(fprint(list));
			}
			q = !c.next();
		}
	}
//------------------------------------------------------
	public static String fprint(float[] l) {
		StringBuilder s = new StringBuilder(l.length*10);
		for(var p:l) {
			s.append(String.format("%.3f", p));
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
		System.out.println(s.toString());
	}
	public static boolean eq(float a1,float a2) {
		return Math.abs(a1-a2)<1e-5;
	}
}