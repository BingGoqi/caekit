/**  
 * @Title: Test.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-06 10:15:46 
 */ 

package simple;

import static org.lwjgl.opengl.GL20.*;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

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
	public void init() {
		window = new Window(600, 600, "LearnOpenGL-CN");
		gp = new GLProgram();
		vs = new Shader(Const.tv2, GL_VERTEX_SHADER);
		gp.addShader(vs);
		fs = new Shader(Const.tf2, GL_FRAGMENT_SHADER);
		gp.addShader(fs);
		gp.link();
		gp.use();
		
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
		
		int width = 0;
		int height = 0;
		ByteBuffer buf = null;
		// 加载纹理文件
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer w = stack.mallocInt(1);
			IntBuffer h = stack.mallocInt(1);
			IntBuffer channels = stack.mallocInt(1);
			STBImage.nstbi_set_flip_vertically_on_load(1);
			buf = STBImage.stbi_load("./sp/texture/01.png", w, h, channels, 4);
			if (buf == null) {
				throw new Exception("Image file not loaded: " + STBImage.stbi_failure_reason());
			}
			width = w.get();
			height = h.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		glActiveTexture(GL_TEXTURE0);
		int textureId = glGenTextures();
		glBindTexture(GL_TEXTURE_2D, textureId);
		glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height,0, GL_RGBA, GL_UNSIGNED_BYTE, buf);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		STBImage.stbi_image_free(buf);
		
		vao = new Vao();
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
	public static void main(String[] args) throws InterruptedException {
		Test t = new Test();
		t.init();
		t.run();
		t.free();
	}
}