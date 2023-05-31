/**
 * 
 */
package um.facultad.rest.model.view;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
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
@Table(name = "vw_legajo_key")
@Immutable
@NoArgsConstructor
@AllArgsConstructor
public class LegajoKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5372451868167090595L;

	@Id
	@Column(name = "id")
	private Long legajoId;

	@Column(name = "iddocumento")
	private BigDecimal personaId;

	@Column(name = "idtipodoc")
	private Integer documentoId;

	@Column(name = "idfacultad")
	private Integer facultadId;

	@Column(name = "ale_geo_id")
	private Integer geograficaId;

	@Column(name = "idlegajo")
	private Long numerolegajo = 0L;

	@Column(name = "ale_lec_id")
	private Integer lectivoId;

	@Column(name = "ale_fecha")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	private OffsetDateTime fecha;

	@Column(name = "ale_pla_id")
	private Integer planId;

	@Column(name = "ale_car_id")
	private Integer carreraId;

	@Column(name = "ale_clave")
	private String contrasenha;

	@Column(name = "ale_intercambio")
	private Byte intercambio;

	@Column(name = "persona_key")
	private String personakey;

}
