/**
 * 
 */
package um.facultad.rest.model.pk;

import java.io.Serializable;

import lombok.Data;

/**
 * @author daniel
 *
 */
@Data
public class DivisionPk implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -3960277278280702122L;

	private Integer facultadId;
	private Integer divisionId;
}
