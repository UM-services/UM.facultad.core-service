package um.facultad.rest.hexagonal.personas.persona.domain.ports.out;

import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PersonaRepository {

    Optional<Persona> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

    List<Persona> findAllByPersonaIdIn(List<BigDecimal> personaIds);

}
