package um.facultad.rest.hexagonal.personas.persona.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;
import um.facultad.rest.hexagonal.personas.persona.domain.ports.out.PersonaRepository;
import um.facultad.rest.hexagonal.personas.persona.infrastructure.persistence.mapper.PersonaMapper;
import um.facultad.rest.hexagonal.personas.persona.infrastructure.persistence.repository.JpaPersonaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaPersonaRepositoryAdapter implements PersonaRepository {

    private final JpaPersonaRepository jpaPersonaRepository;
    private final PersonaMapper personaMapper;

    @Override
    public Optional<Persona> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId) {
        return jpaPersonaRepository.findByPersonaIdAndDocumentoId(personaId, documentoId)
                .map(personaMapper::toDomain);
    }

    @Override
    public List<Persona> findAllByPersonaIdIn(List<BigDecimal> personaIds) {
        return jpaPersonaRepository.findAllByPersonaIdIn(personaIds, Sort.by("apellido").ascending().and(Sort.by("nombre").ascending()))
                .stream()
                .map(personaMapper::toDomain)
                .toList();
    }

}
