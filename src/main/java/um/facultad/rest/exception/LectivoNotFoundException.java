/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class LectivoNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2818968834827603823L;

	public LectivoNotFoundException(Integer lectivoId) {
		super("Cannot find Lectivo " + lectivoId);
	}

}
