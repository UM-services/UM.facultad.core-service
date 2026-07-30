package um.facultad.rest.hexagonal.carreras.carrera.infrastructure.persistence.entity;

import java.io.Serial;
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
import jakarta.persistence.UniqueConstraint;
import lombok.*;
import um.facultad.rest.hexagonal.carreras.plan.infrastructure.persistence.entity.PlanEntity;

@Getter
@Setter
@Builder
@Entity
@Table(name = "carrera", uniqueConstraints = { @UniqueConstraint(columnNames = { "idfacultad", "idplan", "idcarrera" }) })
@NoArgsConstructor
@AllArgsConstructor
public class CarreraEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3070042925813132864L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clave")
    private Long uniqueId;

    @Column(name = "idfacultad")
    private Integer facultadId;

    @Column(name = "idplan")
    private Integer planId;

    @Column(name = "idcarrera")
    private Integer carreraId;

    @Builder.Default
    private String nombre = "";

    @Builder.Default
    private String iniciales = "";

    @Builder.Default
    private String titulo = "";

    @Builder.Default
    @Column(name = "car_trabajo_final")
    private Byte trabajoFinal = 0;

    @Builder.Default
    @Column(name = "car_resolucion")
    private String resolucion = "";

    @Builder.Default
    @Column(name = "car_chequnica")
    private Byte chequeraUnica = 0;

    @Column(name = "car_blo_id")
    private Integer bloqueId;

    @Builder.Default
    @Column(name = "car_obligatorias")
    private Integer obligatorias = 0;

    @Builder.Default
    @Column(name = "car_optativas")
    private Integer optativas = 0;

    @Builder.Default
    private Byte vigente = 0;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "idfacultad", referencedColumnName = "idfacultad", insertable = false, updatable = false),
            @JoinColumn(name = "idplan", referencedColumnName = "idplan", insertable = false, updatable = false) })
    private PlanEntity plan;

    public String getKey() {
        return this.facultadId + "." + this.planId + "." + this.carreraId;
    }

}
