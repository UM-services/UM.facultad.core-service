/**
 * 
 */
package ar.edu.um.facultad.rest.exception;

import java.math.BigDecimal;

/**
 * @author daniel
 *
 */
public class NacimientoNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1679035669047738954L;

	public NacimientoNotFoundException(BigDecimal personaId, Integer documentoId) {
		super("Cannot find Nacimiento " + personaId + "/" + documentoId);
	}

}
