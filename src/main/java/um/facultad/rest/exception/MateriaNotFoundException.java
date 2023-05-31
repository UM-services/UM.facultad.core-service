/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class MateriaNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 837556299233053937L;

	public MateriaNotFoundException(Integer facultadId, Integer planId, String materiaId) {
		super("Cannot find Materia " + facultadId + "/" + planId + "/" + materiaId);
	}

}
