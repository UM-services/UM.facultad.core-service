/**
 * 
 */
package ar.edu.um.facultad.rest.model.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @author daniel
 *
 */
@Data
public class DivisionDto implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 7570468671518048065L;

	private Integer facultadId;
	private Integer lectivoId;
	private Integer planId;
	private String materiaId;
	private Integer cursoId;
	private Integer periodoId;
	private Integer divisionId;
	private Integer geograficaId;
	private String email;

}
