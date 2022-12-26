/**
 * 
 */
package ar.edu.um.facultad.rest.exception;

import java.math.BigDecimal;

/**
 * @author daniel
 *
 */
public class BajaNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3642308534577872450L;

	public BajaNotFoundException(Integer facultadId, BigDecimal personaId, Integer documentoId, Integer lectivoId) {
		super("Cannot find Baja " + facultadId + "/" + personaId + "/" + documentoId + "/" + lectivoId);
	}

}
