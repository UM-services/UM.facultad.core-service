package um.facultad.rest.hexagonal.matriculacion.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Materia {

    private Plan plan;
    private String materiaId;
    private String nombre;

}
