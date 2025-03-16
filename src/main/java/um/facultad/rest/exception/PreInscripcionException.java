/**
 * 
 */
package um.facultad.rest.exception;

import java.math.BigDecimal;

/**
 * @author daniel
 *
 */
public class PreInscripcionException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6968180491178844466L;

	public PreInscripcionException(Integer facultadId, BigDecimal personaId, Integer documentoId,
								   Integer lectivoId) {
		super("Cannot find PreInscripcion " + facultadId + "/" + personaId + "/" + documentoId + "/" + lectivoId);
	}

}
