/**
 * 
 */
package ar.edu.um.facultad.rest.model;

import java.io.Serializable;

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
@Table(name = "documento")
@NoArgsConstructor
@AllArgsConstructor
public class Documento implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -4488497020106093903L;

	@Id
	@Column(name = "idtipodoc")
	private Integer documentoId;

	private String nombre = "";

}
