/**
 * 
 */
package ar.edu.um.facultad.rest.model.extern;

import java.io.Serializable;

import lombok.Data;

/**
 * @author daniel
 *
 */
@Data
public class NotificacionExamen implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 775156706723950428L;

	private Long notificacionexamenId;
	private Integer facultadId;
	private Integer geograficaId;
	private String email;
}
