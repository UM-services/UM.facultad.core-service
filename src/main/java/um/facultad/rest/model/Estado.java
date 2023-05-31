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
@Table(uniqueConstraints = {
		@UniqueConstraint(columnNames = { "idfacultad", "iddocumento", "idtipodoc" }) })
@NoArgsConstructor
@AllArgsConstructor
public class Estado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1090989407047484529L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "est_id")
	private Long uniqueId;

	@Column(name = "idfacultad")
	private Integer facultadId;

	@Column(name = "iddocumento")
	private BigDecimal personaId;

	@Column(name = "idtipodoc")
	private Integer documentoId;

	@Column(name = "idestado")
	private Integer estadoId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	private OffsetDateTime fecha;
	
}
