/**  
 * @Title: Window.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-06 09:24:58 
 */ 

package simple;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

/**  
 * @ClassName: Window
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-06 09:24:58 
*/

public class Window {
	private static final long NULL = MemoryUtil.NULL;
	private final long HWND;
	private String title;
	private GLFWKeyCallback kc;
	private GLFWCursorPosCallback pcall;
	private GLFWErrorCallback erroCallBack;
	private int width,heigth;
	public int px,py;
	public byte[] keymap = new byte[350];
	/**  
	 * @Constructor: Window
	 * @Description: Window构造函数
	 * @author BingGoqi
	 * @date 2024-06-06 09:35:32 
	 */

	public Window(int w,int h,String t) {
		erroCallBack = GLFWErrorCallback.createPrint(System.err);;
		glfwSetErrorCallback(erroCallBack);
		if(!glfwInit()) {
			throw new IllegalStateException("Unable to initialize GLFW");
		}
		title = t;
		width = w;
		heigth = h;
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
		HWND=glfwCreateWindow(width,heigth,title,NULL,NULL);
		if(HWND == NULL) {
			glfwTerminate();
			throw new RuntimeException("Failed to create the GLFW window");
		}
		kc = new GLFWKeyCallback() {@Override
			public void invoke(long window, int key, int scancode, int action, int mods) {
				if(action == GLFW_PRESS) {
					if(key == GLFW_KEY_ESCAPE) {
						glfwSetWindowShouldClose(window, true);
					}else {
						keymap[key] = 1;
					}
				}else if(action == GLFW_RELEASE) {
					keymap[key] = 0;
				}
			}
		};
		glfwSetKeyCallback(HWND, kc);
		
		glfwSetInputMode(HWND, GLFW_CURSOR, GLFW_CURSOR_DISABLED);
		pcall = new GLFWCursorPosCallback() {
			@Override
			public void invoke(long window, double xpos, double ypos) {
				px = (int) (xpos - w/2);
				py = (int) (h/2-ypos);
			}
		};
		glfwSetCursorPosCallback(HWND, pcall);
		
		glfwMakeContextCurrent(HWND);
		glfwSwapInterval(1);
		GL.createCapabilities(true);
	}
	public void show() {
		glfwShowWindow(HWND);
	}
	public void close() {
		glfwSetWindowShouldClose(HWND, true);
	}
	public boolean IsClose() {
		return glfwWindowShouldClose(HWND);
	}
	public void flush() {
		glfwSwapBuffers(HWND);
		glfwPollEvents();
	}
	public void free() {
		glfwFreeCallbacks(HWND);
		//glfwDestroyCursor(HWND);
		//glfwTerminate();
		var cp = glfwSetErrorCallback(null);
		if(cp != null) cp.free();
	}
}
