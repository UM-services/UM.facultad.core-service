/**
 * 
 */
package um.facultad.rest.model.pk;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @author daniel
 *
 */
@Data
public class TituloEntregaPk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -370696008064442408L;

	private BigDecimal personaId;
	private Integer documentoId;
	private Integer facultadId;
	private Integer planId;
	private Integer carreraId;

}
