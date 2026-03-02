package um.facultad.rest.hexagonal.matriculacion.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatriculacionContext {

    private Persona persona;
    private Inscripcion inscripcion;

}
