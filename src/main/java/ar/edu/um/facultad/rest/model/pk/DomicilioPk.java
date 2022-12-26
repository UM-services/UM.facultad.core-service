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
public class DomicilioPk implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -3300450120759331896L;
	
	private BigDecimal personaId;
	private Integer documentoId;

}
