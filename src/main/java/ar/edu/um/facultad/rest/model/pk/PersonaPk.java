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
public class PersonaPk implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 380328513519092208L;

	private BigDecimal personaId;
	private Integer documentoId;
}
