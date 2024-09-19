package simple;

import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;

import java.nio.FloatBuffer;

import org.joml.Matrix4d;
import org.joml.Vector3d;
import org.lwjgl.system.MemoryStack;

public class Camera {
	static FloatBuffer fb;
	static final double pinv2 = Math.PI/2-1e-5;
	int x,y;
	double yaw,pitch;
	Matrix4d tp = new Matrix4d().setPerspective(3.14/3, 1, 0.2f, 1000f);
	Matrix4d move;
	Vector3d pos;
	boolean first = true;
	static {
		try (MemoryStack stack = MemoryStack.stackPush()) {
			fb = stack.mallocFloat(16);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	Matrix4d mat;
	double camspeed = 0.1;
	Vector3d tpv = new Vector3d();
	public Camera(Vector3d eye,Vector3d look) {
		pos = new Vector3d(eye);
		mat = new Matrix4d();
		move  = new Matrix4d().setLookAt(eye,look, Const.Y);
		tp.mulPerspectiveAffine(move, mat);
	}
	public void move(Vector3d ruf) {
		ruf.mul(camspeed);
		mat.transformDirection(ruf);
		move.translate(ruf);
		pos.sub(ruf);
	}
	public void flush(int unifrom) {
		tp.mulPerspectiveAffine(move, mat);
		mat.get(fb);
		glUniformMatrix4fv(unifrom, false, fb);
	}
	public boolean tomove(byte[] keymap,double scal) {
		int x,y,z;
		x=y=z=0;
		x += keymap[65];
		x -= keymap[68];
		y += keymap[340];
		y -= keymap[32];
		z += keymap[83];
		z -= keymap[87];
		if(x==0&&z==0&&y==0)return false;
		tpv.set(x,y,z).mul(scal);
		move(tpv);
		return true;
	}
	public boolean torotate(int x,int y,double scal) {
		if(first) {
			first = false;
			this.x = x;
			this.y = y;
		}
		double dx,dy;
		dx = this.x-x;
		dy = this.y-y;
		if(dx==0&&dy==0)return false;
		dx *= scal;
		dy *= scal;
		this.x = x;
		this.y = y;
		rotate(dx,dy);
		return true;
	}
	public void rotate(double dx,double dy) {
		yaw += dx;
		pitch += dy;
		if(pitch > pinv2)pitch = pinv2;
		if(pitch < -pinv2)pitch = -pinv2;
		double cx,cy,cz;
		cz = Math.cos(pitch);
		cy = Math.sin(pitch);
		cx = Math.sin(yaw)*cz;
		cz *= -Math.cos(yaw);
		move.setLookAt(pos.x,pos.y,pos.z,pos.x+cx, pos.y+cy, pos.z+cz, 0, 1, 0);
	}
}
