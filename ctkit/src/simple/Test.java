/**  
 * @Title: Test.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-06 10:15:46 
 */ 

package simple;

import static org.lwjgl.opengl.GL20.*;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryUtil;

import org.joml.Vector3d;

/**  
 * @ClassName: Test
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-06 10:15:46 
*/

public class Test {
	private Window window;
	private Shader vs,fs;
	GLProgram gp;
	private int vbo;
	private Vao vao;
	Camera c;
	Texture t;
	int upm;
	public void init() throws Exception {
		window = new Window(600, 600, "LearnOpenGL-CN");
		gp = new GLProgram();
		vs = new Shader(Const.tv3, GL_VERTEX_SHADER);
		fs = new Shader(Const.tf2, GL_FRAGMENT_SHADER);
		gp.addShader(vs);
		gp.addShader(fs);
		gp.link();
		gp.use();
		glActiveTexture(GL_TEXTURE0);
		t = new Texture("./sp/texture/01.png");
		t.free();
		vao = new Vao();
		//vbo
		float[] flist = {-.9f,-.9f,0, 1,0,0, 0,0
						,.9f,-.9f,0,  0,1,0, 1,0
						  ,0,.9f,0,   0,0,1, .5f,1};
		FloatBuffer fbuffer = BufferUtils.createFloatBuffer(flist.length);
		fbuffer.put(flist);
		fbuffer.flip();
		vbo = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, fbuffer, GL_STATIC_DRAW);
		if(fbuffer != null) {
			MemoryUtil.memFree(fbuffer);
		}
		//mvp
		upm = glGetUniformLocation(gp.getPrt(), "pm");
		c = new Camera(new Vector3d(2,2,-3), new Vector3d(0,0,0));
		c.flush(upm);
		vao.add(new VData(GL_FLOAT, 3)).add(new VData(GL_FLOAT, 3)).add(new VData(GL_FLOAT, 2));
		vao.set();
	}
	public void run() throws InterruptedException {
		long t;
		window.show();
		glClearColor(.2f, .3f, .3f, 1);
		while(!window.IsClose()) {
			t = System.currentTimeMillis()+16;
			glClear(GL_COLOR_BUFFER_BIT);
			glDrawArrays(GL_TRIANGLES, 0, 3);
			window.flush();
			Thread.sleep(max(t-System.currentTimeMillis(),1));
		}
	}
	public void free() {
		vao.free();
		glDeleteBuffers(vbo);
		vs.delete();
		fs.delete();
		gp.free();
		window.free();
	}
	private final long max(long a, long b) {return a>b?a:b;}
	public static void main(String[] args) throws Exception {
		Test t = new Test();
		t.init();
		t.run();
		t.free();
	}
}
