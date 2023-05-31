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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author daniel
 *
 */
@Data
@Entity
@Table
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class SetupApi extends Auditable implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5751182299763072596L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long setupId;
	
	@Column(name = "api_server_tesoreria")
	private String apiservertesoreria = "";

	@Column(name = "api_port_tesoreria")
	private Long apiporttesoreria = 0L;

}
