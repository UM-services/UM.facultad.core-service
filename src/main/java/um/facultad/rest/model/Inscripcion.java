/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import um.facultad.rest.model.pk.InscripcionPk;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author daniel
 *
 */
@Data
@Entity
@IdClass(InscripcionPk.class)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion extends Auditable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6043511094445984052L;

	@Id
	@Column(name = "idfacultad")
	private Integer facultadId;

	@Id
	@Column(name = "iddocumento")
	private BigDecimal personaId;

	@Id
	@Column(name = "idtipodoc")
	private Integer documentoId;

	@Id
	@Column(name = "idlectivo")
	private Integer lectivoId;

	@Column(name = "ins_id")
	private Long inscripcionId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	private OffsetDateTime fecha;

	private String chequera = "";
	private String matricula = "";
	private Long factura = 0L;
	private Integer curso = 0;

	@Column(name = "ins_pla_id")
	private Integer planId;

	@Column(name = "ins_car_id")
	private Integer carreraId;

	@Column(name = "ins_geo_id")
	private Integer geograficaId;

	@Column(name = "ins_asentado")
	private Byte asentado = 0;

	@Column(name = "ins_provisoria")
	private Byte provisoria = 0;

	@Column(name = "ins_cohorte")
	private Integer cohorte = 0;

	@Column(name = "ins_remota")
	private Byte remota = 0;

	@Column(name = "ins_imprimir")
	private Byte imprimir = 0;

	@Column(name = "ins_edad")
	private Integer edad = 0;

	@Column(name = "ins_observaciones")
	private String observaciones = "";

	@Column(name = "ins_offsetpago")
	private Integer offsetpago = 0;

	@Column(name = "ins_libre")
	private Integer libre = 0;

	@Column(name = "ins_div_id")
	private Integer divisionId;

	@Column(name = "ins_debe_matricula")
	private Byte debematricula = 0;

	public String getKey() {
		return this.personaId + "." + this.documentoId;
	}

}
