package um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out;

import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Domicilio;

import java.math.BigDecimal;
import java.util.Optional;

public interface DomicilioRepository {

    Optional<Domicilio> findByPersonaIdAndDocumentoId(BigDecimal personaId, Integer documentoId);

    Domicilio save(Domicilio domicilio);

}
