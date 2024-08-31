package space.frame;

import org.joml.Vector3d;
//import static meiKoKwan.MathExtends.*;

class Test{
	public static void main(String[] args) {
	var f = new TCTPFrame(new Frame(), "TCTP", 1, 0.007, Math.PI/4);
	Vector3d
	p = new Vector3d(1,1,1);
	//k = new Vector3d(PI/4,atan(sqrt(2.)/2),3/sqrt(3.)-1);
	f.tThis(p);
	System.out.println(p);
	f.tSup(p);
	System.out.println(p.sub(1,1,1).x);	
	}
}