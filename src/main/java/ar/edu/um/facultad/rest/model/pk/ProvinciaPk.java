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
public class ProvinciaPk implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -6248076008677822704L;

	private Integer facultadId;
	private Integer provinciaId;
}
