/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class ProvinciaNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7511278328575039308L;

	public ProvinciaNotFoundException(Integer facultadId, Integer provinciaId) {
		super("Cannot fin Provincia " + facultadId + "/" + provinciaId);
	}

}
