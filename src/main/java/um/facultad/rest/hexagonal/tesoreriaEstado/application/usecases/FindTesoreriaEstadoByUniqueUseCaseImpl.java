package um.facultad.rest.hexagonal.tesoreriaEstado.application.usecases;

import lombok.RequiredArgsConstructor;
import um.facultad.rest.hexagonal.tesoreriaEstado.domain.model.TesoreriaEstado;
import um.facultad.rest.hexagonal.tesoreriaEstado.domain.ports.in.FindTesoreriaEstadoByUniqueUseCase;
import um.facultad.rest.hexagonal.tesoreriaEstado.domain.ports.out.TesoreriaEstadoRepository;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindTesoreriaEstadoByUniqueUseCaseImpl implements FindTesoreriaEstadoByUniqueUseCase {

    private final TesoreriaEstadoRepository tesoreriaEstadoRepository;

    @Override
    public Optional<TesoreriaEstado> findByUnique(Integer facultadId, BigDecimal personaId, Integer documentoId) {
        return tesoreriaEstadoRepository.findByUnique(facultadId, personaId, documentoId);
    }
}
