package exercise4;

public class LineException extends Exception {
	private static final long serialVersionUID = 1L;
	public LineException() { super(); }
	  public LineException(String message) { super(message); }
	  public LineException(String message, Throwable cause) { super(message, cause); }
	  public LineException(Throwable cause) { super(cause); }
}
