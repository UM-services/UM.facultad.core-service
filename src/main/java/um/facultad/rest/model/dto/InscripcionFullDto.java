package um.facultad.rest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import um.facultad.rest.model.Domicilio;
import um.facultad.rest.model.Inscripcion;
import um.facultad.rest.model.InscripcionPago;
import um.facultad.rest.model.Persona;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionFullDto {

    private Inscripcion inscripcion;
    private InscripcionPago inscripcionPago;
    private Persona personaPago;
    private Domicilio domicilioPago;

}
