/**
 * 
 */
package ar.edu.um.facultad.rest.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import ar.edu.um.facultad.rest.model.pk.BajaPk;
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
@Table
@IdClass(BajaPk.class)
@NoArgsConstructor
@AllArgsConstructor
public class Baja implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8260580906592802175L;

	@Id
	@Column(name = "baj_idfacultad")
	private Integer facultadId;

	@Id
	@Column(name = "baj_iddocumento")
	private BigDecimal personaId;

	@Id
	@Column(name = "baj_idtipodoc")
	private Integer documentoId;

	@Id
	@Column(name = "baj_idlectivo")
	private Integer lectivoId;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "baj_id")
	private Long bajaId;
	
	@Column(name = "baj_definitiva")
	private Byte definitiva = 0;

	@Column(name = "baj_cer_ana_parcial")
	private Byte certificadoanaliticoparcial = 0;

	@Column(name = "baj_libre_deuda")
	private Byte libredeuda = 0;

	@Column(name = "baj_previa")
	private Byte previa = 0;

	@Column(name = "baj_temporaria")
	private Byte temporaria = 0;

	@Column(name = "baj_motivo")
	private String motivo = "";

	@Column(name = "baj_fecha")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	private OffsetDateTime fecha;
	
}
