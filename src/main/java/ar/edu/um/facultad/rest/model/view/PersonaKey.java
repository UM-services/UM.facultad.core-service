/**
 * 
 */
package ar.edu.um.facultad.rest.model.view;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
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
@Table(name = "vw_persona_key")
@Immutable
@NoArgsConstructor
@AllArgsConstructor
public class PersonaKey implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2892747011251907823L;

	@Id
	private Long uniqueId;

	private BigDecimal personaId;
	private Integer documentoId;
	private String apellido;
	private String nombre;
	private String sexo;
	private Integer profesionId;
	private String mascara;

	@Column(name = "key")
	private String unified;

}
