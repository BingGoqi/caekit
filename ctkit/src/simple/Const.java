package simple;

public interface Const {//TempUse
	String tv1 = """
			#version 330
			layout (location=0) in vec3 position;
			layout (location=1) in vec3 col;
			out vec3 ourcol;
			void main(){gl_Position = vec4(position, 1);
			ourcol = col;
			}
			""";
	String tf1 = """
			#version 330
			in vec3 ourcol;
			out vec4 fragColor;
			void main(){fragColor = vec4(ourcol, 1);}
			""";
	String tv2 = """
			#version 330
			layout (location=0) in vec3 position;
			layout (location=1) in vec3 col;
			layout (location=2) in vec2 tp;
			out vec3 ourcol;
			out vec2 ourtp;
			void main(){gl_Position = vec4(position, 1);
			ourtp = tp;
			ourcol = col;
			}
			""";
	String tf2 = """
			#version 330
			in vec2 ourtp;
			in vec3 ourcol;
			uniform sampler2D text;
			out vec4 fragColor;
			void main(){fragColor = texture(text,ourtp)*.5;
			fragColor += ourcol*.5;
			fragColor.w = 1;
			}
			""";
	String img = "./sp/texture/01.png";
}
