/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class ProvinciaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7511278328575039308L;

	public ProvinciaException(Integer facultadId, Integer provinciaId) {
		super("Cannot fin Provincia " + facultadId + "/" + provinciaId);
	}

}
