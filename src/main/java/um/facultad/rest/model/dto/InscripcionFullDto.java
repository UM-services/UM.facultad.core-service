package um.facultad.rest.model.dto;

import lombok.*;
import um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.model.InscripcionPago;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;
import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionFullDto {

    private Inscripcion inscripcion;
    private InscripcionPago inscripcionPago;
    private Persona personaPago;
    private Domicilio domicilioPago;

}
