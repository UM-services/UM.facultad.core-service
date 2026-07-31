package um.facultad.rest.hexagonal.personas.persona.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;
import um.facultad.rest.hexagonal.personas.persona.domain.ports.in.FindPersonaByPersonaIdAndDocumentoIdUseCase;
import um.facultad.rest.hexagonal.personas.persona.domain.ports.out.PersonaRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindPersonaByPersonaIdAndDocumentoIdUseCaseImpl implements FindPersonaByPersonaIdAndDocumentoIdUseCase {

    private final PersonaRepository personaRepository;

    @Override
    public Optional<Persona> findPersonaByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId) {
        return personaRepository.findByPersonaIdAndDocumentoId(personaId, documentoId);
    }

}
