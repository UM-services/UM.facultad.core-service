package um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out.DomicilioRepository;
import um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.mapper.DomicilioMapper;
import um.facultad.rest.hexagonal.personas.domicilio.infrastructure.persistence.repository.JpaDomicilioRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaDomicilioRepositoryAdapter implements DomicilioRepository {

    private final JpaDomicilioRepository jpaDomicilioRepository;
    private final DomicilioMapper domicilioMapper;

    @Override
    public Optional<Domicilio> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId) {
        return jpaDomicilioRepository.findByPersonaIdAndDocumentoId(personaId, documentoId)
                .map(domicilioMapper::toDomain);
    }

    @Override
    public Domicilio save(Domicilio domicilio) {
        return domicilioMapper.toDomain(jpaDomicilioRepository.save(domicilioMapper.toEntity(domicilio)));
    }

}
