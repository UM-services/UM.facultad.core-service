/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "idfacultad", "idplan", "idcarrera" }) })
@NoArgsConstructor
@AllArgsConstructor
public class Carrera implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3070042925813132864L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clave")
	private Long uniqueId;

	@Column(name = "idfacultad")
	private Integer facultadId;

	@Column(name = "idplan")
	private Integer planId;

	@Column(name = "idcarrera")
	private Integer carreraId;

	private String nombre = "";
	private String iniciales = "";
	private String titulo = "";

	@Column(name = "car_trabajo_final")
	private Byte trabajoFinal = 0;

	@Column(name = "car_resolucion")
	private String resolucion = "";

	@Column(name = "car_chequnica")
	private Byte chequeraUnica = 0;

	@Column(name = "car_blo_id")
	private Integer bloqueId;

	@Column(name = "car_obligatorias")
	private Integer obligatorias = 0;

	@Column(name = "car_optativas")
	private Integer optativas = 0;

	private Byte vigente = 0;

	@OneToOne
	@JoinColumns({
			@JoinColumn(name = "idfacultad", referencedColumnName = "idfacultad", insertable = false, updatable = false),
			@JoinColumn(name = "idplan", referencedColumnName = "idplan", insertable = false, updatable = false) })
	private Plan plan;

	public String getKey() {
		return this.facultadId + "." + this.planId + "." + this.carreraId;
	}

}
