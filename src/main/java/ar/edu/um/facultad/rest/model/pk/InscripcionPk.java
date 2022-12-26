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
public class InscripcionPk implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 566227035122519869L;

	private Integer facultadId;
	private BigDecimal personaId;
	private Integer documentoId;
	private Integer lectivoId;

}
