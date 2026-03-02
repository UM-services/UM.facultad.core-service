package um.facultad.rest.hexagonal.matriculacion.domain.model;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {

    private OffsetDateTime fecha;
    private Carrera carrera;
    private List<Materia> materias;

}
