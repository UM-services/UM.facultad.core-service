package um.facultad.rest.hexagonal.matriculacion.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Carrera {

    private Plan plan;
    private Integer carreraId;
    private String nombre;
    private Byte vigente;

}
