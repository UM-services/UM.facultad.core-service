/**
 * 
 */
package um.facultad.rest.exception;

import java.io.Serial;
import java.math.BigDecimal;

/**
 * @author daniel
 *
 */
public class LegajoException extends RuntimeException {
	/**
	 * 
	 */
	@Serial
	private static final long serialVersionUID = 7092719480019792731L;

	public LegajoException(BigDecimal personaId, Integer documentoId, Integer facultadId) {
		super("Cannot find Legajo " + personaId + "/" + documentoId + "/" + facultadId);
	}

}
