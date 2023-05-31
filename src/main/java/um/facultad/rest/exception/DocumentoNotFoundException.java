/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class DocumentoNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5387953489350065866L;

	public DocumentoNotFoundException(Integer documentoId) {
		super("Cannot find Documento " + documentoId);
	}

}
