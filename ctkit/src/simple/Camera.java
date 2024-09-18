package simple;

import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;

import java.nio.FloatBuffer;

import org.joml.Matrix4d;
import org.joml.Vector3d;
import org.lwjgl.system.MemoryStack;

public class Camera {
	static FloatBuffer fb;
	static {
		try (MemoryStack stack = MemoryStack.stackPush()) {
			fb = stack.mallocFloat(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	Matrix4d mat;
	double camspeed;
	public Camera(Vector3d eye,Vector3d look) {
		Matrix4d tp = new Matrix4d().setPerspective(1, 1, 0.01f, 1000f);
		mat = new Matrix4d().setLookAt(eye, look, Const.Y);
		tp.mulPerspectiveAffine(mat, mat);
		tp = null;
	}
	public void move(Vector3d ruf) {
		ruf.mul(camspeed);
		mat.transformPosition(ruf);
		mat.setTranslation(ruf);
	}
	public void flush(int unifrom) {
		mat.get(fb);
		glUniformMatrix4fv(unifrom, false, fb);
	}
	public void rotate() {
		
	}
}
