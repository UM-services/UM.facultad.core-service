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
public class Geografica implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1455943431577545429L;

	@Id
	@Column(name = "geo_id")
	private Integer geograficaId;
	
	@Column(name = "geo_nombre")
	private String nombre = "";

}
