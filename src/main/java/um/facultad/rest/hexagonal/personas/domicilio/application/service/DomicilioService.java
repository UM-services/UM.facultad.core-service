package um.facultad.rest.hexagonal.personas.domicilio.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import um.facultad.rest.hexagonal.personas.domicilio.application.exception.DomicilioException;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in.AddDomicilioUseCase;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in.FindDomicilioByPagadorUseCase;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in.FindDomicilioByPersonaIdAndDocumentoIdUseCase;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in.SincronizeDomicilioUseCase;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in.UpdateDomicilioUseCase;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DomicilioService {

    private final FindDomicilioByPersonaIdAndDocumentoIdUseCase findDomicilioByPersonaIdAndDocumentoIdUseCase;
    private final FindDomicilioByPagadorUseCase findDomicilioByPagadorUseCase;
    private final AddDomicilioUseCase addDomicilioUseCase;
    private final UpdateDomicilioUseCase updateDomicilioUseCase;
    private final SincronizeDomicilioUseCase sincronizeDomicilioUseCase;

    public Domicilio findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId) {
        return findDomicilioByPersonaIdAndDocumentoIdUseCase.findDomicilioByPersonaIdAndDocumentoId(personaId, documentoId)
                .orElseGet(Domicilio::new);
    }

    public Domicilio findByPagador(BigDecimal personaId, Integer documentoId) {
        return findDomicilioByPagadorUseCase.findDomicilioByPagador(personaId, documentoId)
                .orElseGet(Domicilio::new);
    }

    public Domicilio add(Domicilio domicilio, Boolean sincronize) {
        return addDomicilioUseCase.add(domicilio, sincronize);
    }

    public Domicilio update(Domicilio domicilio, BigDecimal personaId, Integer documentoId, Boolean sincronize) {
        return updateDomicilioUseCase.update(domicilio, personaId, documentoId, sincronize)
                .orElseThrow(() -> new DomicilioException(personaId, documentoId));
    }

    public Domicilio sincronize(Domicilio domicilio) {
        return sincronizeDomicilioUseCase.sincronize(domicilio);
    }

}
