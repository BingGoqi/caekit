package simple;

import static org.lwjgl.opengl.GL30.*;

public class Vao implements GLElement<Vao>{
	static final Vao Defalut = new Vao(0);
	private final int vao;
	private VData vfirst,vend;
	private int size;
	private Vao next;
	private boolean set = false;
	public Vao() {
		vao = glGenVertexArrays();
	}
	public Vao(int i) {
		vao = 0;
	}
	public void set() {
		if(set) return;
		glBindVertexArray(vao);
		VData vd = vfirst;
		int offset = 0;
		int located = 0;
		while(vd != null) {
			glVertexAttribPointer(located, vd.num, vd.gettype(), false, size, offset);
			glEnableVertexAttribArray(located);
			located ++;
			offset += vd.getsize();
			vd = vd.getnext();
		}
		set = true;
	}
	public Vao add(VData vd) {
		if(set)return null;
		size += vd.getsize();
		if(vfirst == null) {
			vfirst = vd;
			return this;
		}else if(vend == null) {
			vfirst.setnext(vd);
			vend = vd;
			return this;
		}
		vend.setnext(vd);
		vend = vd;
		return this;
	}
	@Override
	public void free() {
		glDeleteVertexArrays(vao);
	}
	@Override
	public void link() {
		glBindVertexArray(vao);
	}
	@Override
	public void use() {
		glBindVertexArray(vao);
	}
	@Override
	public Vao next() {
		return next;
	}
	@Override
	public Vao getnext() {
		return next;
	}
	@Override
	public void setnext(Vao next) {
		this.next = next;
	}
	@Override
	public int getPrt() {
		return vao;
	}
}
class VData implements SpLink<VData>{
	private final static byte[] GL_Data_Len = {1,1,2,2,4,4,4,2,3,4,8};
	private final static int offset = 0x1400;
	final byte type,num;
	private VData next;
	public VData(int type,int i) {
		this.num = (byte) i;
		this.type = (byte) (type-offset);
	}
	public int getsize() {
		return GL_Data_Len[type]*num;
	}
	public int gettype() {
		return offset+type;
	}
	@Override
	public VData next() {
		return getnext();
	}
	@Override
	public VData getnext() {
		return next;
	}
	@Override
	public void setnext(VData next) {
		this.next = next;
	}
}