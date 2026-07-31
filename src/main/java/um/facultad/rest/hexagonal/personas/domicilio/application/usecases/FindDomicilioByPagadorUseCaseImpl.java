package um.facultad.rest.hexagonal.personas.domicilio.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.domicilio.application.exception.DomicilioException;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;
import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Pagador;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in.FindDomicilioByPagadorUseCase;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out.DomicilioRepository;
import um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out.PagadorPort;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindDomicilioByPagadorUseCaseImpl implements FindDomicilioByPagadorUseCase {

    private final DomicilioRepository domicilioRepository;
    private final PagadorPort pagadorPort;

    @Override
    public Optional<Domicilio> findDomicilioByPagador(BigDecimal personaId, Integer documentoId) {
        Optional<Pagador> pagador = pagadorPort.findPagador(personaId, documentoId);
        if (pagador.isEmpty()) {
            return Optional.empty();
        }
        Optional<Domicilio> domicilio = domicilioRepository.findByPersonaIdAndDocumentoId(
                pagador.get().getPersonaId(), pagador.get().getDocumentoId());
        if (domicilio.isEmpty()) {
            throw new DomicilioException(personaId, documentoId);
        }
        return domicilio;
    }

}
