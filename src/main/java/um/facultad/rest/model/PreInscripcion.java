/**
 * 
 */
package um.facultad.rest.model;

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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "pin_fac_id", "pin_per_id", "pin_doc_id" }) })
@NoArgsConstructor
@AllArgsConstructor
public class PreInscripcion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 727793467814055212L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clave")
	private Long preinscripcionId;

	@Column(name = "pin_fac_id")
	private Integer facultadId;

	@Column(name = "pin_per_id")
	private BigDecimal personaId;

	@Column(name = "pin_doc_id")
	private Integer documentoId;

	@Column(name = "pin_lec_id")
	private Integer lectivoId;

	@Column(name = "pin_ptu_id")
	private Integer turnoId;

	@Column(name = "pin_fecha")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	private OffsetDateTime fecha;

	@Column(name = "pin_chequera")
	private String chequera;

	@Column(name = "pin_geo_id")
	private Integer geograficaId;
	
	@Column(name = "pre_ins_observaciones")
	private String observaciones;

	@Column(name = "pin_barras")
	private String barras;

	public String getPersonaKey() {
		return this.personaId + "." + this.documentoId;
	}

}
