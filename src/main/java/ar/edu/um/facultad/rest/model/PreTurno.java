/**
 * 
 */
package ar.edu.um.facultad.rest.model;

import java.io.Serializable;
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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "ptu_fac_id", "ptu_lec_id", "ptu_geo_id", "ptu_id" }) })
@NoArgsConstructor
@AllArgsConstructor
public class PreTurno implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -605744090982336713L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clave")
	protected Long uniqueId;

	@Column(name = "ptu_fac_id")
	protected Integer facultadId;

	@Column(name = "ptu_lec_id")
	protected Integer lectivoId;

	@Column(name = "ptu_geo_id")
	protected Integer geograficaId;

	@Column(name = "ptu_id")
	protected Integer turnoId;

	@Column(name = "ptu_nombre")
	protected String nombre;

	@Column(name = "ptu_inicio")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	protected OffsetDateTime inicio;

	@Column(name = "ptu_fin")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	protected OffsetDateTime fin;

}
