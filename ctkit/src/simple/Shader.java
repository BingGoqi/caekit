/**  
 * @Title: Shander.java
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-06 10:58:48 
 */ 

package simple;

import static org.lwjgl.opengl.GL20.*;

/**  
 * @ClassName: Shader
 * @Description: TODO
 * @author BingGoqi
 * @date 2024-06-06 10:58:48 
*/

public class Shader {
	private final int shader;
	private final int type;
	public Shader(String code,int type) {
		shader = glCreateShader(type);
		this.type = type;
		glShaderSource(shader, code);
		glCompileShader(shader);
	}
	public int getType() {
		return type;
	}
	public void delete() {
		glDeleteShader(shader);
	}
	public int shader() {
		return shader;
	}
}
