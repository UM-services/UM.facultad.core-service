/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class LocalidadNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3085308043130103583L;

	public LocalidadNotFoundException(Integer facultadId, Integer provinciaId, Integer localidadId) {
		super("Cannot find Localidad " + facultadId + "/" + provinciaId + "/" + localidadId);
	}

}
