package simple;

public class GLContext {
	private Window window;
	private GLElement pool;
	Vao bindvao;
	//存在默认绑定的，使用对应类管理创建和释放(VAO)
	//使用intPtr提高兼容性,之后替换成class
	//通过GLElement链表存储其他结构,方便free
	//存储当前状态,可读取和修改
	public GLContext(Window w) {
		window = w;
	}
}
