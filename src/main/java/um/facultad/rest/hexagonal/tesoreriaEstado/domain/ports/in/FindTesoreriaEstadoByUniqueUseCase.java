package um.facultad.rest.hexagonal.tesoreriaEstado.domain.ports.in;

import um.facultad.rest.hexagonal.tesoreriaEstado.domain.model.TesoreriaEstado;

import java.math.BigDecimal;
import java.util.Optional;

public interface FindTesoreriaEstadoByUniqueUseCase {
    Optional<TesoreriaEstado> findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId);
}
