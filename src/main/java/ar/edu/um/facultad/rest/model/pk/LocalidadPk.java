/**
 * 
 */
package ar.edu.um.facultad.rest.model.pk;

import java.io.Serializable;

import lombok.Data;

/**
 * @author daniel
 *
 */
@Data
public class LocalidadPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1734925701211291019L;

	private Integer facultadId;
	private Integer provinciaId;
	private Integer localidadId;
}
