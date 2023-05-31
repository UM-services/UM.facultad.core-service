/**
 * 
 */
package um.facultad.rest.model.view;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daniel
 *
 */
@Data
@Entity
@Table(name = "vw_preuniv_carrera")
@Immutable
@NoArgsConstructor
@AllArgsConstructor
public class PreunivCarrera implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 7185104151191006512L;

	@Id
	protected Long preinscripcionId;

	protected Integer facultadId;
	protected Integer lectivoId;
	protected Integer geograficaId;
	protected Integer turnoId;
	protected BigDecimal personaId;
	protected Integer documentoId;
	private Integer planId;
	private Integer carreraId;

}
