/**
 * 
 */
package um.facultad.rest.exception;

import java.math.BigDecimal;

/**
 * @author daniel
 *
 */
public class TituloEntregaNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8472640073772439092L;

	public TituloEntregaNotFoundException(BigDecimal personaId, Integer documentoId, Integer facultadId, Integer planId,
			Integer carreraId) {
		super("Cannot find TituloEntrega " + personaId + "/" + documentoId + "/" + facultadId + "/" + planId + "/"
				+ carreraId);
	}

}
