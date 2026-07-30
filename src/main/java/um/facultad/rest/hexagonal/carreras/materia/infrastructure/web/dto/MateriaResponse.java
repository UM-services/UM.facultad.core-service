package um.facultad.rest.hexagonal.carreras.materia.infrastructure.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MateriaResponse {

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

    private String planNombre;

}
