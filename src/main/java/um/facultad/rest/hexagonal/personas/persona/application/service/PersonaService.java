package um.facultad.rest.hexagonal.personas.persona.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;
import um.facultad.rest.hexagonal.personas.persona.domain.ports.in.FindAllPersonasByPersonaIdInUseCase;
import um.facultad.rest.hexagonal.personas.persona.domain.ports.in.FindPersonaByPersonaIdAndDocumentoIdUseCase;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final FindPersonaByPersonaIdAndDocumentoIdUseCase findPersonaByPersonaIdAndDocumentoIdUseCase;
    private final FindAllPersonasByPersonaIdInUseCase findAllPersonasByPersonaIdInUseCase;

    public Persona findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId) {
        return findPersonaByPersonaIdAndDocumentoIdUseCase.findPersonaByPersonaIdAndDocumentoId(personaId, documentoId)
                .orElseGet(Persona::new);
    }

    public List<Persona> findAllByPersonaIdIn(List<BigDecimal> personaIds) {
        return findAllPersonasByPersonaIdInUseCase.findAllByPersonaIdIn(personaIds);
    }

}
