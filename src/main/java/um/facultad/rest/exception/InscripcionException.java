/**
 * 
 */
package um.facultad.rest.exception;

import java.math.BigDecimal;

/**
 * @author daniel
 *
 */
public class InscripcionException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -226823162753012933L;

	public InscripcionException(Integer facultadId, BigDecimal personaId, Integer documentoId,
								Integer lectivoId) {
		super("Cannot find Inscripcion " + facultadId + "/" + personaId + "/" + documentoId + "/" + lectivoId);
	}

}
