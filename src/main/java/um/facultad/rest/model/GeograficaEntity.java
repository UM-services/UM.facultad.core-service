/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

/**
 * @author daniel
 *
 */
@Getter
@Setter
@Entity
@Table(name = "geografica")
@NoArgsConstructor
@AllArgsConstructor
public class GeograficaEntity implements Serializable {
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 1455943431577545429L;

	@Id
	@Column(name = "geo_id")
	private Integer geograficaId;
	
	@Column(name = "geo_nombre")
	private String nombre = "";

}
