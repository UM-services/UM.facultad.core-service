/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import um.facultad.rest.model.pk.NacimientoPk;
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
@IdClass(NacimientoPk.class)
@NoArgsConstructor
@AllArgsConstructor
public class Nacimiento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 221113968216530671L;

	@Id
	@Column(name = "iddocumento")
	private BigDecimal personaId;

	@Id
	@Column(name = "idtipodoc")
	private Integer documentoId;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nci_id")
	private Long nacimientoId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	private OffsetDateTime fecha;
	
	private String lugar;

	@Column(name = "nci_fac_id")
	private Integer facultadId = 0;

	@Column(name = "idprovincia")
	private Integer provinciaId = 0;

	@Column(name = "idlocalidad")
	private Integer localidadId = 0;

	@Column(name = "idnacionalidad")
	private Integer nacionalidadId = 0;

}
