/**
 * 
 */
package ar.edu.um.facultad.rest.model.view;

import java.io.Serializable;

import org.hibernate.annotations.Immutable;

import ar.edu.um.facultad.rest.model.view.pk.PreunivMatricResumenPk;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author daniel
 *
 */
@Data
@Entity
@Immutable
@Table(name = "vw_preuniv_matric_resumen")
@IdClass(value = PreunivMatricResumenPk.class)
public class PreunivMatricResumen implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4144601736942735290L;

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
