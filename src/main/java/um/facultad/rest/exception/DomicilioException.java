/**
 * 
 */
package um.facultad.rest.exception;

import java.math.BigDecimal;

/**
 * @author daniel
 *
 */
public class DomicilioException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 462198878153217521L;

	public DomicilioException(BigDecimal personaId, Integer documentoId) {
		super("Cannot find Domicilio " + personaId + "/" + documentoId);
	}

}
