/**
 * 
 */
package um.facultad.rest.exception;

import java.math.BigDecimal;

/**
 * @author daniel
 *
 */
public class LegajoNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7092719480019792731L;

	public LegajoNotFoundException(BigDecimal personaId, Integer documentoId, Integer facultadId) {
		super("Cannot find Legajo " + personaId + "/" + documentoId + "/" + facultadId);
	}

}
