/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class LectivoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2818968834827603823L;

	public LectivoException(Integer lectivoId) {
		super("Cannot find Lectivo " + lectivoId);
	}

}
