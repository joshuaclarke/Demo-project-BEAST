package core.exceptions;

/** 
 * @author Josh CLARKE
 */
public class NullImageOnCanvasException extends Exception {
	private static final long serialVersionUID = 4985394613445613011L;

	public NullImageOnCanvasException() {
		super("A null image was passed to the ImageCanvas.");
	}

}
