/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class CarreraException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4678567191299089760L;

	public CarreraException(Integer facultadId, Integer planId, Integer carreraId) {
		super("Cannot find Carrera " + facultadId + "/" + planId + "/" + carreraId);
	}

}
