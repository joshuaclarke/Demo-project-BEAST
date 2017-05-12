package core.exceptions;

/** 
 * @author Rémi GIDON
 */
public class PythonIOError extends Exception {
	private static final long serialVersionUID = 4114535636955684972L;

	public PythonIOError(String s) {
		super("Python error :" + s);
	}

}
