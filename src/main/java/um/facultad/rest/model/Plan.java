/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "idfacultad", "idplan" }) })
@NoArgsConstructor
@AllArgsConstructor
public class Plan implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2932421234507066313L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clave")
	private Long uniqueId;

	@Column(name = "idfacultad")
	private Integer facultadId;

	@Column(name = "idplan")
	private Integer planId;

	private String nombre = "";

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
	protected OffsetDateTime fecha;

	@Column(name = "pla_publicar")
	private Byte publicar = 0;

	@Column(name = "pla_semanas")
	private Integer semanas = 0;
	
	@OneToOne
	@JoinColumn(name = "idfacultad", insertable = false, updatable = false)
	private Facultad facultad;

	public String getKey() {
		return this.facultadId + "." + this.planId;
	}

}
