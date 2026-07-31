package um.facultad.rest.hexagonal.personas.persona.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;
import um.facultad.rest.hexagonal.personas.persona.domain.ports.in.FindAllPersonasByPersonaIdInUseCase;
import um.facultad.rest.hexagonal.personas.persona.domain.ports.out.PersonaRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllPersonasByPersonaIdInUseCaseImpl implements FindAllPersonasByPersonaIdInUseCase {

    private final PersonaRepository personaRepository;

    @Override
    public List<Persona> findAllByPersonaIdIn(List<BigDecimal> personaIds) {
        return personaRepository.findAllByPersonaIdIn(personaIds);
    }

}
