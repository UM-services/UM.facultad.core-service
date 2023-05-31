/**
 * 
 */
package um.facultad.rest.exception;

import java.math.BigDecimal;

/**
 * @author daniel
 *
 */
public class PreInscripcionNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6968180491178844466L;

	public PreInscripcionNotFoundException(Integer facultadId, BigDecimal personaId, Integer documentoId,
			Integer lectivoId) {
		super("Cannot find PreInscripcion " + facultadId + "/" + personaId + "/" + documentoId + "/" + lectivoId);
	}

}
