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
@Table(name = "matxcurso", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "idfacultad", "idplan", "idcarrera", "idmateria" }) })
@NoArgsConstructor
@AllArgsConstructor
public class MateriaCurso implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4685354015708449239L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mxu_id")
	private Long materiacursoId;

	@Column(name = "idfacultad")
	private Integer facultadId;
	
	@Column(name = "idplan")
	private Integer planId;
	
	@Column(name = "idcarrera")
	private Integer carreraId;

	@Column(name = "idmateria")
	private String materiaId;

	@Column(name = "curso")
	private Integer curso;
	
	@Column(name = "periodo")
	private Integer periodo;
	
}
