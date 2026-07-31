package um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in;

import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;

import java.math.BigDecimal;
import java.util.Optional;

public interface FindDomicilioByPagadorUseCase {

    Optional<Domicilio> findDomicilioByPagador(BigDecimal personaId, Integer documentoId);

}
