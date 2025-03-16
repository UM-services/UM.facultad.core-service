/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class GeograficaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7356497454616091714L;

	public GeograficaException(Integer geograficaId) {
		super("Cannot find Geografica " + geograficaId);
	}

}
