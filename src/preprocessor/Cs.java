package preprocessor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Cs {
	
	public static void main(String[] args) {
		Path p = Paths.get("test_in.java");
		Path pout = Paths.get("test_out.java");
		byte[] bl = {'\n'};
		
		try {
			Files.delete(pout);
			Files.createFile(pout);
			var s = new String(Files.readAllBytes(p),StandardCharsets.UTF_8);
			var l = new Line(s.toCharArray());
			l.list.forEach(a -> {
				try {
					if(a.tp == 0) {
						Files.write(pout, bl,StandardOpenOption.APPEND);
						//System.out.print('~');
					}else {
						Files.write(pout, new String(a.list).getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);
					}	
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			System.out.println(l.list.size());
		} catch (IOException e) {
		}
	}
}