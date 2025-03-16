/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class EstadoAlumnoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1851564641118633345L;

	public EstadoAlumnoException(Integer estadoId) {
		super("Cannot find EstadoAlumno " + estadoId);
	}

}
