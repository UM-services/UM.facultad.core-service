package um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in;

import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;

import java.math.BigDecimal;
import java.util.Optional;

public interface UpdateDomicilioUseCase {

    Optional<Domicilio> update(Domicilio domicilio, BigDecimal personaId, Integer documentoId, Boolean sincronize);

}
