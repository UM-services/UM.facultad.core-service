/**
 * 
 */
package ar.edu.um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class SetupApiNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8053872799924912139L;

	public SetupApiNotFoundException() {
		super("Cannot find SetupApi");
	}
}
