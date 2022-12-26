/**
 * 
 */
package ar.edu.um.facultad.rest.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import ar.edu.um.facultad.rest.model.pk.LegajoPk;
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
@Table(name = "aluleg")
@IdClass(LegajoPk.class)
@NoArgsConstructor
@AllArgsConstructor
public class Legajo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8634291623291096828L;

	@Id
	@Column(name = "iddocumento")
	private BigDecimal personaId;

	@Id
	@Column(name = "idtipodoc")
	private Integer documentoId;

	@Id
	@Column(name = "idfacultad")
	private Integer facultadId;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long legajoId;

	@Column(name = "ale_geo_id")
	private Integer geograficaId;

	@Column(name = "idlegajo")
	private Long numeroLegajo = 0L;

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
	private Byte intercambio = 0;

}
