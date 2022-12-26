/**
 * 
 */
package ar.edu.um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class FacultadNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 218296400915800794L;

	public FacultadNotFoundException(Integer facultadId) {
		super("Cannot find Facultad " + facultadId);
	}

}
