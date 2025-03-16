/**
 * 
 */
package um.facultad.rest.exception;

import java.math.BigDecimal;

/**
 * @author daniel
 *
 */
public class PersonaException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5733282570465285417L;

	public PersonaException(BigDecimal personaId, Integer documentoId) {
		super("Cannot find Persona " + personaId + "/" + documentoId);
	}

}
