package um.facultad.rest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import um.facultad.rest.model.DomicilioEntity;
import um.facultad.rest.model.InscripcionEntity;
import um.facultad.rest.model.InscripcionPagoEntity;
import um.facultad.rest.model.PersonaEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionFullDto {

    private InscripcionEntity inscripcion;
    private InscripcionPagoEntity inscripcionPago;
    private PersonaEntity personaPago;
    private DomicilioEntity domicilioPago;

}
