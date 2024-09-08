package space.frame;

import org.joml.AxisAngle4d;
import org.joml.Matrix4d;
import org.joml.Vector3d;

public class Matrix4dForm implements TransForm ,GRSf{
	final Matrix4d m= new Matrix4d(),invm= new Matrix4d();
	public Matrix4dForm() {
	}
	public Matrix4dForm(Vector3d move,Vector3d scal,AxisAngle4d aa,int order) {
		m.translate(move);
		switch(order) {
		case GRS -> m.rotate(aa).scale(scal);
		case GSR ->m.scale(scal).rotate(aa);
		}
		m.invert(invm);
	}
	@Override
	public void tSup(Vector3d v) {
		m.transformProject(v);
	}
	@Override
	public void tThis(Vector3d v) {
		invm.transformProject(v);
	}
}