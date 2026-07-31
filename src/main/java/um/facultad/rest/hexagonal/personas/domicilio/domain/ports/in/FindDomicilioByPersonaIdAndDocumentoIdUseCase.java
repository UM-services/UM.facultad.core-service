package um.facultad.rest.hexagonal.personas.domicilio.domain.ports.in;

import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;

import java.math.BigDecimal;
import java.util.Optional;

public interface FindDomicilioByPersonaIdAndDocumentoIdUseCase {

    Optional<Domicilio> findDomicilioByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

}
