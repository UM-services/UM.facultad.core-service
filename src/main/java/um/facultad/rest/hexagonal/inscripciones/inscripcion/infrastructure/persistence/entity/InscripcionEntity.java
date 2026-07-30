/**
 * 
 */
package um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.entity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;
import um.facultad.rest.model.Auditable;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.persistence.entity.pk.InscripcionPk;

/**
 * @author daniel
 *
 */
@Getter
@Setter
@Builder
@Entity
@Table(name = "inscripcion")
@IdClass(InscripcionPk.class)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionEntity extends Auditable implements Serializable {
	/**
	 * 
	 */
	@Serial
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXX", timezone = "UTC")
	private OffsetDateTime fecha;

	@Builder.Default
	private String chequera = "";
	@Builder.Default
	private String matricula = "";
	@Builder.Default
	private Long factura = 0L;
	@Builder.Default
	private Integer curso = 0;

	@Column(name = "ins_pla_id")
	private Integer planId;

	@Column(name = "ins_car_id")
	private Integer carreraId;

	@Column(name = "ins_geo_id")
	private Integer geograficaId;

	@Column(name = "ins_asentado")
	@Builder.Default
	private Byte asentado = 0;

	@Column(name = "ins_provisoria")
	@Builder.Default
	private Byte provisoria = 0;

	@Column(name = "ins_cohorte")
	@Builder.Default
	private Integer cohorte = 0;

	@Column(name = "ins_remota")
	@Builder.Default
	private Byte remota = 0;

	@Column(name = "ins_imprimir")
	@Builder.Default
	private Byte imprimir = 0;

	@Column(name = "ins_edad")
	@Builder.Default
	private Integer edad = 0;

	@Column(name = "ins_observaciones")
	@Builder.Default
	private String observaciones = "";

	@Column(name = "ins_offsetpago")
	@Builder.Default
	private Integer offsetpago = 0;

	@Column(name = "ins_libre")
	@Builder.Default
	private Integer libre = 0;

	@Column(name = "ins_div_id")
	private Integer divisionId;

	@Column(name = "ins_debe_matricula")
	@Builder.Default
	private Byte debematricula = 0;

	public String getKey() {
		return this.personaId + "." + this.documentoId;
	}

}
