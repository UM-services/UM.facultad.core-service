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
public class BajaPk implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1045783348817082703L;

	private Integer facultadId;
	private BigDecimal personaId;
	private Integer documentoId;
	private Integer lectivoId;

}
