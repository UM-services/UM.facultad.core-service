/**
 * 
 */
package ar.edu.um.facultad.rest.model;

import java.io.Serializable;
import java.math.BigDecimal;

import ar.edu.um.facultad.rest.model.pk.PersonaPk;
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
@IdClass(PersonaPk.class)
@NoArgsConstructor
@AllArgsConstructor
public class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6147231331820466299L;

	@Id
	@Column(name = "iddocumento")
	private BigDecimal personaId;

	@Id
	@Column(name = "idtipodoc")
	private Integer documentoId;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long uniqueId;

	private String apellido;
	private String nombre;
	private String sexo;

	@Column(name = "per_pro_id")
	private Integer profesionId;

	@Column(name = "per_mascara")
	private String mascara;

}
