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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
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
public class Materia implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 748358330549750134L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long uniqueId;

	@Column(name = "idfacultad")
	private Integer facultadId;

	@Column(name = "idplan")
	private Integer planId;

	@Column(name = "idmateria")
	private String materiaId;

	@Column(name = "mat_ctd_id")
	private Integer catedraId;

	private String nombre = "";

	@Column(name = "mat_opcional")
	private Byte optativa = 0;

	@Column(name = "mat_virtual")
	private Integer virtual = 0;

	@Column(name = "mat_dias")
	private Integer dias = 0;

	@Column(name = "mat_per_id")
	private Integer periodoId = 0;

	@Column(name = "mat_especial")
	private Byte especial = 0;

	@Column(name = "mat_taller")
	private Byte taller = 0;

	@Column(name = "mat_soloanalit")
	private Byte soloAnalitico = 0;

	@Column(name = "mat_id_real")
	private String materiaIdReal;

	@Column(name = "mat_curso")
	private Integer curso = 0;

	@OneToOne
	@JoinColumns({
			@JoinColumn(name = "idfacultad", referencedColumnName = "idfacultad", insertable = false, updatable = false),
			@JoinColumn(name = "idplan", referencedColumnName = "idplan", insertable = false, updatable = false) })
	private Plan plan;

}
