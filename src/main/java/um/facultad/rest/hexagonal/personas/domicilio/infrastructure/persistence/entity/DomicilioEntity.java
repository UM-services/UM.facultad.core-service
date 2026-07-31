package um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.entity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import um.facultad.rest.model.pk.DomicilioPk;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Getter
@Setter
@Builder
@Entity
@Table(name = "domicilio")
@IdClass(DomicilioPk.class)
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioEntity implements Serializable {
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 8282957336867319733L;

	@Id
	@Column(name = "iddocumento")
	private BigDecimal personaId;

	@Id
	@Column(name = "idtipodoc")
	private Integer documentoId;

	@Column(name = "clave")
	private Long domicilioId;

	@Builder.Default
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXX", timezone = "UTC")
	private OffsetDateTime fecha = OffsetDateTime.now();

	@Builder.Default
	private String calle = "";

	@Builder.Default
	private String puerta = "";

	@Builder.Default
	private String piso = "";

	@Builder.Default
	private String dpto = "";

	@Builder.Default
	private String telefono = "";

	@Column(name = "dom_movil")
	@Builder.Default
	private String movil = "";

	@Builder.Default
	private String observaciones = "";

	@Column(name = "codpostal")
	@Builder.Default
	private String codigoPostal = "";

	@Column(name = "dom_fac_id")
	private Integer facultadId;

	@Column(name = "idprovincia")
	private Integer provinciaId;

	@Column(name = "idlocalidad")
	private Integer localidadId;

	@Column(name = "dom_e_mail")
	@Builder.Default
	private String emailPersonal = "";

	@Column(name = "mail_institucional")
	@Builder.Default
	private String emailInstitucional = "";

	@Column(name = "dom_laboral")
	@Builder.Default
	private String laboral = "";

}
