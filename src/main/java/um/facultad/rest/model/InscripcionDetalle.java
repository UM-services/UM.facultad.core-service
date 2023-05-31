/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serializable;
import java.math.BigDecimal;

import um.facultad.rest.model.pk.InscripcionDetallePk;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "detinscripcion")
@IdClass(InscripcionDetallePk.class)
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionDetalle implements Serializable {
	/**
	 * 
	 */
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inscripciondetalleId;

	@Column(name = "din_cur_id")
	private Integer cursoId = 0;

	@Column(name = "din_per_id")
	private Integer periodoId = 0;

	@Column(name = "din_div_id")
	private Integer divisionId;

	@Column(name = "din_recursa")
	private Byte recursa = 0;

	@Column(name = "din_imprimir")
	private Byte imprimir = 0;

	@Column(name = "din_moroso")
	private Byte moroso = 0;

	@Column(name = "din_libre")
	private Byte libre = 0;

	@Column(name = "din_condicional")
	private Byte condicional = 0;

}
