/**
 * 
 */
package um.facultad.rest.model.view;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "vw_inscriptos_curso")
@NoArgsConstructor
@AllArgsConstructor
public class InscriptoCurso implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2815851181961541861L;

	@Id
	private String uniqueId;

	private Integer lectivoId;
	private Integer facultadId;
	private Integer planId;
	private Integer carreraId;
	private Integer curso;
	private Integer geograficaId;
	private Byte provisoria = 0;
	private Integer cantidad = 0;
	private Integer bajas = 0;
	private Integer egresos = 0;

}
