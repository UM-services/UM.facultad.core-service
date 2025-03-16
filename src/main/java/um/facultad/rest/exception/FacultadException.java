/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class FacultadException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 218296400915800794L;

	public FacultadException(Integer facultadId) {
		super("Cannot find Facultad " + facultadId);
	}

}
