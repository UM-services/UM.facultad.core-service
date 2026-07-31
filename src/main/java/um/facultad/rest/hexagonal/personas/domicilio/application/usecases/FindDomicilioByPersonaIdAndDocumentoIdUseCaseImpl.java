package um.facultad.rest.hexagonal.personas.domicilio.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in.FindDomicilioByPersonaIdAndDocumentoIdUseCase;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out.DomicilioRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindDomicilioByPersonaIdAndDocumentoIdUseCaseImpl implements FindDomicilioByPersonaIdAndDocumentoIdUseCase {

    private final DomicilioRepository domicilioRepository;

    @Override
    public Optional<Domicilio> findDomicilioByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId) {
        return domicilioRepository.findByPersonaIdAndDocumentoId(personaId, documentoId);
    }

}
