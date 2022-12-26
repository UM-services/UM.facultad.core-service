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
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Facultad implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2805822200533263537L;

	@Id
	@Column(name = "idfacultad")
	private Integer facultadId;

	private String nombre = "";

	@Column(name = "fac_acron")
	private String acronimo = "";
	
}
