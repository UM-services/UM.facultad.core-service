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
public class NacimientoPk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6498429443048231485L;

	private BigDecimal personaId;
	private Integer documentoId;
}
