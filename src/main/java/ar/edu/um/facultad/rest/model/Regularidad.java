/**
 * 
 */
package ar.edu.um.facultad.rest.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daniel
 *
 */
@Data
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "iddocumento", "idtipodoc", "idlectivo", "idfacultad",
		"idplan", "idmateria" }) })
@NoArgsConstructor
@AllArgsConstructor
public class Regularidad implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4729141453534631174L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reg_id")
	private Long regularidadId;

	@Column(name = "iddocumento")
	private BigDecimal personaId;

	@Column(name = "idtipodoc")
	private Integer documentoId;

	@Column(name = "idlectivo")
	private Integer lectivoId;

	@Column(name = "idfacultad")
	private Integer facultadId;

	@Column(name = "idplan")
	private Integer planId;

	@Column(name = "idmateria")
	private String materiaId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	private OffsetDateTime fecha;

	@Column(name = "reg_externa")
	private Byte externa = 0;

	@Column(name = "reg_observ")
	private String observaciones;

	@Column(name = "reg_impresa")
	private Byte impresa = 0;

	@Column(name = "reg_vencimiento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	private OffsetDateTime vencimiento;

}
