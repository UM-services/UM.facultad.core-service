/**
 * 
 */
package um.facultad.rest.exception;

/**
 * @author daniel
 *
 */
public class DocumentoException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5387953489350065866L;

	public DocumentoException(Integer documentoId) {
		super("Cannot find Documento " + documentoId);
	}

}
