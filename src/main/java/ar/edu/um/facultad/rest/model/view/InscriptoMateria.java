/**
 * 
 */
package ar.edu.um.facultad.rest.model.view;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author daniel
 *
 */
@Data
@Entity
@Immutable
@Table(name = "vw_inscriptos_materia")
public class InscriptoMateria implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5094058648414298907L;

	@Id
	@Column(name = "detalle_inscripcion_id")
	private Long detalleinscripcionId;
	
	@Column(name = "numero_legajo")
	private Long numerolegajo;

	private BigDecimal personaId;
	private Integer documentoId;
	private String apellido;
	private String nombre;
	private Integer curso;
	private Byte recursa;
	private Byte condicional;
	private Integer lectivoId;
	private Integer facultadId;
	private Integer planId;
	private Integer carreraId;

	@Column(name = "carrera_nombre")
	private String carreranombre;

	private String materiaId;
	private Integer cursoId;
	private Integer periodoId;
	private Integer divisionId;
	private Integer geograficaId;

}
