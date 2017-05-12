package core.exceptions;

/** 
 * @author Josh CLARKE
 */
public class ImageIOError extends Exception {
	private static final long serialVersionUID = -872162313159889682L;

	public ImageIOError(String path) {
		super("Couldn't load image at [ " + path + " ].");
	}

}
