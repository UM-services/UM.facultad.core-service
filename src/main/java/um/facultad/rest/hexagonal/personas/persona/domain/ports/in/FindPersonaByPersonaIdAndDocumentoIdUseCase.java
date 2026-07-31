package um.facultad.rest.hexagonal.personas.persona.domain.ports.in;

import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;

import java.math.BigDecimal;
import java.util.Optional;

public interface FindPersonaByPersonaIdAndDocumentoIdUseCase {

    Optional<Persona> findPersonaByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

}
