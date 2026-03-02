/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "setup_api")
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
public class SetupApiEntity extends Auditable implements Serializable {
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 5751182299763072596L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long setupId;
	
	@Column(name = "api_server_tesoreria")
	private String apiservertesoreria = "";

	@Column(name = "api_port_tesoreria")
	private Long apiporttesoreria = 0L;

}
