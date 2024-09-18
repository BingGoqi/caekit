package simple;

import static org.lwjgl.opengl.GL11.*;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

public class Texture implements GLElement<Texture> {
	static final IntBuffer w,h,channels;
	static {
		STBImage.nstbi_set_flip_vertically_on_load(1);
		try(MemoryStack stack = MemoryStack.stackPush();){
			w = stack.mallocInt(1);
			h = stack.mallocInt(1);
			channels = stack.mallocInt(1);
		}
	}
	public final int texture;
	private Texture next;
	private ByteBuffer buf;
	private final String file;
	public final int width,height;
	public Texture(String file) {
		this.file = file;
		buf = STBImage.stbi_load(file, w, h, channels, 4);
		width = w.get();
		height = h.get();
		texture = glGenTextures();
		glBindTexture(GL_TEXTURE_2D, texture);
		glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height,0, GL_RGBA, GL_UNSIGNED_BYTE, buf);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	}
	
	@Override
	public Texture next() {
		return next;
	}
	@Override
	public Texture getnext() {
		return next;
	}
	@Override
	public void setnext(Texture next) {
		this.next = next;
	}
	@Override
	public int getPrt() {
		return texture;
	}
	@Override
	public void free() {
		STBImage.stbi_image_free(buf);
	}
	@Override
	public void use() {
		
	}
	@Override
	public void link() {
	}
	@Override
	public String toString() {
		return file;
	}
}