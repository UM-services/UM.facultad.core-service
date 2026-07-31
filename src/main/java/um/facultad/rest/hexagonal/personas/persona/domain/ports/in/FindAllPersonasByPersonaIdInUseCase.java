package um.facultad.rest.hexagonal.personas.persona.domain.ports.in;

import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;

import java.math.BigDecimal;
import java.util.List;

public interface FindAllPersonasByPersonaIdInUseCase {

    List<Persona> findAllByPersonaIdIn(List<BigDecimal> personaIds);

}
