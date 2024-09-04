package preprocessor;

import java.util.LinkedList;

public class Line {
	LinkedList<Block> list = new LinkedList<Block>();
	static byte Isblock(char c) {
		if(96 <c && 123 > c)return 1;
		if(64 <c && 91 > c)return 1;
		if(47 <c && 58 > c)return 1;
		if(127 < c)return 1;
		if('#' == c)return 1;
		if('.' == c)return 1;
		return 0;
	}
	public Line(char[] chars) {
		int blength = 0,offset = 0;
		byte tp;
		while(offset<chars.length) {
			tp = Isblock(chars[offset]);
			while(Isblock(chars[offset+blength]) == tp) {
				blength++;
				if(offset+blength >= chars.length)break;
			}
			list.add(new Block(chars, offset, blength,tp));
			offset += blength;
			blength = 0;
			tp = (byte) (tp==1?0:1);
		}
	}
}
class Block {
	final char[] list;
	final byte tp;
	public Block(char[] chars,byte tp) {
		this.tp = tp;
		list = chars;
	}
	public Block(char[] chars,int offset,int length,byte tp) {
		this.tp = tp;
		list = new char[length];
		System.arraycopy(chars, offset, list, 0, length);
	}
}
