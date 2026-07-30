package um.facultad.rest.hexagonal.inscripciones.matriculacion.domain.ports.in;

import um.facultad.rest.hexagonal.inscripciones.matriculacion.domain.model.Persona;

import java.math.BigDecimal;

public interface GetPersonaDataUseCase {

    Persona getPersona(BigDecimal personaId, Integer documentoId);

}
