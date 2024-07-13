package animtion;

public class AnimtionException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	String message;
	public AnimtionException(String message) {
		super(message); 
	}
}
