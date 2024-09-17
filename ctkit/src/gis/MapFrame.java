package gis;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MapFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	int i;
	double f;
	int WIDTH = 500,HEIGHT = 400;
	int[] l = new int[WIDTH*HEIGHT];
	BufferedImage ofs = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_USHORT_565_RGB);
	public MapFrame() {
		super("Map test");
		setSize(WIDTH, HEIGHT);
		setLocale(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}
	@Override
	public void update(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		paint(ofs.getGraphics());
		g.drawImage(ofs, 0, 0, null);
	}
	private void init(){
		int x,y;
		for(int i=0;i<l.length;i++) {
			y = i/WIDTH;
			x = i%HEIGHT;
			l[i] = x+y;
		}
	}
	@Override
	public void paint(Graphics g) {
	}
	public static void main(String[] args) {
		var f = new MapFrame();
		f.setVisible(true);
		long t;
		int s = 0;
		while(true) {
			s++;
			if(s > 600) {
				s = 0;
				System.gc();
			}
			t = System.currentTimeMillis()+16;
			f.repaint();
			try {
				Thread.sleep(max(t-System.currentTimeMillis(),0l));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private static long max(long l, long m) {
		return l>m?l:m;
	}
}