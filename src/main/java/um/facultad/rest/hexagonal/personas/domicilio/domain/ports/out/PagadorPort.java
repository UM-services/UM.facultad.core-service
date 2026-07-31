package um.facultad.rest.hexagonal.personas.domicilio.domain.ports.out;

import um.facultad.rest.hexagonal.personas.domicilio.domain.model.Pagador;

import java.math.BigDecimal;
import java.util.Optional;

public interface PagadorPort {

    Optional<Pagador> findPagador(BigDecimal personaId, Integer documentoId);

}
