package kafka.util;

public class FileWriterNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3055870700690277320L;
	String exceptionMesg;

	public FileWriterNotFoundException(String exceptionMesg) {
		super();
		this.exceptionMesg = exceptionMesg;
	}
	
}
