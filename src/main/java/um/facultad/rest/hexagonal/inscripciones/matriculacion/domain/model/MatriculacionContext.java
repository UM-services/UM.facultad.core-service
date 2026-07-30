package um.facultad.rest.hexagonal.inscripciones.matriculacion.domain.model;

import lombok.*;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatriculacionContext {

    private Persona persona;
    private Inscripcion inscripcion;

}
