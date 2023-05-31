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
public class InscripcionDetallePk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3614250790545345440L;

	private BigDecimal personaId;
	private Integer documentoId;
	private Integer lectivoId;
	private Integer facultadId;
	private Integer planId;
	private String materiaId;

}
