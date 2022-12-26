/**
 * 
 */
package ar.edu.um.facultad.rest.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "matxcarrera", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "idfacultad", "idplan", "idcarrera", "idmateria" }) })
@NoArgsConstructor
@AllArgsConstructor
public class MateriaCarrera implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 8398884866479267335L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mxc_id")
	private Long materiaCarreraId;

	@Column(name = "idfacultad")
	private Integer facultadId;

	@Column(name = "idplan")
	private Integer planId;

	@Column(name = "idcarrera")
	private Integer carreraId;

	@Column(name = "idmateria")
	private String materiaId;

	@Column(name = "mxc_optativa")
	private Byte optativa = 0;

	@Column(name = "mxc_horas")
	private BigDecimal horas = BigDecimal.ZERO;

	@Column(name = "mxc_creditos")
	private BigDecimal creditos = BigDecimal.ZERO;

//	@OneToOne
//	@JoinColumns({
//			@JoinColumn(name = "idfacultad", referencedColumnName = "idfacultad", insertable = false, updatable = false),
//			@JoinColumn(name = "idplan", referencedColumnName = "idplan", insertable = false, updatable = false),
//			@JoinColumn(name = "idcarrera", referencedColumnName = "idcarrera", insertable = false, updatable = false) })
//	private Carrera carrera;

//	@OneToOne
//	@JoinColumns({
//			@JoinColumn(name = "idfacultad", referencedColumnName = "idfacultad", insertable = false, updatable = false),
//			@JoinColumn(name = "idplan", referencedColumnName = "idplan", insertable = false, updatable = false),
//			@JoinColumn(name = "idmateria", referencedColumnName = "idmateria", insertable = false, updatable = false) })

	//	private Materia materia;

}
