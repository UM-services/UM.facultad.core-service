/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class SetupApiException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8053872799924912139L;

	public SetupApiException() {
		super("Cannot find SetupApi");
	}
}
