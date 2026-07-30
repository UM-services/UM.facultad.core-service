/**
 * 
 */
package um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.entity;

import java.io.Serial;
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
import lombok.*;
import um.facultad.rest.model.FacultadEntity;

/**
 * @author daniel
 *
 */
@Getter
@Setter
@Builder
@Entity
@Table(name = "plan", uniqueConstraints = { @UniqueConstraint(columnNames = { "idfacultad", "idplan" }) })
@NoArgsConstructor
@AllArgsConstructor
public class PlanEntity implements Serializable {
	/**
	* 
	*/
	@Serial
    private static final long serialVersionUID = 2932421234507066313L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clave")
	private Long uniqueId;

	@Column(name = "idfacultad")
	private Integer facultadId;

	@Column(name = "idplan")
	private Integer planId;

	@Builder.Default
	private String nombre = "";

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXX", timezone = "UTC")
	protected OffsetDateTime fecha;

	@Column(name = "pla_publicar")
	@Builder.Default
	private Byte publicar = 0;

	@Column(name = "pla_semanas")
	@Builder.Default
	private Integer semanas = 0;
	
	@OneToOne
	@JoinColumn(name = "idfacultad", insertable = false, updatable = false)
	private FacultadEntity facultad;

	public String getKey() {
		return this.facultadId + "." + this.planId;
	}

}
