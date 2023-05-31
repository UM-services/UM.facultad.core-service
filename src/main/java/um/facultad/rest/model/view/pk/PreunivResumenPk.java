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
public class PreunivResumenPk implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -8410975644985213553L;

	private Integer facultadId;
	private Integer lectivoId;
	private Integer planId;
	private Integer carreraId;
	private Integer geograficaId;
	private Integer turnoId;

}
