/**
 * 
 */
package um.facultad.rest.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "inscripcionpago", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "ipg_per_id", "ipg_doc_id", "ipg_fac_id", "ipg_lec_id" }) })
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionPago implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5575856187906637330L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ipg_id")
	private Long inscripcionpagoId;

	@Column(name = "ipg_per_id")
	private BigDecimal personaId;

	@Column(name = "ipg_doc_id")
	private Integer documentoId;

	@Column(name = "ipg_fac_id")
	private Integer facultadId;

	@Column(name = "ipg_lec_id")
	private Integer lectivoId;
	
	@Column(name = "ipg_per_id_paga")
	private BigDecimal personaIdpagador;

	@Column(name = "ipg_doc_id_paga")
	private Integer documentoIdpagador;

}
