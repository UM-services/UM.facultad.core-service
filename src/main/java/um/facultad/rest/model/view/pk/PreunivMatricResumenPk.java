/**
 * 
 */
package um.facultad.rest.model.view.pk;

import java.io.Serializable;

import lombok.Data;

/**
 * @author daniel
 *
 */
@Data
public class PreunivMatricResumenPk implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2218826353451172879L;

	private Integer facultadId;
	private Integer lectivoId;
	private Integer planId;
	private Integer carreraId;
	private Integer geograficaId;
	private Integer turnoId;

}
