/**
 * 
 */
package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.persistence.entity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

import lombok.*;
import um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.persistence.entity.pk.InscripcionDetallePk;
import um.facultad.rest.hexagonal.carreras.materia.infrastructure.persistence.entity.MateriaEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author daniel
 *
 */
@Getter
@Setter
@Builder
@Entity
@Table(name = "detinscripcion")
@IdClass(InscripcionDetallePk.class)
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionDetalleEntity implements Serializable {
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = -1184060977690656799L;

	@Id
	@Column(name = "iddocumento")
	private BigDecimal personaId;

	@Id
	@Column(name = "idtipodoc")
	private Integer documentoId;

	@Id
	@Column(name = "idlectivo")
	private Integer lectivoId;
	
	@Id
	@Column(name = "idfacultad")
	private Integer facultadId;

	@Id
	@Column(name = "idplan")
	private Integer planId;

	@Id
	@Column(name = "idmateria")
	private String materiaId;

	@Column(name = "din_id")
	private Long inscripciondetalleId;

	@Column(name = "din_cur_id")
	@Builder.Default
	private Integer cursoId = 0;

	@Column(name = "din_per_id")
	@Builder.Default
	private Integer periodoId = 0;

	@Column(name = "din_div_id")
	private Integer divisionId;

	@Column(name = "din_recursa")
	@Builder.Default
	private Byte recursa = 0;

	@Column(name = "din_imprimir")
	@Builder.Default
	private Byte imprimir = 0;

	@Column(name = "din_moroso")
	@Builder.Default
	private Byte moroso = 0;

	@Column(name = "din_libre")
	@Builder.Default
	private Byte libre = 0;

	@Column(name = "din_condicional")
	@Builder.Default
	private Byte condicional = 0;

	@OneToOne(optional = true)
	@JoinColumns({
			@JoinColumn(name = "idfacultad", referencedColumnName = "idfacultad", insertable = false, updatable = false),
			@JoinColumn(name = "idplan", referencedColumnName = "idplan", insertable = false, updatable = false),
			@JoinColumn(name = "idmateria", referencedColumnName = "idmateria", insertable = false, updatable = false) })
	private MateriaEntity materia;

}
