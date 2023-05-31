/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class EstadoAlumnoNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1851564641118633345L;

	public EstadoAlumnoNotFoundException(Integer estadoId) {
		super("Cannot find EstadoAlumno " + estadoId);
	}

}
