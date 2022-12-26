/**
 * 
 */
package ar.edu.um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class GeograficaNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7356497454616091714L;

	public GeograficaNotFoundException(Integer geograficaId) {
		super("Cannot find Geografica " + geograficaId);
	}

}
