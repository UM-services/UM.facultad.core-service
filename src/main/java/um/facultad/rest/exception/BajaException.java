/**
 * 
 */
package um.facultad.rest.exception;

import java.math.BigDecimal;

/**
 * @author daniel
 *
 */
public class BajaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3642308534577872450L;

	public BajaException(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
		super("Cannot find Baja " + facultadId + "/" + personaId + "/" + documentoId + "/" + lectivoId);
	}

}
