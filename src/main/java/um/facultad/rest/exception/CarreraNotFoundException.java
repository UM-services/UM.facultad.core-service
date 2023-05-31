/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class CarreraNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4678567191299089760L;

	public CarreraNotFoundException(Integer facultadId, Integer planId, Integer carreraId) {
		super("Cannot find Carrera " + facultadId + "/" + planId + "/" + carreraId);
	}

}
