/**
 * 
 */
package um.facultad.rest.model.view;

import java.io.Serializable;

import org.hibernate.annotations.Immutable;

import um.facultad.rest.model.view.pk.PreunivResumenPk;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@Immutable
@Table(name = "vw_preuniv_resumen")
@IdClass(value = PreunivResumenPk.class)
@NoArgsConstructor
@AllArgsConstructor
public class PreunivResumen implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -1581197638228750217L;

	@Id
	private Integer facultadId;

	@Id
	private Integer lectivoId;

	@Id
	private Integer planId;

	@Id
	private Integer carreraId;

	@Id
	private Integer geograficaId;

	@Id
	private Integer turnoId;

	private Integer cantidad;

}
