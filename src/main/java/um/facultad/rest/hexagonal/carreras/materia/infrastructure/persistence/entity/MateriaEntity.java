package um.facultad.rest.hexagonal.carreras.materia.infrastructure.persistence.entity;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;
import um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.entity.PlanEntity;

@Getter
@Setter
@Builder
@Entity
@Table(name = "materia", uniqueConstraints = {@UniqueConstraint(columnNames = {"idfacultad", "idplan", "idmateria"})})
@NoArgsConstructor
@AllArgsConstructor
public class MateriaEntity implements Serializable {

	@Serial
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

	@Builder.Default
	private String nombre = "";

	@Column(name = "mat_opcional")
	@Builder.Default
	private Byte optativa = 0;

	@Column(name = "mat_virtual")
	@Builder.Default
	private Integer virtual = 0;

	@Column(name = "mat_dias")
	@Builder.Default
	private Integer dias = 0;

	@Column(name = "mat_per_id")
	@Builder.Default
	private Integer periodoId = 0;

	@Column(name = "mat_especial")
	@Builder.Default
	private Byte especial = 0;

	@Column(name = "mat_taller")
	@Builder.Default
	private Byte taller = 0;

	@Column(name = "mat_soloanalit")
	@Builder.Default
	private Byte soloAnalitico = 0;

	@Column(name = "mat_id_real")
	private String materiaIdReal;

	@Column(name = "mat_curso")
	@Builder.Default
	private Integer curso = 0;

	@OneToOne
	@JoinColumns({
			@JoinColumn(name = "idfacultad", referencedColumnName = "idfacultad", insertable = false, updatable = false),
			@JoinColumn(name = "idplan", referencedColumnName = "idplan", insertable = false, updatable = false) })
	private PlanEntity plan;

}
