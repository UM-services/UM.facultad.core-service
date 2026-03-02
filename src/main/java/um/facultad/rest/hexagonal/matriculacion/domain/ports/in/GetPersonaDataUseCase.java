package um.facultad.rest.hexagonal.matriculacion.domain.ports.in;

import um.facultad.rest.hexagonal.matriculacion.domain.model.Persona;

import java.math.BigDecimal;

public interface GetPersonaDataUseCase {

    Persona getPersona(BigDecimal personaId, Integer documentoId);

}
