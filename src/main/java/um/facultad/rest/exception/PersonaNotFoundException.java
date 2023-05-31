/**
 * 
 */
package um.facultad.rest.exception;

import java.math.BigDecimal;

/**
 * @author daniel
 *
 */
public class PersonaNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5733282570465285417L;

	public PersonaNotFoundException(BigDecimal personaId, Integer documentoId) {
		super("Cannot find Persona " + personaId + "/" + documentoId);
	}

}
