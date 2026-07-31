package um.facultad.rest.hexagonal.personas.domicilio.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in.AddDomicilioUseCase;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in.SincronizeDomicilioUseCase;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in.UpdateDomicilioUseCase;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out.DomicilioRepository;

@Component
@RequiredArgsConstructor
public class SincronizeDomicilioUseCaseImpl implements SincronizeDomicilioUseCase {

    private final DomicilioRepository domicilioRepository;
    private final AddDomicilioUseCase addDomicilioUseCase;
    private final UpdateDomicilioUseCase updateDomicilioUseCase;

    @Override
    public Domicilio sincronize(Domicilio domicilio) {
        Domicilio existing = domicilioRepository.findByPersonaIdAndDocumentoId(
                domicilio.getPersonaId(), domicilio.getDocumentoId()).orElse(null);
        if (existing == null || existing.getDomicilioId() == null) {
            return addDomicilioUseCase.add(domicilio, false);
        }
        return updateDomicilioUseCase.update(domicilio, existing.getPersonaId(), existing.getDocumentoId(), false)
                .orElseGet(() -> addDomicilioUseCase.add(domicilio, false));
    }

}
