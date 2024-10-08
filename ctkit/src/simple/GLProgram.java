package simple;

import static org.lwjgl.opengl.GL20.*;

public class GLProgram implements GLElement<GLProgram>{
	private Shader vs,fs,tcs,tes,gs;
	private GLProgram next;
	private final int program;
	public GLProgram() {
		program = glCreateProgram();
		if (program == 0) throw new RuntimeException("Could not create Shader");
	}
	public void link() {
		glLinkProgram(program);
	}
	public void use() {
		glUseProgram(program);
	}
	public void free() {
		glDeleteProgram(program);
	}
	public Uniform getUniform(String name) throws Exception {
		int ptr = glGetUniformLocation(program, name);
		if(ptr < 0) throw new Exception("Could not find uniform"+name);
		return new Uniform(ptr, name);
	}
	public void addShader(Shader s) {
		glAttachShader(program,s.shader());
		switch(s.getType()) {
		case 0x8b31 -> vs = s;
		case 0x8b30 -> fs = s;
		case 0x8d99 -> gs = s;
		case 0x8e88 -> tcs = s;
		case 0x8e87 -> tes = s;
		default ->
		throw new IllegalArgumentException("UnUpdate Shader Type: " + s.getType());
		}
	}
	public Shader getShader(int type) {
		return switch(type) {
		case 0x8b31 -> vs;
		case 0x8b30 -> fs;
		case 0x8d99 -> gs;
		case 0x8e88 -> tcs;
		case 0x8e87 -> tes;
		default -> null;
		};
	}
	@Override
	public GLProgram next() {
		return next;
	}
	@Override
	public GLProgram getnext() {
		return next;
	}
	@Override
	public void setnext(GLProgram next) {
		this.next = next;
	}
	@Override
	public int getPrt() {
		return program;
	}
	class Uniform {
		public final int ptr;
		public final String name;
		public Uniform(String name,GLProgram gp) throws Exception {
			this.name = name;
			ptr = glGetUniformLocation(gp.getPrt(), name);
			if(ptr < 0) throw new Exception("Could not find uniform"+name);
		}
		public Uniform(int ptr,String name) {
			this.name = name;
			this.ptr = ptr;
		}
	}
}
