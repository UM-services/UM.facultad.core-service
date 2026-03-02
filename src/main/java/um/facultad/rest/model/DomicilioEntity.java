package um.facultad.rest.model;

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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	private OffsetDateTime fecha = OffsetDateTime.now();

	private String calle = "";
	private String puerta = "";
	private String piso = "";
	private String dpto = "";
	private String telefono = "";

	@Column(name = "dom_movil")
	private String movil = "";

	private String observaciones = "";

	@Column(name = "codpostal")
	private String codigoPostal = "";

	@Column(name = "dom_fac_id")
	private Integer facultadId;

	@Column(name = "idprovincia")
	private Integer provinciaId;

	@Column(name = "idlocalidad")
	private Integer localidadId;

	@Column(name = "dom_e_mail")
	private String emailPersonal = "";

	@Column(name = "mail_institucional")
	private String emailInstitucional = "";

	@Column(name = "dom_laboral")
	private String laboral = "";

}
