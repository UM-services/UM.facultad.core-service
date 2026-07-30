package um.facultad.rest.hexagonal.carreras.materia.domain.model;

import lombok.*;
import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Materia {

    private Plan plan;
    private Integer facultadId;
    private Integer planId;
    private String materiaId;
    private String nombre;
    private Integer catedraId;

    @Builder.Default
    private Byte optativa = 0;

    @Builder.Default
    private Integer virtual = 0;

    @Builder.Default
    private Integer dias = 0;

    @Builder.Default
    private Integer periodoId = 0;

    @Builder.Default
    private Byte especial = 0;

    @Builder.Default
    private Byte taller = 0;

    @Builder.Default
    private Byte soloAnalitico = 0;

    private String materiaIdReal;

    @Builder.Default
    private Integer curso = 0;

}
