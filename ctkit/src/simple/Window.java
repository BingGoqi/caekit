/**  
 * @Title: Window.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-06 09:24:58 
 */ 

package simple;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWErrorCallback;

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
	private GLFWErrorCallback erroCallBack;
	private int width,heigth;
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
				if(key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
					glfwSetWindowShouldClose(window, true);
				}
			}
		};
		glfwSetKeyCallback(HWND, kc);
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
		kc.free();
		kc = null;
		glfwFreeCallbacks(HWND);
		glfwDestroyCursor(HWND);
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}
}
