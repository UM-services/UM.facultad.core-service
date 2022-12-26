/**
 * 
 */
package ar.edu.um.facultad.rest.model.pk;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

/**
 * @author daniel
 *
 */
@Data
public class LegajoPk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5431942159887578666L;

	private BigDecimal personaId;
	private Integer documentoId;
	private Integer facultadId;
}
